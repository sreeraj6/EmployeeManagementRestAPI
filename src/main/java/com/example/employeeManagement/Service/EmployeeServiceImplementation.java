package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Repository.ComplaintRepository;
import com.example.employeeManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ComplaintRepository complaintRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        if(employeeRepository.existsByEmail(employee.getEmailId()) == 1){
            return null;
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee loginEmployee(Employee employee) {

        System.out.println(employee.getEmailId());
        Employee employee1 = employeeRepository.existByEmail(employee.getEmailId());
        System.out.println(employee1);
        if(employee1 != null) {
            if(employee1.getLastName().equals(employee.getLastName())){
                return employee1;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Long empId) {

        if(employeeRepository.existsById(empId)) {
            employeeRepository.deleteById(empId);
            return true;
        }
        return false;
    }

    @Override
    public boolean findByEmail(String email) {
         if(employeeRepository.existsByEmail(email) == 1) {
             return true;
         }
         return false;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try {
            Employee existData = employeeRepository.getById(employee.getId());

            if(employee.getEmailId() != null && existData.getEmailId() != employee.getEmailId()){
                existData.setEmailId(employee.getEmailId());
            }

            if(employee.getFirstName() != null && existData.getFirstName() != employee.getFirstName()){
                existData.setFirstName(employee.getFirstName());
            }

            if(employee.getLastName() != null && existData.getLastName() != employee.getLastName()) {
                existData.setLastName(employee.getLastName());
            }
            return employeeRepository.save(existData);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Complaint> getPendingComplaints() {
        return complaintRepository.getNotAssignedComplaints();
    }
}
