package com.example.fieetmanagement.controller;

import com.example.fieetmanagement.dto.LoginDto;
import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.repositories.AdminLoginRepository;
import com.example.fieetmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    public AdminLoginRepository adminLoginRepository;

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String adminLogin(Model model) {
        model.addAttribute("adminLogin", new LoginDto());
        System.out.println("just checking");
        return "index";
    }

    @PostMapping("/login")
    public String adminLogin(@ModelAttribute("adminLogin") LoginDto loginDto, HttpSession session, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "index";
        }
        Users status = adminLoginRepository.findUsersByEmailAndAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (status != null) {
            session.setAttribute("user", status);
            return "redirect:homeView";
        } else {
            return "index";
        }
    }


//    @PostMapping("/login")
//    public String loginDashboard(@ModelAttribute("adminLogin") LoginDto loginDto, HttpSession session, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "index";
//        }
//        Users status = adminLoginRepository.findUsersByEmailAndAndPassword(loginDto.getEmail(),loginDto.getPassword());
//        System.out.println("before status");
//        if (status != null) {
//            System.out.println("after status");
//            Users users = (Users) session.getAttribute("user");
//            if(status.getUserRoles().equalsIgnoreCase("admin")) {
//                model.addAttribute("listManagers", adminService.getAllUsers());
//                return "adminDashboard";
//            } else if(status.getUserRoles().equalsIgnoreCase("manager")){
//                model.addAttribute("user", users);
//                return "managerDashboard";
//            } else{
//                return "customerDashboard";
//            }
//        } else {
//            return "index";
//        }
//    }



//    @PostMapping("/login")
//    public String employeeLogin(@ModelAttribute("employeeLogin") EmployeeLoginDto employeeLoginDto, HttpSession session, BindingResult result,Model model){
//        if (result.hasErrors()) {
//            return "index";
//        }
//        System.out.println("before status");
//        Employee status = employeeRepository.findEmployeeByEmailAndPassword(employeeLoginDto.getEmail(), employeeLoginDto.getPassword());
//        if (status != null) {
//            System.out.println(status);
//            session.setAttribute("employee", status);
//            return "redirect:homeView";
//        } else {
//            return "index";
//        }
//    }

}
