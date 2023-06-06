package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.User;
import com.example.employeeManagement.Repository.ComplaintRepository;
import com.example.employeeManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public User addUser(User user) {
        try {
            User newUser =  userRepository.save(user);
            return newUser;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public User getDetails(Long id) {
        try{
            User user = userRepository.getById(id);
            return user;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public Complaint raiseComplaint(Long id, Complaint complaint) {
        complaint.setStatus(1);
        complaint.setUid(id);
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaints(Long uid) {
        List<Complaint> complaints = complaintRepository.getComplaintByUserId(uid);

        for (Complaint currComplaint: complaints) {
            switch (currComplaint.getStatus()) {
                case 1 :
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:

            }
        }
        return complaints;
    }


    @Override
    public User doLogin(User user) {
        User res = userRepository.existByEmail(user.getEmail());
        if(res != null){
            if(res.getPassword().equals(user.getPassword())){
                return res;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }
}
