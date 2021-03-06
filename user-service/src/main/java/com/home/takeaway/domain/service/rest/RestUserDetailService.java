package com.home.takeaway.domain.service.rest;

import com.home.takeaway.domain.model.security.RestUserDetails;
import com.home.takeaway.domain.model.security.User;
import com.home.takeaway.domain.repository.UserRepository;
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

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElse(null);
        if (user == null)
            throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = user.getRole().getPermissions().stream().map(rolePermission ->
                (GrantedAuthority) rolePermission::toString).collect(Collectors.toSet());
        return new RestUserDetails(user.getId(), user.getPassword(), user.getRole().getId(), grantedAuthorities);
    }
}
