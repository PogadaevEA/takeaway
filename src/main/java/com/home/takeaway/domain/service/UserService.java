package com.home.takeaway.domain.service;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Получение списка пользователей, в зависимости от уровня доступа текущего пользователя
     * @return список пользователей
     */
    public List<UserDTO> getUserList() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepository.findAll().forEach(user -> userDTOList.add(new UserDTO(user)));
        return userDTOList;
    }
}