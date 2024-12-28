package com.ht.dto;

import lombok.Data;

/**
 * ContactOwner class.
 * 
 * @author Mohammed Ahad
 * @since 13-Oct-2024
 */
@Data
public class ContactOwnerDto {

	private Integer propertyId;

	private String name;

	private String email;

	private Long phoneNo;
}
