package com.web.javaproject.service;

import com.web.javaproject.dto.UserDto;
import com.web.javaproject.exception.LoginFailedException;
import com.web.javaproject.model.User;
import com.web.javaproject.repository.UserRepository;
import com.web.javaproject.requests.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final HttpServletRequest request;


    public UserDto create(UserDto userDto){
        User map = this.modelMapper.map(userDto, User.class);
        map.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User save = userRepository.save(map);
        UserDto user = this.modelMapper.map(save, UserDto.class);
        return user;
    }

    public List<UserDto> get(){
        List<User> users = userRepository.findAll();

        List<UserDto> collect = users.stream().map(each -> this.modelMapper.map(each, UserDto.class)).collect(Collectors.toList());

        return collect;
    }



    public UserDto getSingleUser(Long id){
        User user = userRepository.findById(id).get();
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public UserDto updateUserById(Long id, UserDto userDto){
        User oldUser = userRepository.findById(id).get();
        oldUser.setName(userDto.getName());
        oldUser.setEmail(userDto.getEmail());
        oldUser.setPassword(userDto.getPassword());
        User newUser = userRepository.save(oldUser);
        UserDto map = this.modelMapper.map(newUser, UserDto.class);
        return map;
    }

    public String login(UserRequest userRequest) {

        try {
            String email = userRequest.getEmail();
            User user = userRepository.findByEmail(email);
            String encodedPassword = user.getPassword();
            boolean checkPassword = passwordEncoder.matches(userRequest.getPassword(), encodedPassword);
            if (checkPassword) {
                return "success";
            } else {
                throw new LoginFailedException("Invalid email or password.");
            }
        } catch (Exception e) {

            e.printStackTrace();
            throw new LoginFailedException("Invalid Email or Password.");
        }

    }


    public String logout() {

        request.getSession().invalidate();
        return "success";
    }

}


