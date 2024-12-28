package com.ht.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PropertyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Double buildUpArea;

	@Column(nullable = false)
	private Double carpetArea;

	@Column(nullable = false)
	private String flooringType;

	@Column(nullable = false)
	private String bhkType;

	@Column(nullable = false)
	private String facing;

	@Column(nullable = false)
	private String propertyAge;

	@Column(nullable = false)
	private Integer floor;

	@Column(nullable = false)
	private Integer totalFloors;
}
