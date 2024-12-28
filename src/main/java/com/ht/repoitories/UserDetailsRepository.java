package com.ht.repoitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.modals.UserDetails;

/**
 * UserDetailsRepository class.
 * 
 * @author Mohammed Ahad
 * @since 29-Sep-2024
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	Optional<UserDetails> findByPhoneNo(long phoneNo);

}
