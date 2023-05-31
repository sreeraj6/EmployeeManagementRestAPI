package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Employee;
import jakarta.persistence.UniqueConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //return 1 email exist
    @Query(value = "SELECT EXISTS(SELECT 1 FROM employee WHERE emailid = :email)", nativeQuery = true)
    int existsByEmail(String email);

    //return employee wehen email exist
    @Query(value = "SELECT * FROM employee WHERE emailid = :email LIMIT 1", nativeQuery = true)
    Employee existByEmail(String email);


}
