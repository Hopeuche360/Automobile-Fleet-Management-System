package com.example.fieetmanagement.bootstrap;

import com.example.fieetmanagement.enums.UserRoles;
import com.example.fieetmanagement.models.Admin;
import com.example.fieetmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dataloader {
    @Autowired
    private UserRepository userRepository;

    //
    @PostConstruct
    public void createAdmin() {
//        Manager manger = new Manager();
//        manger.setEmail("manager@gmail.com");
//        manger.setName("manager");
//        manger.setPassword("manager");
//        manger.setPhoneNumber("09088675432");
//        manger.setUserRoles(UserRoles.MANAGER);
//        adminLoginRepository.save(manger);
//
//        Customer customer = new Customer();
//        customer.setEmail("customer@gmail.com");
//        customer.setName("inno");
//        customer.setPhoneNumber("08067654444");
//        customer.setUserRoles(UserRoles.CUSTOMER);
//        customer.setPassword("customer");
//        adminLoginRepository.save(customer);
//
//
//        Admin admin = new Admin();
//        admin.setUserRoles(UserRoles.ADMIN);
//        admin.setPhoneNumber("09088865443");
//        admin.setEmail("admin@gmail.com");
//        admin.setName("Uche jane");
//        admin.setPassword("admin");
//        userRepository.save(admin);
    }
}