package com.ht.repoitories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.modals.Lead;

/**
 * LeadsRepo class.
 * 
 * @author Mohammed Ahad
 * @since 01-Dec-2024
 */
public interface LeadRepo extends JpaRepository<Lead, Integer> {

	// Based on follow up date
	List<Lead> findByFollowUpDateBetween(LocalDate from, LocalDate to);

	// Find by status == status
	List<Lead> findByStatus(String status);

	// Find by status != status
	List<Lead> findByStatusNot(String status);

}
