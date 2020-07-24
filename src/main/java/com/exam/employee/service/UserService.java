package com.exam.employee.service;

import com.exam.employee.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> getAllUsers();

    User findById(long id);

    void save(User user);

    void deleteById(long id);

    User findByUsername(String username);

    User findByEmail(String email);

    public boolean validateUserCredential(String username, String password);
}