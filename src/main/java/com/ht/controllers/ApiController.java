package com.ht.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ht.dto.AddLeadRequest;
import com.ht.dto.ContactOwnerDto;
import com.ht.dto.GetLeadsRequest;
import com.ht.dto.LeadDescriptionDto;
import com.ht.modals.Lead;
import com.ht.services.ApiService;
import com.ht.services.LeadService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final ApiService apiService;

	private final LeadService leadService;

	public ApiController(ApiService apiService, LeadService leadService) {
		this.apiService = apiService;

		this.leadService = leadService;
	}

	@PostMapping("/sell-your-property")
	public ResponseEntity<?> sellYourProperty(@RequestBody Map<String, Object> data) {
		return apiService.sellYourProperty(data);
	}

	@PostMapping("/approve-property/{propertyId}")
	public ResponseEntity<?> approveProperty(@PathVariable Integer propertyId) {
		return apiService.approveProperty(propertyId);
	}

	@PostMapping("/cancel-property/{propertyId}")
	public ResponseEntity<?> cancelProperty(@PathVariable Integer propertyId) {
		return apiService.cancelProperty(propertyId);
	}

	@PostMapping("/contact-owner")
	public ResponseEntity<?> contactOwner(@RequestBody ContactOwnerDto contactOwnerDto) {
		return apiService.contactOwner(contactOwnerDto);
	}

	@PostMapping("/save-lead")
	public ResponseEntity<?> saveLead(@RequestBody AddLeadRequest addLeadRequest) {
		return leadService.saveLead(addLeadRequest);
	}

	@GetMapping("/get-leads")
	public ResponseEntity<?> getLeads(@ModelAttribute GetLeadsRequest getLeadsRequest) {
		return leadService.getLeads(getLeadsRequest);
	}

	@GetMapping("/get-lead-descriptions/{leadId}")
	public ResponseEntity<?> getLeadDescription(@PathVariable Integer leadId) {
		return leadService.getLeadDescription(leadId);
	}

	@PostMapping("/add-description")
	public ResponseEntity<?> addDescription(@RequestBody LeadDescriptionDto leadDescriptionDto) {
		return leadService.addDescription(leadDescriptionDto);
	}

}
