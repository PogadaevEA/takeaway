package com.home.takeaway.application.controllers;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.application.managers.SecurityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Security Controller", produces = "application/json")
@RestController
public class SecurityController {

    private final SecurityManager securityManager;

    @Autowired
    public SecurityController(
            SecurityManager securityManager
    ) {
        this.securityManager = securityManager;
    }

    /**
     * Получение списка пользователей, в зависимости от уровня доступа текущего пользователя
     */
    @ApiOperation(value = "Getting user list", response = UserDTO.class, responseContainer = "List")
    @GetMapping("user/list")
    public ResponseEntity getUserList() {
        List<UserDTO> response = securityManager.getUserList();
        return ResponseEntity.ok().body(response);
    }
}
