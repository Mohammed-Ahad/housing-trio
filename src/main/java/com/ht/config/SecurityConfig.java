package com.ht.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
				.authorizeHttpRequests(
						requests -> requests.antMatchers("/admin/**").authenticated().anyRequest().permitAll())
				.formLogin(form -> form.defaultSuccessUrl("/admin/crm", true))
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout"));

		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder().username("trio").password("trio@123").roles("USER")
				.build();
		List<UserDetails> users = List.of(user);
		return new InMemoryUserDetailsManager(users);
	}
}
