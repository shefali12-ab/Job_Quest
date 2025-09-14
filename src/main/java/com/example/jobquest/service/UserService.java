package com.example.jobquest.service;

import com.example.jobquest.model.User;
import com.example.jobquest.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserService implements UserRepository{

   @Autowired
   private UserJpaRepository jpadb;
   
   @Override
   public List<User> getAllUsers(){
    List<User> users = new ArrayList<>(jpadb.findAll());
    return users;
   }

   @Override
   public User getUserById(int id){
    try{
    User u= jpadb.findById(id).get();
    return u;
    } catch(Exception e){
        throw new NoSuchElementException("User with ID " + id + " not found.");
    }
   }

   @Override
    public List<User> getUsersByRole(String role){
     List<User> users = new ArrayList<>(jpadb.findAll());
     List<User> filteredUsers = new ArrayList<>();
     for(User u: users){
          if(u.getRole().name().equalsIgnoreCase(role)){
                filteredUsers.add(u);
          }
     }
     return filteredUsers;
    }

    @Override
    public List<User> getInactiveUsers(){
        List<User> users = new ArrayList<>(jpadb.findAll());
        List<User> inactiveUsers = new ArrayList<>();
        LocalDateTime oneDayAgo = LocalDateTime.now().minusDays(1);
        for(User u: users){
            if(u.getLastLogin() == null || u.getLastLogin().isBefore(oneDayAgo)){
                inactiveUsers.add(u);
            }

        }
        return inactiveUsers;
    }

    @Override
    public User addUser(User user)
    {
        return jpadb.save(user);
    }

    @Override
    public User updateUser(int id, User user)
    {
        try{
        User existingUser = jpadb.findById(id).get();
        if(user.getUserName() != null){
            existingUser.setUserName(user.getUserName());
        }
        if(user.getEmail() != null){
            existingUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            existingUser.setPassword(user.getPassword());
        }
        
        if(user.getResumeUrl()!=null){
            existingUser.setResumeUrl(user.getResumeUrl());
        }
        if(user.getDesignation()!=null){
            existingUser.setDesignation(user.getDesignation());
        }
        if(user.getLastLogin()!=null){
            existingUser.setLastLogin(user.getLastLogin());
        }
        if(user.getRole()!=null){
            existingUser.setRole(user.getRole());
        }
      
        return jpadb.save(existingUser);
        } catch(Exception e){
            throw new NoSuchElementException("User with ID " + id + " not found.");
        }
    }


    @Override
    public void DeleteUserById(int id)
    {
        try{
        jpadb.deleteById(id);
        } catch(Exception e){
            throw new NoSuchElementException("User with ID " + id + " not found.");
        }
    }

    @Override
    public void DeleteInactiveUsers()
    {
        try{
        List<User> users = new ArrayList<>(jpadb.findAll());
        LocalDateTime oneDayAgo = LocalDateTime.now().minusDays(1);
        for(User u: users){
            if(u.getLastLogin() == null || u.getLastLogin().isBefore(oneDayAgo)){
                jpadb.deleteById(u.getUserId());
            }

        } } catch(Exception e){
            throw new NoSuchElementException("Error deleting inactive users: " + e.getMessage());
        }
    }
}
