package com.ht.repoitories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.modals.Property;
import com.ht.modals.UserDetails;

/**
 * PropertyRepository class.
 * 
 * @author Mohammed Ahad
 * @since 28-Sep-2024
 */
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	Optional<Property> findByUserDetails(UserDetails userDetailsBean);

	List<Property> findByStatus(String status);

}
