package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Admin;
import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Model.User;

import java.util.List;

public interface AdminService {

    Admin validateAdmin(Admin admin);

    Admin addNewAdmin(Admin admin);

    List<User> getUsers();

    List<Employee> getEmployee();

    List<Complaint> getLiveWork();
}
