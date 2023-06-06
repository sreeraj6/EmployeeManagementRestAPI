package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User doLogin(User user);

    User addUser(User user);

    User getDetails(Long id);

    Complaint raiseComplaint(Long id, Complaint complaint);

    List<Complaint> getComplaints(Long uid);

    boolean deleteUser(Long id);
}
