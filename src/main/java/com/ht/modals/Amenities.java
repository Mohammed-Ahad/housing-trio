package com.ht.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Amenities class.
 * 
 * @author Mohammed Ahad
 * @since 29-Sep-2024
 */
@Entity
@Data
public class Amenities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer bathrooms;

	@Column(nullable = false)
	private Integer balconies;

	@Column(nullable = false)
	private String whoWillShow;

	@Column(nullable = false)
	private Boolean gatedSecurity;

	@Column(nullable = false)
	private Boolean gym;

	@Column(nullable = false)
	private String waterSupply;

	@Column(nullable = false)
	private String powerBackup;
}
