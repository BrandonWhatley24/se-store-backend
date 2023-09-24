package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
