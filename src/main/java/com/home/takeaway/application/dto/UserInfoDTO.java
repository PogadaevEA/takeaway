package com.home.takeaway.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    @Getter @Setter private String login;

    @Getter @Setter private String roleId;
    @Getter @Setter private String roleName;

    @Getter @Setter private List<String> permissions;

    @Getter @Setter private String surname;
    @Getter @Setter private String name;
    @Getter @Setter private String middleName;

    @Getter @Setter private String phone;
}
