package com.ht.modals;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Data;

/**
 * ContactOwner class.
 * 
 * @author Mohammed Ahad
 * @since 13-Oct-2024
 */

@Entity
@Data
public class ContactOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private boolean active;

	@ManyToOne
	private UserDetails userDetails;

	@OneToOne
	private Property property;

	@Column(nullable = false)
	private LocalDateTime createDate;

	@PrePersist
	private void setCreateDate() {
		this.createDate = LocalDateTime.now();
		this.active = true;
	}
}
