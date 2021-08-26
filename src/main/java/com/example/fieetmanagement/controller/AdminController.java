package com.example.fieetmanagement.controller;

import com.example.fieetmanagement.enums.Status;
import com.example.fieetmanagement.enums.UserRoles;
import com.example.fieetmanagement.models.Branch;
import com.example.fieetmanagement.models.Manager;
import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.models.Vehicle;
import com.example.fieetmanagement.repositories.BranchRepository;
import com.example.fieetmanagement.repositories.UserRepository;
import com.example.fieetmanagement.repositories.VehicleRepository;
import com.example.fieetmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserRepository adminLoginRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    @GetMapping("/homeView")
    public String loginDashboard(HttpSession session, Model model) {
        Users users = (Users) session.getAttribute("user");
        if (users.getUserRoles().toString().equalsIgnoreCase("admin")) {
            model.addAttribute("listManagers", adminService.getListOfManagers(UserRoles.MANAGER));
            return "adminDashboard";
        } else if (users.getUserRoles().toString().equalsIgnoreCase("manager")) {
            model.addAttribute("user", users);
            return "ManagerDetails";
        } else {
            return "redirect:/showCustomerVehiclesList";
        }
    }

    @GetMapping("/showNewManagersForm")
    public String showNewMangersForm(Model model) {
        Manager manager = new Manager();
        manager.setUserRoles(UserRoles.MANAGER);
        model.addAttribute("manager", manager);
        return "new_manager_form";

    }

    @PostMapping("/saveNewManager")
    public String saveNewManager(@ModelAttribute("manager") Manager manager) {
        // save manager to database
        adminService.saveNewManager(manager);
        return "redirect:/homeView";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Manager manager = adminService.getManagerById(id);
        model.addAttribute("manager", manager);
        return "update_manager";
    }

    @GetMapping("/deleteManager/{id}")
    public String deleteManager(@PathVariable(value = "id") long id) {
        this.adminService.deleteUserById(id);
        return "redirect:/homeView";
    }

    @GetMapping("/viewBranches")
    public String viewBranches(Model model) {
        List<Branch> branch = adminService.getListOfBranches();
        model.addAttribute("listOfBranches", branch);
        return "Branch";
    }

    @GetMapping("/showBranchForm")
    public String showBranchForm(Model model) {
        Branch branch = new Branch();
        model.addAttribute("branch", branch);
        return "new_branch_form";
    }

    @PostMapping("/saveNewBranch")
    public String saveNewBranch(@ModelAttribute("branch") Branch branch) {
        // save branch to database
        adminService.saveBranch(branch);
        return "redirect:/viewBranches";
    }

    @GetMapping("/showBranchFormForUpdate/{id}")
    public String showBranchFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Branch branch = adminService.getBranchById(id);
        model.addAttribute("branch", branch);
        return "update_branch_form";
    }

    @GetMapping("/deleteBranch/{id}")
    public String deleteBranch(@PathVariable(value = "id") long id) {
        this.adminService.deleteBranchById(id);
        return "redirect:/viewBranches";
    }

    @GetMapping("/viewVehicles")
    public String viewVehicles(Model model) {
        List<Vehicle> vehicle = adminService.getListOfVehicles();
        model.addAttribute("listOfVehicles", vehicle);
        return "Vehicles";
    }


    @GetMapping("/showVehicleForm")
    public String showVehicleForm(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "new_vehicle_form";
    }

    @PostMapping("/saveNewVehicle")
    public String saveNewVehicle(@ModelAttribute("vehicle") Vehicle vehicle, HttpSession session) {
//        Vehicle vehicle1 = (Vehicle) session.getAttribute("vehicle");
        vehicle.setStatus(Status.AVAILABLE);
        vehicleRepository.save(vehicle);
        return "redirect:/viewVehicles";
    }

    @GetMapping("/showVehicleFormForUpdate/{id}")
    public String showVehicleFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Vehicle vehicle = adminService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "update_vehicle_form";
    }

    @GetMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable(value = "id") long id) {
        this.adminService.deleteBVehicleById(id);
        return "redirect:/viewVehicles";
    }

    @GetMapping("/showCustomerVehiclesList")
    public String showCustomersVehicleList(Model model) {
        List<Vehicle> vehicle = adminService.getListOfVehicles();
        model.addAttribute("listOfVehicles", vehicle);
        return "customerDashboard";
    }
}
