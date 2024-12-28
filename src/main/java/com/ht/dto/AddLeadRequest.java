package com.ht.dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * AddLeadRequest class.
 * 
 * @author Mohammed Ahad
 * @since 05-Dec-2024
 */

@Data
public class AddLeadRequest {

	private Integer id;

	private String name;

	private String phoneNo;

	private String assignedTo;

	private String status;

	private String project;

	private String description;

	private LocalDate followUpDate;
}
