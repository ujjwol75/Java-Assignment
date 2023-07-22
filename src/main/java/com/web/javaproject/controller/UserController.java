package com.web.javaproject.controller;

import com.web.javaproject.dto.UserDto;
import com.web.javaproject.requests.UserRequest;
import com.web.javaproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;


//   Create User or Register User
    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.create(userDto);
        return ResponseEntity.ok(userDto1);
    }




//    Get ALl users
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getUser(){
        List<UserDto> userDtos = userService.get();
        return ResponseEntity.ok(userDtos);
    }


//    Get User By Id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getSigleUser(@PathVariable Long id){
        UserDto singleUser = userService.getSingleUser(id);
        return ResponseEntity.ok(singleUser);
    }


//    Delete User By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok("Delete Successfully");
    }


//    Update User By Id
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        UserDto userDto1 = userService.updateUserById(id, userDto);
        return ResponseEntity.ok(userDto1);
    }

//    Login Controller
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequest userRequest){
        String login = userService.login(userRequest);
        return ResponseEntity.ok(login);
    }


//    Logout Controller
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        String logout = userService.logout();
        return ResponseEntity.ok(logout);
    }



}
