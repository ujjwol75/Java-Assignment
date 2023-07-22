package com.web.javaproject.repository;

import com.web.javaproject.dto.UserDto;
import com.web.javaproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);



}
