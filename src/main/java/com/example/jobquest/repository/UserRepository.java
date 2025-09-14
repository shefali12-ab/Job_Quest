package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.User;
// import com.example.jobquest.model.Skill;

public interface UserRepository {

    List<User> getAllUsers();

    User getUserById(int id);

    List<User> getInactiveUsers();

    List<User> getUsersByRole(String role);

    User addUser(User user);

    User updateUser(int id, User user);

    void DeleteUserById(int id);

    void DeleteInactiveUsers();

}
