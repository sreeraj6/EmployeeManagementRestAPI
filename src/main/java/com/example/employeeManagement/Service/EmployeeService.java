package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee loginEmployee(Employee employee);
    boolean deleteEmployee(Long empId);

    boolean findByEmail(String email);

    Employee updateEmployee(Employee employee);

    List<Complaint> getPendingComplaints();
}
