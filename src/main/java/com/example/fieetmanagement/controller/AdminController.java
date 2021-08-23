package com.example.fieetmanagement.controller;

import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.repositories.AdminLoginRepository;
import com.example.fieetmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminLoginRepository adminLoginRepository;

    @Autowired
    private AdminService adminService;


//    @GetMapping("homeView")
//    public String viewManagementPage(Model model, HttpSession session) {
//        Employee employee = (Employee) session.getAttribute("employee");
//        if (employee.getUserRoles().equalsIgnoreCase("management")) {
//            model.addAttribute("listEmployees", employeeService.getAllEmployees());
////        model.addAttribute("employee", employeeService.getEmployeeById())
//            return "managementDashboard";
//        } else {
//            model.addAttribute("employee", employee);
//            return "employeeDashboard";
//        }


        @GetMapping("/homeView")
    public String loginDashboard(HttpSession session, Model model) {
        Users users = (Users) session.getAttribute("user");
        if(users.getUserRoles().toString().equalsIgnoreCase("admin")) {
            model.addAttribute("listManagers", adminService.getAllUsers());
            return "adminDashboard";
        } else if(users.getUserRoles().toString().equalsIgnoreCase("manager")){
            model.addAttribute("user", users);
            return "managerDashboard";
        } else{
            return "customerDashboard";
        }
    }
}
