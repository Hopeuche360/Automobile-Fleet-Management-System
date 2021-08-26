package com.example.fieetmanagement.controller;

import com.example.fieetmanagement.dto.LoginDto;
import com.example.fieetmanagement.enums.UserRoles;
import com.example.fieetmanagement.models.Customer;
import com.example.fieetmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signUp")
    public String customerSignUp(Model model) {
        Customer customer = new Customer();
        customer.setUserRoles(UserRoles.CUSTOMER);
        model.addAttribute("customer", customer);
        return "customer_signUp";
    }

    @PostMapping("/signUp")
    public String newCustomer (@ModelAttribute("customer") Customer customer) {
        userRepository.save(customer);
        return "redirect:/";
    }

}
