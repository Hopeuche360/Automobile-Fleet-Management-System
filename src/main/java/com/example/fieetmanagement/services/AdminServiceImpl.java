package com.example.fieetmanagement.services;

import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.repositories.AdminLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminLoginRepository adminLoginRepository;

    @Override
    public List<Users> getAllUsers() {
        return adminLoginRepository.findAll();
    }
}
