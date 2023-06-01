package com.example.employeeManagement.Controller;

import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        if(savedEmployee != null){
            return new ResponseEntity<>(savedEmployee, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("user already exist", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/list")
    public List<Employee> listEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/delete/{empId}")
    public boolean deleteEmployee(@PathVariable(value = "empId") Long empId) {
        return employeeService.deleteEmployee(empId);
    }

    @PostMapping("/find")
    public ResponseEntity<?> employeeFind(@RequestBody Employee employee){
        if(employeeService.findByEmail(employee.getEmailId())) {
            return new ResponseEntity<>("Emailid is already exist", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Email id not exist", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.loginEmployee(employee);
        if(employee1 != null) {
            return new ResponseEntity<>(employee1,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Invalid Username or Password", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            updatedEmployee.getLastName();
            return new ResponseEntity<>(updatedEmployee, HttpStatus.ACCEPTED);
        }
        catch (NullPointerException err) {
            return new ResponseEntity<>("Error Occured : "+err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
