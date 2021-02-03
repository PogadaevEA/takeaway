package com.home.takeaway.application.controllers;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.domain.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "User Controller", produces = "application/json")
@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Getting user list", response = UserDTO.class, responseContainer = "List")
    @GetMapping("/list")
    public ResponseEntity getAll() {
        List<UserDTO> response = userService.getUserList();
        return ResponseEntity.ok().body(response);
    }
}