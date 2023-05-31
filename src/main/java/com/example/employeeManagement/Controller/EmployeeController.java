package com.example.employeeManagement.Controller;

import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/list")
    public List<Employee> listEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/delete/{empId}")
    public boolean deleteEmployee(@PathVariable(value = "empId") Long empId) {
        return employeeService.deleteEmployee(empId);
    }
}
