package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.User;

public interface UserService {

    User doLogin(User user);

    User addUser(User user);

    User getDetails(Long id);

    boolean deleteUser(Long id);
}
