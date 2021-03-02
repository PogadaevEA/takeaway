package com.home.takeaway.infrastructure.service;

import com.home.takeaway.domain.model.security.RestUserDetails;
import com.home.takeaway.domain.model.security.User;
import com.home.takeaway.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@ApplicationScope
@RequiredArgsConstructor
public class RestUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserById(username);

        Set<GrantedAuthority> grantedAuthorities = user.getRole().getPermissions().stream().map(rolePermission ->
                (GrantedAuthority) rolePermission::toString).collect(Collectors.toSet());
        return new RestUserDetails(user.getId(), user.getPassword(), user.getRole().getId(), grantedAuthorities);
    }
}
