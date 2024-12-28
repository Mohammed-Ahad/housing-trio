package com.ht.modals;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Entity
@Data
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// N(new) -> A(approved) | D(deleted) -> S(sold)
	@Column(nullable = false)
	private String status; 

	@Column(nullable = false)
	private String apartmentName;

	@Column(nullable = false)
	private String ownershipType;

	@ManyToOne
	private UserDetails userDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private Locality locality;

	@OneToOne(cascade = CascadeType.ALL)
	private PriceDetails priceDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private Amenities amenities;

	@OneToOne(cascade = CascadeType.ALL)
	private OtherAmenities otherAmenities;

	@OneToOne(cascade = CascadeType.ALL)
	private AdditionalInformation additionalInformation;

	private LocalDate createDate;

	private LocalDate updateDate;

	@PrePersist
	private void onCreate() {
		this.createDate = LocalDate.now();
		this.updateDate = LocalDate.now();
	}

	@PreUpdate
	private void onUpdate() {
		this.updateDate = LocalDate.now();
	}
}
