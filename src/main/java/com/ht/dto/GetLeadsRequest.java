package com.ht.dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * GetLeadsRequest class.
 * 
 * @author Mohammed Ahad
 * @since 08-Dec-2024
 */
@Data
public class GetLeadsRequest {
	private String basedOn;
	
	private LocalDate fromDate;
	
	private LocalDate toDate;
}
