package com.home.takeaway.infrastructure.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.takeaway.application.dto.UserInfoDTO;
import com.home.takeaway.domain.model.security.RestUserDetails;
import com.home.takeaway.domain.model.security.Role;
import com.home.takeaway.domain.model.security.RolePermission;
import com.home.takeaway.domain.model.security.User;
import com.home.takeaway.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RestAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper mapper;
    private final UserService userService;

    @Value("${server.params.session.max-inactive-interval}")
    private Integer maxInactiveInterval;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        if (authentication.isAuthenticated()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            request.getSession().setMaxInactiveInterval(maxInactiveInterval);  //время жизни сессии 60 мин если не делать запросу к серверу, обнуляется при каждом запросе к серверу
            RestUserDetails details = (RestUserDetails) authentication.getPrincipal();
            User user = userService.getUserById(details.getUsername());
            Role role = user.getRole();
            UserInfoDTO infoDTO = new UserInfoDTO(
                    details.getUsername(),
                    role.getId(),
                    role.getName(),
                    role.getPermissions().stream().map(RolePermission::toString).collect(Collectors.toList()),
                    user.getSurname(),
                    user.getName(),
                    user.getMiddleName(),
                    user.getPhone()
            );
            response.getWriter().print(mapper.writeValueAsString(infoDTO));
        }
    }
}
