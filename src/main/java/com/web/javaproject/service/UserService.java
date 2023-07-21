package com.web.javaproject.service;

import com.web.javaproject.dto.UserDto;
import com.web.javaproject.mapper.UserMapper;
import com.web.javaproject.model.User;
import com.web.javaproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;


    public UserDto create(UserDto userDto){
        User map = this.modelMapper.map(userDto, User.class);
        User save = userRepository.save(map);
        UserDto user = this.modelMapper.map(save, UserDto.class);
        return user;
    }

    public List<UserDto> get(){
        List<User> users = userRepository.findAll();

        List<UserDto> collect = users.stream().map(each -> this.modelMapper.map(each, UserDto.class)).collect(Collectors.toList());

        return collect;
    }


    public UserDto getSingleUser(){

        return null;
    }


}
