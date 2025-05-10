package com.ftgrl.library_project_getir.repository;

import com.ftgrl.library_project_getir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

