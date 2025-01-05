package com.ht.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ht.dto.AddLeadRequest;
import com.ht.dto.GetLeadsRequest;
import com.ht.dto.LeadDTO;
import com.ht.dto.LeadDescriptionDto;
import com.ht.modals.Lead;
import com.ht.modals.LeadDescription;
import com.ht.repoitories.LeadRepo;
import com.ht.utils.StatusUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * LeadsService class.
 * 
 * @author Mohammed Ahad
 * @since 01-Dec-2024
 */

@Service
@Slf4j
public class LeadService {
	private final LeadRepo leadRepo;

	public LeadService(LeadRepo leadRepo) {
		this.leadRepo = leadRepo;
	}

	public ResponseEntity<?> getLeads(GetLeadsRequest getLeadsRequest, Authentication authentication) {
		List<LeadDTO> dtos = Collections.emptyList();

		try {

			/*
			 * if (authorities.stream() .anyMatch(authority ->
			 * authority.getAuthority().equals(ROLES.ROLE_ADMIN.getRole()))) {
			 * 
			 * } else if (authorities.stream() .anyMatch(authority ->
			 * authority.getAuthority().equals(ROLES.ROLE_USER.getRole()))) {
			 * 
			 * }
			 */
			List<Lead> leads = Collections.emptyList();
			if (getLeadsRequest.getBasedOn().equals("")) {

				LocalDateTime fromDate = getLeadsRequest.getFromDate().atStartOfDay();
				LocalDateTime toDate = getLeadsRequest.getToDate().atStartOfDay();

				leads = leadRepo.findByCreateDtBetween(fromDate, toDate);
			} else {
				leads = getBasedOnLead(getLeadsRequest);
			}

			dtos = leads.stream().map(lead -> {
				LeadDTO leadDTO = new LeadDTO();

				// Mapping fields from Lead to LeadDTO
				leadDTO.setBasedOn(getLeadsRequest.getBasedOn());

				leadDTO.setId(lead.getId());
				leadDTO.setName(lead.getName());
				leadDTO.setPhoneNo(lead.getPhoneNo());
				leadDTO.setAssignedTo(lead.getAssignedTo());
				leadDTO.setStatus(lead.getStatus());
				leadDTO.setProject(lead.getProject());
				leadDTO.setFollowUpDate(lead.getFollowUpDate());
				leadDTO.setCreateDt(lead.getCreateDt());

				return leadDTO;
			}).collect(Collectors.toList());

			//filter out user leads
			if (!authentication.getName().equals("info")) {
				dtos = dtos.stream().filter(lead -> lead.getAssignedTo().equals(authentication.getName()))
						.collect(Collectors.toList());
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("ERROR - getLeads(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok(dtos);
	}

	private List<Lead> getBasedOnLead(GetLeadsRequest getLeadsRequest) {
		List<Lead> leads = Collections.emptyList();
		// Find leads based on type
		switch (getLeadsRequest.getBasedOn()) {
		case "followUpDate": {
			LocalDateTime now = LocalDateTime.now();
			// End of the day to fetch all todays lead
			LocalDateTime endOfDay = now.with(LocalTime.MAX);
			List<String> notStatus = List.of(StatusUtil.DEAD, StatusUtil.BOOKED_AND_CLOSED);
			
			leads = leadRepo.findByFollowUpDateLessThanEqualAndStatusNotIn(endOfDay, notStatus);
			break;
		}
		case "prospect": {
			leads = leadRepo.findByStatus(StatusUtil.PROSPECT);
			break;
		}

		case "active": {
			leads = leadRepo.findByStatusNot(StatusUtil.DEAD);
			break;
		}

		case "dead": {
			leads = leadRepo.findByStatus(StatusUtil.DEAD);
			break;
		}

		case "closed": {
			leads = leadRepo.findByStatus(StatusUtil.BOOKED_AND_CLOSED);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + getLeadsRequest.getBasedOn());
		}

		return leads;
	}

	public ResponseEntity<?> saveLead(AddLeadRequest addLeadRequest) {
		try {

			Lead lead = new Lead();
			lead.setName(addLeadRequest.getName());
			lead.setPhoneNo(addLeadRequest.getPhoneNo());
			lead.setAssignedTo(addLeadRequest.getAssignedTo());
			lead.setStatus(addLeadRequest.getStatus());
			lead.setProject(addLeadRequest.getProject());
			lead.setFollowUpDate(addLeadRequest.getFollowUpDate());
			// New lead
			if (addLeadRequest.getId() == null) {
				if (!addLeadRequest.getDescription().equals("")) {
					LeadDescription description = new LeadDescription(addLeadRequest.getDescription());
					lead.setDescriptions(List.of(description));
				}

				leadRepo.save(lead);
				return ResponseEntity.ok().build();
			}

			// Update Lead
			Lead repoLead = leadRepo.findById(addLeadRequest.getId())
					.orElseThrow(() -> new RuntimeException("Lead not found in DB"));

			repoLead.setName(addLeadRequest.getName());
			repoLead.setPhoneNo(addLeadRequest.getPhoneNo());
			repoLead.setAssignedTo(addLeadRequest.getAssignedTo());
			repoLead.setStatus(addLeadRequest.getStatus());
			repoLead.setProject(addLeadRequest.getProject());
			repoLead.setFollowUpDate(addLeadRequest.getFollowUpDate());

			// Add description when its not empty
			String desc = addLeadRequest.getDescription().trim();
			if (!"".equals(desc)) {
				repoLead.getDescriptions().add(new LeadDescription(desc));
			}

			leadRepo.save(repoLead);

		} catch (Exception e) {
			log.error("ERROR - saveLead(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> getLeadDescription(Integer leadId) {
		List<LeadDescription> leadDescriptions = Collections.emptyList();

		try {
			Lead lead = leadRepo.findById(leadId).orElseThrow(() -> new RuntimeException("Lead not found in DB"));

			leadDescriptions = lead.getDescriptions();
		} catch (Exception e) {
			log.error("ERROR - getLeads(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok(leadDescriptions);
	}

	public ResponseEntity<?> addDescription(LeadDescriptionDto leadDescriptionDto) {
		List<LeadDescription> leadDescriptions = Collections.emptyList();

		try {
			Lead lead = leadRepo.findById(leadDescriptionDto.getLeadId())
					.orElseThrow(() -> new RuntimeException("Lead not found in DB"));

			LeadDescription description = new LeadDescription(leadDescriptionDto.getDescription());
			lead.getDescriptions().add(description);

			lead = leadRepo.save(lead);
			leadDescriptions = lead.getDescriptions();

		} catch (Exception e) {
			log.error("ERROR - getLeads(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok(leadDescriptions);
	}
}
