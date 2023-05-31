package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean deleteEmployee(Long empId);
}
