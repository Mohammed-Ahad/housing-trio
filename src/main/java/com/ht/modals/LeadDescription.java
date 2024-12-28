package com.ht.modals;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description class.
 * 
 * @author Mohammed Ahad
 * @since 04-Dec-2024
 */

@Entity
@Data
@NoArgsConstructor
public class LeadDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime updateDt;

	@Column(nullable = false)
	private LocalDateTime createDt;

	public LeadDescription(String description) {
		this.description = description;
	}
	
	@PrePersist
	private void prePersist() {
		this.createDt = LocalDateTime.now();
		this.updateDt = LocalDateTime.now();
	}
}
