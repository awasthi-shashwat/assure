package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.dto.UserDTO;
import com.constructWeek3.assure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //Registering a new user
    @PostMapping("user/newuser")
    public ResponseEntity addNewUser(@RequestBody UserDTO userDTO){

        Long userId = userService.addNewUser(userDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userId)
                .toUri();

        return ResponseEntity.created(location).body("User has been registered");
    }
}
