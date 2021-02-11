package com.home.takeaway.common.utils;

import com.home.takeaway.domain.model.security.RestUserDetails;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class UserUtils {

    public static String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RestUserDetails userDetails = (RestUserDetails) authentication.getPrincipal();

        return userDetails.getUsername();
    }
}
