package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Long>{
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailPassword(String email, String password);
}
