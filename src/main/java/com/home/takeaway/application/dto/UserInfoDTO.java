package com.home.takeaway.application.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoDTO {

    private String login;
    private String roleId;
    private String roleName;
    private List<String> permissions;
    private String surname;
    private String name;
    private String middleName;
    private String phone;
}