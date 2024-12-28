package com.ht.modals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Leads class.
 * 
 * @author Mohammed Ahad
 * @since 01-Dec-2024
 */

@Entity
@Data
@Table(name = "leads")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String phoneNo;

	@Column(nullable = false)
	private String assignedTo;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private String project;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LeadDescription> descriptions;

	@Column(nullable = false)
	private LocalDate followUpDate;
	
	@Column(nullable = false)
	private LocalDateTime updateDt;

	@Column(nullable = false)
	private LocalDateTime createDt;

	@PrePersist
	public void prePersist() {
		this.createDt = LocalDateTime.now();
		this.updateDt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.updateDt = LocalDateTime.now();
	}
}
