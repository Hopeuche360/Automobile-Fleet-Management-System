package com.example.fieetmanagement.repositories;

import com.example.fieetmanagement.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginRepository extends JpaRepository<Users, Long> {
    Users findUsersByEmailAndAndPassword(String email, String password);
}
