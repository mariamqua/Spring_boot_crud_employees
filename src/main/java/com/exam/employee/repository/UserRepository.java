package com.exam.employee.repository;

import com.exam.employee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);

    // get the user by  email and password
    @Query("select u from User u where  u.username =:username and u.password =:password ")
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String Password);
}