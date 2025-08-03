package com.example.LibraryGrok.repository;

import com.example.LibraryGrok.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
