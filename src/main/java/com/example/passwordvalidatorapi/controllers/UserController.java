package com.example.passwordvalidatorapi.controllers;

import com.example.passwordvalidatorapi.dto.UserDto;
import com.example.passwordvalidatorapi.services.UserService;
import com.example.passwordvalidatorapi.utils.enums.ErrorMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private ErrorMapper errorMapper;

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }


    @PostMapping("/users")
    ResponseEntity createUser(
            @Valid
            @RequestBody UserDto userDto) {
        try {
            return new ResponseEntity<>(this.userService.createdUser(userDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(this.errorMapper.createErrorMap(e), HttpStatus.BAD_REQUEST);
        }
    }
}
