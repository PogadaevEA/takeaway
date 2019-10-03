package com.home.takeaway.application.managers;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class SecurityManager {

    private final UserRepository userRepository;

    @Autowired
    public SecurityManager(
        UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    /**
     * Получение списка пользователей, в зависимости от уровня доступа текущего пользователя
     * @return List
     */
    public List<UserDTO> getUserList() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepository.findAll().forEach(user -> userDTOList.add(new UserDTO(user)));
        return userDTOList;
    }
}
