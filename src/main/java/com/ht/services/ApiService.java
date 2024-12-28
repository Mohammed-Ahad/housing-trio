package com.ht.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ht.dto.ContactOwnerDto;
import com.ht.modals.ContactOwner;
import com.ht.modals.Property;
import com.ht.modals.UserDetails;
import com.ht.repoitories.ContactOwnerRepository;
import com.ht.repoitories.PropertyRepository;
import com.ht.repoitories.UserDetailsRepository;
import com.ht.utils.ModalUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiService {

	private final PropertyRepository propertyRepository;

	private final UserDetailsRepository userDetailsRepository;

	private final ContactOwnerRepository contactOwnerRepository;

	public ApiService(PropertyRepository propertyRepository, UserDetailsRepository userDetailsRepository,
			ContactOwnerRepository contactOwnerRepository) {
		this.propertyRepository = propertyRepository;

		this.userDetailsRepository = userDetailsRepository;

		this.contactOwnerRepository = contactOwnerRepository;
	}

	public ResponseEntity<?> sellYourProperty(Map<String, Object> data) {
		try {

			ModalUtil modalUtil = new ModalUtil();

			UserDetails userDetails = modalUtil.getUserDetails(data);

			Optional<UserDetails> op = userDetailsRepository.findByPhoneNo(userDetails.getPhoneNo());

			// save if not found
			UserDetails userDetailsBean = op.orElseGet(() -> userDetailsRepository.save(userDetails));

			Property property = modalUtil.getProperty(data);
			property.setUserDetails(userDetailsBean);

			propertyRepository.save(property);

		} catch (ClassCastException e) {
			log.error("ERROR - sellYourProperty(): Invalid data type - " + e.getMessage());
			return ResponseEntity.badRequest().body("Invalid data types provided for fields.");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ERROR - sellYourProperty(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> approveProperty(Integer propertyId) {
		try {

			Property property = propertyRepository.findById(propertyId)
					.orElseThrow(() -> new RuntimeException("Property Not found in DB"));

			property.setStatus("A");
			propertyRepository.save(property);

		} catch (Exception e) {
			log.error("ERROR - approveProperty(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> cancelProperty(Integer propertyId) {
		try {

			Property property = propertyRepository.findById(propertyId)
					.orElseThrow(() -> new RuntimeException("Property Not found in DB"));

			property.setStatus("D");
			propertyRepository.save(property);

		} catch (Exception e) {
			log.error("ERROR - cancelProperty(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> contactOwner(ContactOwnerDto contactOwnerDto) {
		String msg = "";
		try {

			// save if not exist
			UserDetails user = userDetailsRepository.findByPhoneNo(contactOwnerDto.getPhoneNo()).orElseGet(() -> {
				UserDetails userDetails = new UserDetails();
				userDetails.setFullName(contactOwnerDto.getName());
				userDetails.setEmailAddress(contactOwnerDto.getEmail());
				userDetails.setPhoneNo(contactOwnerDto.getPhoneNo());

				return userDetailsRepository.save(userDetails);
			});

			Property property = propertyRepository.findById(contactOwnerDto.getPropertyId())
					.orElseThrow(() -> new IllegalStateException("Property not found in DB"));

			ContactOwner contactOwner = new ContactOwner();
			contactOwner.setUserDetails(user);
			contactOwner.setProperty(property);

			Optional<ContactOwner> op = contactOwnerRepository.findByUserDetailsAndProperty(user, property);

			if (op.isPresent()) {
				msg = "Request already created, please wait";
				return ResponseEntity.ok(msg);
			}

			contactOwnerRepository.save(contactOwner);

		} catch (Exception e) {
			log.error("ERROR - contactOwner(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok(msg);
	}
}
