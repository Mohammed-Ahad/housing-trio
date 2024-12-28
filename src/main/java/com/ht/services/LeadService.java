package com.ht.services;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ht.dto.AddLeadRequest;
import com.ht.dto.GetLeadsRequest;
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

	public ResponseEntity<?> getLeads(GetLeadsRequest getLeadsRequest) {
		List<Lead> leads = Collections.emptyList();

		try {
			LocalDate fromDate = LocalDate.now();
			LocalDate toDate = LocalDate.now();

			// Find leads based on type
			switch (getLeadsRequest.getBasedOn()) {
			case "followUpDate": {
				leads = leadRepo.findByFollowUpDateBetween(fromDate, toDate);
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

			// leads = leadRepo.findAll();

		} catch (Exception e) {
			log.error("ERROR - getLeads(): " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred." + e.getMessage());
		}

		return ResponseEntity.ok(leads);
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
