package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Admin;
import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Model.User;
import com.example.employeeManagement.Repository.AdminRepository;
import com.example.employeeManagement.Repository.ComplaintRepository;
import com.example.employeeManagement.Repository.EmployeeRepository;
import com.example.employeeManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Admin validateAdmin(Admin admin) {
        Optional<Admin> validatedAdmin = adminRepository.userExist(admin.getEmail(), admin.getPassword());
        return validatedAdmin.get();
    }

    @Override
    public Admin addNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Complaint> getLiveWork() {
        return complaintRepository.getLiveComplaint();
    }
}
