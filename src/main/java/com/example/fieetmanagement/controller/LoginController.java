package com.example.fieetmanagement.controller;

import com.example.fieetmanagement.dto.LoginDto;
import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.models.Vehicle;
import com.example.fieetmanagement.repositories.UserRepository;
import com.example.fieetmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    public UserRepository adminLoginRepository;

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String adminLogin(Model model) {
        List<Vehicle> vehicle = adminService.getListOfVehicles();
        model.addAttribute("listOfVehicles", vehicle);
     return "homePage";
    }

    @GetMapping("/log")
    public String getLoginPage(Model model){
        model.addAttribute("adminLogin", new LoginDto());
        return "index3";
    }

    @PostMapping("/login")
    public String adminLogin(@ModelAttribute("adminLogin") LoginDto loginDto, HttpSession session, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "index3";
        }
        Users status = adminLoginRepository.findUsersByEmailAndAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (status != null) {
            session.setAttribute("user", status);
            return "redirect:homeView";
        } else {
            return "index3";
        }
    }

}
