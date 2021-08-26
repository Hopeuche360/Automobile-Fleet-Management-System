package com.example.fieetmanagement.repositories;

import com.example.fieetmanagement.enums.UserRoles;
import com.example.fieetmanagement.models.Manager;
import com.example.fieetmanagement.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUsersByEmailAndAndPassword(String email, String password);
    List<Manager> findUsersByUserRoles(UserRoles userRoles);
    Manager findUsersById(Long along);
}
