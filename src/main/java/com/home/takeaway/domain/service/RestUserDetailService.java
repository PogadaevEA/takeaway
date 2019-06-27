package com.home.takeaway.domain.service;

import com.home.takeaway.domain.model.security.RestUserDetails;
import com.home.takeaway.domain.model.security.User;
import com.home.takeaway.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RestUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public RestUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = user.getRole().getPermissions().stream().map(rolePermission ->
                (GrantedAuthority) rolePermission::toString).collect(Collectors.toSet());
        return new RestUserDetails(user.getId(), user.getPassword(), user.getRole().getId(), grantedAuthorities);
    }
}
