package com.ht.repoitories;

import java.time.LocalDateTime;
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


	List<Lead> findByCreateDtBetween(LocalDateTime from, LocalDateTime to);

	// Based on follow up date < :date
	List<Lead> findByFollowUpDateLessThanEqualAndStatusNotIn(LocalDateTime date, List<String> notStatuses);

	// Find by status == status
	List<Lead> findByStatus(String status);

	// Find by status != status
	List<Lead> findByStatusNot(String status);

}
