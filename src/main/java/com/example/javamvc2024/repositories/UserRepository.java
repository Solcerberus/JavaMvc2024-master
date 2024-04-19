package com.example.javamvc2024.repositories;

import com.example.javamvc2024.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String username);
}
