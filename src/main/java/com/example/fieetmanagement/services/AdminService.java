package com.example.fieetmanagement.services;

import com.example.fieetmanagement.enums.UserRoles;
import com.example.fieetmanagement.models.Branch;
import com.example.fieetmanagement.models.Manager;
import com.example.fieetmanagement.models.Users;
import com.example.fieetmanagement.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    List<Manager> getListOfManagers(UserRoles userRoles);
    void saveNewManager(Manager manager);
    Manager getManagerById(long id);
    void deleteUserById(long id);

    List<Branch> getListOfBranches();
    void saveBranch(Branch branch);
    Branch getBranchById(long id);
    void deleteBranchById(long id);

    List<Vehicle> getListOfVehicles();
    void saveVehicle(Vehicle vehicle);
    Vehicle getVehicleById(long id);
    void deleteBVehicleById(long id);

    List<Vehicle> getCustomerListOfVehicles();
}
