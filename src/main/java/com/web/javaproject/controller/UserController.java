package com.web.javaproject.controller;

import com.web.javaproject.dto.UserDto;
import com.web.javaproject.requests.UserRequest;
import com.web.javaproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String welcome(){
        return "jello";
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.create(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getUser(){
        List<UserDto> userDtos = userService.get();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getSigleUser(){

        return null;
    }


}
