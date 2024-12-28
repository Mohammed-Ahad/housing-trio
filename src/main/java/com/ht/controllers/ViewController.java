package com.ht.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ht.modals.ContactOwner;
import com.ht.modals.Property;
import com.ht.services.ViewService;

@Controller
public class ViewController {

	private ViewService viewService;

	public ViewController(ViewService viewService) {
		this.viewService = viewService;
	}

	@GetMapping({ "/home", "/" })
	public String getHome() {
		return "Home";
	}

	@GetMapping("/sell-your-property")
	public String sellYourProperty() {
		return "SellProperty";
	}

	@GetMapping("/property-posted")
	public String propertyPosted(ModelMap modelMap) {
		List<Property> propertyPosted = viewService.getPropertyPosted();
		modelMap.addAttribute("propertyPosted", propertyPosted);

		return "PropertyPosted";
	}

	@GetMapping("/property-details/{propertyId}")
	public String propertyDetails(@PathVariable Integer propertyId, ModelMap modelMap) {

		Property property = viewService.getPropertyDetails(propertyId);

		// Property not found
		if (property == null) {
			modelMap.addAttribute("message", "Requested property not found");
			return "Error";
		}

		modelMap.addAttribute("property", property);
		modelMap.addAttribute("title", "Housing Trio / Property Details");

		return "PropertyDetails";
	}
}
