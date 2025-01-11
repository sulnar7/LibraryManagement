package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Auth;
import com.example.librarymanagement.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public String login(String email, String password) {
        Optional<Auth> auth = authRepository.findByEmail(email);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        if (auth.isPresent()) {

                if (passwordEncoder.matches(password, userDetails.getPassword())) {
                    return jwtService.generateToken(userDetails.getUsername(), userDetails.getAuthorities()
                            .stream()
                            .map(authority -> authority.getAuthority())
                            .toList());
                } else {
                    throw new RuntimeException("Wrong password");
                }

            } else {
                throw new RuntimeException("User not found with this email" + email);


        }
    }

}
