package com.example.employeeManagement.Controller;

import com.example.employeeManagement.Model.Complaint;
import com.example.employeeManagement.Model.User;
import com.example.employeeManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody  User user) {
        User newUser = userService.addUser(user);
        if(newUser != null) {
            return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existUser = userService.doLogin(user);
        if(existUser!= null) {
            return new ResponseEntity<>(existUser, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Invalid email or password", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/profile/{uid}")
    public User getProfile(@PathVariable(value = "uid") Long id) {
        User user = userService.getDetails(id);
        return user;
    }

    @PostMapping("/raise-complaint/{uid}")
    public Complaint putComplaint(@PathVariable(value = "uid") Long uid, @RequestBody Complaint complaint){
        return userService.raiseComplaint(uid,complaint);
    }

    @GetMapping("/complaint-history/{uid}")
    public List<Complaint> getComplaintHistory(@PathVariable(value = "uid") Long uid){
        return userService.getComplaints(uid);
    }
}
