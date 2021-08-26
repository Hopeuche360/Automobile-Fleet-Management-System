package com.example.fieetmanagement.services;

import com.example.fieetmanagement.enums.UserRoles;
import com.example.fieetmanagement.models.Branch;
import com.example.fieetmanagement.models.Manager;
import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.models.Vehicle;
import com.example.fieetmanagement.repositories.BranchRepository;
import com.example.fieetmanagement.repositories.UserRepository;
import com.example.fieetmanagement.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Manager> getListOfManagers(UserRoles userRoles) {
        return userRepository.findUsersByUserRoles(userRoles);
    }

    @Override
    public void saveNewManager(Manager manager) {
        Date date = Date.valueOf(LocalDate.now());
        manager.setCreatedAt(date);
        this.userRepository.save(manager);
    }

    @Override
    public Manager getManagerById(long id) {
        Optional<Manager> optional = Optional.ofNullable(userRepository.findUsersById(id));
        Manager manager = null;
        if(optional.isPresent()) {
            manager = optional.get();
        } else {
            throw new RuntimeException("user not found::" + id);
        }
        return manager;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<Branch> getListOfBranches() {
        return branchRepository.findAll();
    }

    @Override
    public void saveBranch(Branch branch) {
        this.branchRepository.save(branch);
    }

    @Override
    public Branch getBranchById(long id) {
        Optional<Branch> optional = branchRepository.findById(id);
        Branch branch = null;
        if(optional.isPresent()) {
            branch = optional.get();
        } else {
            throw new RuntimeException("branch not found" + id);
        }
        return branch;
    }

    @Override
    public void deleteBranchById(long id) {
        this.branchRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getListOfVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        Date date = Date.valueOf(LocalDate.now());
        vehicle.setCreatedAt(date);
        this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(long id) {
        Optional<Vehicle> optional = vehicleRepository.findById(id);
        Vehicle vehicle = null;
        if(optional.isPresent()) {
            vehicle = optional.get();
        } else {
            throw new RuntimeException("branch not found" + id);
        }
        return vehicle;
    }

    @Override
    public void deleteBVehicleById(long id) {
        this.vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getCustomerListOfVehicles() {
        return vehicleRepository.findAll();
    }
}
