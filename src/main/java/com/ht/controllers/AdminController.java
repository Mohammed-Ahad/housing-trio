package com.ht.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.modals.ContactOwner;
import com.ht.modals.Property;
import com.ht.services.ViewService;

/**
 * AdminController class.
 * 
 * @author Mohammed Ahad
 * @since 30-Nov-2024
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final ViewService viewService;

	public AdminController(ViewService viewService) {
		this.viewService = viewService;
	}

	@GetMapping("")
	public String admin() {
		return "Admin";
	}

	@GetMapping("/approve-properties")
	public String approveProperties(ModelMap modelMap) {

		List<Property> newPoperties = viewService.getNewProperties();
		modelMap.addAttribute("newPoperties", newPoperties);

		List<ContactOwner> contactOwners = viewService.getContactOwners();
		modelMap.addAttribute("contactOwners", contactOwners);

		List<Property> listedPoperties = viewService.getPropertyPosted();
		modelMap.addAttribute("listedPoperties", listedPoperties);

		return "ApproveProperties";
	}

	@GetMapping("/crm")
	public String approveProperties() {
		return "CRM";
	}

}
