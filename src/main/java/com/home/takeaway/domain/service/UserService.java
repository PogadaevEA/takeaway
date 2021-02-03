package com.home.takeaway.domain.service;

import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
}