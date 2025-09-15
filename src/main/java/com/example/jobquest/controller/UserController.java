package com.example.jobquest.controller;

import com.example.jobquest.service.*;
// import com.example.jobquest.dto.AddSkillsToUserRequest;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.*;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/users")  
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}") 
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/inactive") //Admin only
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getInactiveUsers(){
        return userService.getInactiveUsers();
    }

    @GetMapping("/users/role/{role}") 
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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{id}") //admin only
    public void DeleteUserById(@PathVariable("id") int id){
        userService.DeleteUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/inactive") //admin only
    public void DeleteInactiveUsers(){
        userService.DeleteInactiveUsers();
    }


}

