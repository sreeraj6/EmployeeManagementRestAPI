package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "select * from admin where email = :email and password = :password", nativeQuery = true)
    Optional<Admin> userExist(String email, String password);
}
