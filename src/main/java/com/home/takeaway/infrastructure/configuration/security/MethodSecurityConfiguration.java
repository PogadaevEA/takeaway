package com.home.takeaway.infrastructure.configuration.security;

import com.home.takeaway.infrastructure.configuration.security.method.MethodSecurityExpressionRoot;
import com.home.takeaway.infrastructure.configuration.security.method.RestPermissionEvaluator;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        RestPermissionEvaluator evaluator = new RestPermissionEvaluator();
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler() {
            @Override
            protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
                MethodSecurityExpressionRoot methodSecurityExpressionRoot = new MethodSecurityExpressionRoot(authentication);
                methodSecurityExpressionRoot.setPermissionEvaluator(evaluator);
                return methodSecurityExpressionRoot;
            }
        };
        handler.setPermissionEvaluator(evaluator);

        return  handler;
    }
}
