package com.ht.utils;

import java.time.LocalDate;
import java.util.Map;

import com.ht.modals.AdditionalInformation;
import com.ht.modals.Amenities;
import com.ht.modals.Locality;
import com.ht.modals.OtherAmenities;
import com.ht.modals.PriceDetails;
import com.ht.modals.Property;
import com.ht.modals.PropertyDetails;
import com.ht.modals.UserDetails;

/**
 * ModalUtil class.
 * 
 * @author Mohammed Ahad
 * @since 28-Sep-2024
 */

public class ModalUtil {

	public UserDetails getUserDetails(Map<String, Object> data) {
		UserDetails userDetails = new UserDetails();

		long phoneNo = Long.parseLong((String) data.get("mobileNumber"));
		String fullName = (String) data.get("fullName");
		String emailAddress = (String) data.get("email");

		userDetails.setPhoneNo(phoneNo);
		userDetails.setFullName(fullName);
		userDetails.setEmailAddress(emailAddress);

		return userDetails;
	}

	public Property getProperty(Map<String, Object> data) {
		Property property = new Property();

		String apartmentName = (String) data.get("apartmentName");
		String ownershipType = (String) data.get("ownershipType");

		property.setApartmentName(apartmentName);
		property.setOwnershipType(ownershipType);
		property.setStatus("N");

		PropertyDetails propertyDetails = getPropertyDetails(data);
		property.setPropertyDetails(propertyDetails);

		Boolean letUsHelp = ((String) data.getOrDefault("letUsHelp", "off")).equals("on");

		if (!letUsHelp) {
			
			Locality locality = getLocality(data);
			property.setLocality(locality);

			PriceDetails priceDetails = getPriceDetails(data);
			property.setPriceDetails(priceDetails);

			Amenities amenities = getAmenities(data);
			property.setAmenities(amenities);

			OtherAmenities otherAmenities = getOtherAmenitoes(data);
			property.setOtherAmenities(otherAmenities);

			AdditionalInformation additionalInformation = getAdditionalInformation(data);
			property.setAdditionalInformation(additionalInformation);

		}
		return property;
	}

	private AdditionalInformation getAdditionalInformation(Map<String, Object> data) {
		AdditionalInformation additionalInformation = new AdditionalInformation();

		String khataCertificate = (String) data.getOrDefault("khataCertificate", "NA");
		String saleDeedCertificate = (String) data.getOrDefault("saleDeedCertificate", "NA");
		String occupancyCertificate = (String) data.getOrDefault("occupancyCertificate", "NA");
		String propertyTax = (String) data.getOrDefault("propertyTax", "NA");

		additionalInformation.setKhataCertificate(khataCertificate);
		additionalInformation.setSaleDeedCertificate(saleDeedCertificate);
		additionalInformation.setOccuapancyCertificate(occupancyCertificate);
		additionalInformation.setPropertyTax(propertyTax);

		return additionalInformation;
	}

	private OtherAmenities getOtherAmenitoes(Map<String, Object> data) {
		OtherAmenities otherAmenities = new OtherAmenities();

		Boolean airConditioner = ((String) data.getOrDefault("airConditioner", "off")).equals("on");
		Boolean playGround = ((String) data.getOrDefault("playground", "off")).equals("on");
		Boolean rainWaterHarvesting = ((String) data.getOrDefault("rainWaterHarvesting", "off")).equals("on");
		Boolean lift = ((String) data.getOrDefault("lift", "off")).equals("on");
		Boolean houseKeeper = ((String) data.getOrDefault("houseKeeper", "off")).equals("on");
		Boolean shoppingCenter = ((String) data.getOrDefault("shoppingCenter", "off")).equals("on");
		Boolean intercom = ((String) data.getOrDefault("intercom", "off")).equals("on");
		Boolean internet = ((String) data.getOrDefault("internet", "off")).equals("on");
		Boolean club = ((String) data.getOrDefault("club", "off")).equals("on");
		Boolean gas = ((String) data.getOrDefault("gas", "off")).equals("on");
		Boolean sewage = ((String) data.getOrDefault("sewage", "off")).equals("on");
		Boolean fireAlarm = ((String) data.getOrDefault("fireAlarm", "off")).equals("on");
		Boolean park = ((String) data.getOrDefault("park", "off")).equals("on");
		Boolean swimmingPool = ((String) data.getOrDefault("swimmingPool", "off")).equals("on");
		Boolean visitorParking = ((String) data.getOrDefault("visitorParking", "off")).equals("on");

		otherAmenities.setAirConditioner(airConditioner);
		otherAmenities.setPlayGround(playGround);
		otherAmenities.setRainWaterHarvesting(rainWaterHarvesting);
		otherAmenities.setLift(lift);
		otherAmenities.setHouseKeeper(houseKeeper);
		otherAmenities.setShoppingCenter(shoppingCenter);
		otherAmenities.setIntercom(intercom);
		otherAmenities.setInternet(internet);
		otherAmenities.setClub(club);
		otherAmenities.setGas(gas);
		otherAmenities.setSewage(sewage);
		otherAmenities.setFireAlarm(fireAlarm);
		otherAmenities.setPark(park);
		otherAmenities.setSwimmingPool(swimmingPool);
		otherAmenities.setVisitorParking(visitorParking);

		return otherAmenities;
	}

