package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.User;

public interface UserRepository {

    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getInactiveUsers();

    List<User> getUsersByRole(String role);

    User addUser(User user);

    User updateUser(Long id, User user);

    void DeleteUserById(Long id);

    void DeleteInactiveUsers();

}