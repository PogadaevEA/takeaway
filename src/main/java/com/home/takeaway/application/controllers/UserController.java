package com.home.takeaway.application.controllers;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.common.utils.UserUtils;
import com.home.takeaway.domain.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "User Controller", produces = "application/json")
@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Getting user list", response = UserDTO.class, responseContainer = "List")
    @GetMapping("/list")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(userService.getUserList());
    }

    @ApiOperation(value = "Update user")
    @PostMapping
    public ResponseEntity update(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Get user permissions")
    @GetMapping("/permissions")
    public ResponseEntity getUserPermissions() {
        return ResponseEntity.ok().body(userService.getUserRole(UserUtils.getCurrentUserId()));
    }
}