package com.ht.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

/**
 * LeadDTO class.
 * 
 * @author Mohammed Ahad
 * @since 01-Dec-2024
 */

@Data
public class LeadDTO {

	private String basedOn;

	private Integer id;

	private String name;

	private String phoneNo;

	private String assignedTo;

	private String status;

	private String project;

	private LocalDateTime followUpDate;

	private LocalDateTime createDt;
}
