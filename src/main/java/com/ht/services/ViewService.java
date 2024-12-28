package com.ht.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ht.modals.ContactOwner;
import com.ht.modals.Property;
import com.ht.repoitories.ContactOwnerRepository;
import com.ht.repoitories.PropertyRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * ViewService class.
 * 
 * @author Mohammed Ahad
 * @since 09-Oct-2024
 */

@Service
@Slf4j
public class ViewService {

	private final PropertyRepository propertyRepository;

	private final ContactOwnerRepository contactOwnerRepository;

	public ViewService(PropertyRepository propertyRepository, ContactOwnerRepository contactOwnerRepository) {
		this.propertyRepository = propertyRepository;

		this.contactOwnerRepository = contactOwnerRepository;
	}

	public List<Property> getNewProperties() {
		List<Property> newProperties = Collections.emptyList();

		try {
			newProperties = propertyRepository.findByStatus("N");

		} catch (Exception e) {
			log.error("Somthing went wrong {}", e.getMessage());
		}

		return newProperties;
	}

	public List<Property> getPropertyPosted() {
		List<Property> propertyPosted = Collections.emptyList();

		try {
			propertyPosted = propertyRepository.findByStatus("A");

		} catch (Exception e) {
			log.error("Somthing went wrong {}", e.getMessage());
		}

		return propertyPosted;
	}

	public List<ContactOwner> getContactOwners() {
		List<ContactOwner> contactOwners = Collections.emptyList();
		try {

			contactOwners = contactOwnerRepository.findByActive(true);
		} catch (Exception e) {
			log.error("Somthing went wrong {}", e.getMessage());
		}

		return contactOwners;
	}

	public Property getPropertyDetails(Integer propertyId) {

		Property property = null;

		try {
			property = propertyRepository.findById(propertyId).orElse(null);

		} catch (Exception e) {
			log.error("Somthing went wrong {}", e.getMessage());
		}

		return property;
	}

}
