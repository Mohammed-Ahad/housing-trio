package com.ht.repoitories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.modals.ContactOwner;
import com.ht.modals.Property;
import com.ht.modals.UserDetails;

/**
 * ContactOwnerRepository class.
 * 
 * @author Mohammed Ahad
 * @since 13-Oct-2024
 */
public interface ContactOwnerRepository extends JpaRepository<ContactOwner, Integer> {
	
	List<ContactOwner> findByActive(boolean active);

	Optional<ContactOwner> findByUserDetailsAndProperty(UserDetails user, Property property);
}
