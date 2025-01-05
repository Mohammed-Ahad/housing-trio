package com.ht.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig class.
 * 
 * @author Mohammed Ahad
 * @since 13-Oct-2024
 */

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> requests.antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
						.anyRequest().permitAll())
				.formLogin(form -> form.defaultSuccessUrl("/admin/crm", true))

				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Create
																												// session
																												// if
																												// required
				);
		// .rememberMe(rem -> rem.alwaysRemember(false));

//		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		@SuppressWarnings("deprecation")
		UserDetails info = User.withDefaultPasswordEncoder().username("info").password("EasyPass@421").roles("ADMIN")
				.build();

		@SuppressWarnings("deprecation")
		UserDetails saif = User.withDefaultPasswordEncoder().username("saifulla.shariff").password("Lol@421")
				.roles("USER").build();

		@SuppressWarnings("deprecation")
		UserDetails haseeb = User.withDefaultPasswordEncoder().username("haseeb.shariff").password("Haseeb@123")
				.roles("USER").build();

		@SuppressWarnings("deprecation")
		UserDetails mujeeb = User.withDefaultPasswordEncoder().username("abdul.mujeeb").password("Abdul@123")
				.roles("USER").build();

		List<UserDetails> users = List.of(info, saif, haseeb, mujeeb);
		return new InMemoryUserDetailsManager(users);
	}
}
