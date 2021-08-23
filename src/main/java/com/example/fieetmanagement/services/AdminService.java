package com.example.fieetmanagement.services;

import com.example.fieetmanagement.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    List<Users> getAllUsers();
}
