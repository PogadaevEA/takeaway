package com.home.takeaway.domain.mapper;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.domain.model.security.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {

    @Override
    public User mapToEntity(User user, UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setMiddleName(userDTO.getMiddleName());
        user.setPhone(userDTO.getPhone());
        user.getRole().setName(userDTO.getRoleDTO().getName());

        return user;
    }

    @Override
    public UserDTO mapToDto(User value, UserDTO userDTO) {
        return null;
    }
}
