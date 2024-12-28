package com.ht.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * OtherAmenities class.
 * 
 * @author Mohammed Ahad
 * @since 29-Sep-2024
 */

@Entity
@Data
public class OtherAmenities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Boolean airConditioner;

	@Column(nullable = false)
	private Boolean playGround;

	@Column(nullable = false)
	private Boolean rainWaterHarvesting;

	@Column(nullable = false)
	private Boolean lift;

	@Column(nullable = false)
	private Boolean houseKeeper;

	@Column(nullable = false)
	private Boolean shoppingCenter;

	@Column(nullable = false)
	private Boolean intercom;

	@Column(nullable = false)
	private Boolean internet;

	@Column(nullable = false)
	private Boolean club;

	@Column(nullable = false)
	private Boolean gas;

	@Column(nullable = false)
	private Boolean sewage;

	@Column(nullable = false)
	private Boolean fireAlarm;

	@Column(nullable = false)
	private Boolean park;

	@Column(nullable = false)
	private Boolean swimmingPool;

	@Column(nullable = false)
	private Boolean visitorParking;

}
