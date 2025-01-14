package com.ht.utils;

/**
 * ROLES class.
 * 
 * @author Mohammed Ahad
 * @since 05-Jan-2025
 */
public enum ROLES {
	ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private String role;

    ROLES(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
