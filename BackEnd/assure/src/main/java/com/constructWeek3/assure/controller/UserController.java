package com.constructWeek3.assure.controller;

import com.constructWeek3.assure.AssureApplication;
import com.constructWeek3.assure.dto.UserDTO;
import com.constructWeek3.assure.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //Authenticating and registering a new user
    @PostMapping("user/authenticate")
    public ResponseEntity<Object> authenticateUser(@RequestBody UserDTO userDTO){

        if(userDTO.getOtp() == null){

            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userEmail","userMobile");

            FilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("UserFilter",filter);

            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDTO);

            mappingJacksonValue.setFilters(filterProvider);

            userService.authenticateUser(mappingJacksonValue);

            return ResponseEntity.ok().body("OTP sent");

        }

        Long id = userService.registerUser(userDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).body("User registered");
    }

}
