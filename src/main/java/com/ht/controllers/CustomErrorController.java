package com.ht.controllers;

/**
 * CustomErrorController class.
 * 
 * @author Mohammed Ahad
 * @since 13-Oct-2024
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CustomErrorController {

	@GetMapping("/error")
	public String handleError(WebRequest webRequest, Model model) {
		return "Error"; // Return the name of the error view (JSP or HTML)
	}
}
