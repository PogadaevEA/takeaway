package com.home.takeaway.domain.service;

import com.home.takeaway.application.dto.RoleDTO;
import com.home.takeaway.application.dto.UserDTO;
import com.home.takeaway.application.exception.UserNotFoundException;
import com.home.takeaway.common.Caches;
import com.home.takeaway.domain.mapper.UserMapper;
import com.home.takeaway.domain.model.security.User;
import com.home.takeaway.domain.repository.RoleRepository;
import com.home.takeaway.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;
    private final CacheManager cacheManager;

    public List<UserDTO> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserDTO userDTO) {
        User user = getUserById(userDTO.getId());
        mapper.mapToEntity(user, userDTO);

        userRepository.save(user);
        log.info("Пользователь обновлен " + user.toString());
    }

    @Cacheable(value = Caches.ROLES)
    public RoleDTO getUserRole(String userId) {
        User user = getUserById(userId);

        return new RoleDTO(roleRepository.getOne(user.getRole().getId()));
    }

    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException(id);

        return user.get();
    }
}