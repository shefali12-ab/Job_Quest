package com.example.jobquest.controller;

import com.example.jobquest.service.*;
// import com.example.jobquest.dto.AddSkillsToUserRequest;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/users")  //Admin only
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}") //Admin only
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/inactive") //Admin only
    public List<User> getInactiveUsers(){
        return userService.getInactiveUsers();
    }

    @GetMapping("/users/role/{role}") //{EMPLOYEES} - everyone //{JOBSEEKERS} only admin
    public List<User> getUsersByRole(@PathVariable("role") String role){
        return userService.getUsersByRole(role);
    }

    @PostMapping("/users") //admin cannot be added
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}") //employee only 
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){
        
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/users/{id}") //admin only
    public void DeleteUserById(@PathVariable("id") int id){
        userService.DeleteUserById(id);
    }

    @DeleteMapping("/users/inactive") //admin only
    public void DeleteInactiveUsers(){
        userService.DeleteInactiveUsers();
    }


}

