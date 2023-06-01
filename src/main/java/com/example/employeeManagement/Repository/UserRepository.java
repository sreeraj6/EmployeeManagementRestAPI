package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where email = :email limit 1", nativeQuery = true)
    User existByEmail(String email);
}
