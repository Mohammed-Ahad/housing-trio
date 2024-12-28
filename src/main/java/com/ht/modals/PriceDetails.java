package com.ht.modals;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * PriceDetails class.
 * 
 * @author Mohammed Ahad
 * @since 29-Sep-2024
 */

@Entity
@Data
public class PriceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Double expectedPrice;

	@Column(nullable = false)
	private Boolean negotiable;

	@Column(nullable = false)
	private Double monthlyMaintenance;

	@Column(nullable = false)
	private Boolean isUnderLoan;

	@Column(nullable = false)
	private LocalDate possesionDate;

	@Column(nullable = false)
	private String furnishing;

	@Column(nullable = false)
	private String parking;

	@Column(nullable = false)
	private String kitchenType;

	@Column(nullable = false)
	private String propertyDescription;
}
