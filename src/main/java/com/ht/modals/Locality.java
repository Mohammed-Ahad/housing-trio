package com.ht.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Locality class.
 * 
 * @author Mohammed Ahad
 * @since 28-Sep-2024
 */

@Entity
@Data
public class Locality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String locality;

	@Column(nullable = false)
	private String streetAreaLandmark;
}
