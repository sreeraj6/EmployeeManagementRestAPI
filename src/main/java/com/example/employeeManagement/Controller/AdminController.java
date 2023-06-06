package com.example.employeeManagement.Controller;

import com.example.employeeManagement.Model.Admin;
import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Model.User;
import com.example.employeeManagement.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-admin")
    public ResponseEntity<?> addAdmin(Admin newAdmin) {
        Admin addedAdmin = adminService.addNewAdmin(newAdmin);
        if(addedAdmin != null) {
            return new ResponseEntity<>(addedAdmin, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Error occured", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/live-works")
    public List<Complaint> getPendingWorks() {
        return adminService.getLiveWork();
    }

    @GetMapping("/get-user")
    public List<User> getUser() {
        return adminService.getUsers();
    }

    @GetMapping("/get-employee")
    public List<Employee> getEmployee() {
        return adminService.getEmployee();
    }
}