	private Amenities getAmenities(Map<String, Object> data) {
		Amenities amenities = new Amenities();

		Integer bathrooms = Integer.parseInt((String) data.getOrDefault("bathrooms", 0));
		Integer balconies = Integer.parseInt((String) data.getOrDefault("balconies", 0));
		String whoWillShow = (String) data.getOrDefault("showBy", "NA");

		// Parse Boolean values based on expected input ("on" or "off")
		Boolean gatedSecurity = ((String) data.getOrDefault("gatedSecurity", "off")).equals("on");
		Boolean gym = ((String) data.getOrDefault("gym", "off")).equals("on");

		String waterSupply = (String) data.getOrDefault("waterSupply", "NA");
		String powerBackup = (String) data.getOrDefault("powerBackup", "NA");

		amenities.setBathrooms(bathrooms);
		amenities.setBalconies(balconies);
		amenities.setWhoWillShow(whoWillShow);
		amenities.setGatedSecurity(gatedSecurity);
		amenities.setGym(gym);
		amenities.setWaterSupply(waterSupply);
		amenities.setPowerBackup(powerBackup);

		return amenities;
	}

	private PriceDetails getPriceDetails(Map<String, Object> data) {
		PriceDetails priceDetails = new PriceDetails();

		Double expectedPrice = Double.parseDouble((String) data.getOrDefault("expectedPrice", "0.0"));

		Boolean negotiable = ((String) data.getOrDefault("negotiable", "off")).equals("on");

		Double monthlyMaintenance = Double.parseDouble((String) data.getOrDefault("maintenanceCost", "0.0"));

		Boolean isUnderLoan = ((String) data.getOrDefault("underLoan", "off")).equals("on");

		LocalDate possesionDate = LocalDate.parse((String) data.getOrDefault("possessionDate", "1999-01-01"));
		;

		String furnishing = (String) data.getOrDefault("furnishing", "NA");

		String parking = (String) data.getOrDefault("parking", "NA");

		String kitchenType = (String) data.getOrDefault("kitchenType", "NA");

		String propertyDescription = (String) data.getOrDefault("propertyDescription", "NA");

		priceDetails.setExpectedPrice(expectedPrice);
		priceDetails.setNegotiable(negotiable);
		priceDetails.setMonthlyMaintenance(monthlyMaintenance);
		priceDetails.setIsUnderLoan(isUnderLoan);
		priceDetails.setPossesionDate(possesionDate);
		priceDetails.setFurnishing(furnishing);
		priceDetails.setParking(parking);
		priceDetails.setKitchenType(kitchenType);
		priceDetails.setPropertyDescription(propertyDescription);

		return priceDetails;
	}

	private Locality getLocality(Map<String, Object> data) {
		Locality localityBean = new Locality();

		String locality = (String) data.getOrDefault("locality", "");
		String streetAreaLandmark = (String) data.getOrDefault("streetAreaLandmark", "");

		localityBean.setLocality(locality);
		localityBean.setStreetAreaLandmark(streetAreaLandmark);

		return localityBean;
	}

	private PropertyDetails getPropertyDetails(Map<String, Object> data) {
		PropertyDetails propertyDetails = new PropertyDetails();
		Double buildupArea = Double.parseDouble((String) data.getOrDefault("builtUpArea", "0.0"));
		Double carpetArea = Double.parseDouble((String) data.getOrDefault("carpetArea", "0.0"));
		String flooringType = (String) data.getOrDefault("flooringType", "");
		String bhkType = (String) data.getOrDefault("bhkType", "");
		String facing = (String) data.getOrDefault("facing", "");
		String propertyAge = (String) data.getOrDefault("propertyAge", "");
		Integer floor = Integer.parseInt((String) data.getOrDefault("floor", "0"));
		Integer totalFloor = Integer.parseInt((String) data.getOrDefault("totalFloors", "0"));

		propertyDetails.setBuildUpArea(buildupArea);
		propertyDetails.setCarpetArea(carpetArea);
		propertyDetails.setFlooringType(flooringType);
		propertyDetails.setBhkType(bhkType);
		propertyDetails.setFacing(facing);
		propertyDetails.setPropertyAge(propertyAge);
		propertyDetails.setFloor(floor);
		propertyDetails.setTotalFloors(totalFloor);

		return propertyDetails;
	}

}
