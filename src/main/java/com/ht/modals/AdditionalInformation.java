package com.ht.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * AdditionaInformation class.
 * 
 * @author Mohammed Ahad
 * @since 29-Sep-2024
 */

@Entity
@Data
public class AdditionalInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String khataCertificate;

	@Column(nullable = false)
	private String saleDeedCertificate;

	@Column(nullable = false)
	private String occuapancyCertificate;

	@Column(nullable = false)
	private String propertyTax;

}
