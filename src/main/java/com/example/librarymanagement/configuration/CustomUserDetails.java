package com.example.librarymanagement.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class CustomUserDetails extends User {

    public CustomUserDetails(String username, String password, List<GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
