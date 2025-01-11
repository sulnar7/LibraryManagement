package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Auth;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByEmail(@NotBlank(message = "Email is mandotary") String email);
}
