package com.example.jobquest.controller;

import com.example.jobquest.service.*;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/inactive")
    public List<User> getInactiveUsers(){
        return userService.getInactiveUsers();
      
    }

    @GetMapping("/users/role/{role}")
    public List<User> getUsersByRole(@PathVariable("role") String role){
        return userService.getUsersByRole(role);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user)
    {
        
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/users/{id}")
    public void DeleteUserById(@PathVariable("id") Long id)
    {
        userService.DeleteUserById(id);
    }

    @DeleteMapping("/users/inactive")
    public void DeleteInactiveUsers()
    {
        userService.DeleteInactiveUsers();
    }
}