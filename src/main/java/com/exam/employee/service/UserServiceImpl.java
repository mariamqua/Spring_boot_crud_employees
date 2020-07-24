package com.exam.employee.service;

import com.exam.employee.entity.User;
import com.exam.employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;



    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(long id) {
        return userRepository.findById(id);
    }
    @Override
    @Transactional
    public void save(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setCreated(timestamp);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) { userRepository.deleteById(id); }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    @Transactional
    public boolean validateUserCredential(String username, String password) {
        return userRepository.getUserByUsernameAndPassword(username,password) != null;
    }
}
