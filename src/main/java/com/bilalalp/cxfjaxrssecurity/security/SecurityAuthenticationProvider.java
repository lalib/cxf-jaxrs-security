package com.bilalalp.cxfjaxrssecurity.security;

import com.bilalalp.cxfjaxrssecurity.entity.User;
import com.bilalalp.cxfjaxrssecurity.service.cache.CacheService;
import com.bilalalp.cxfjaxrssecurity.service.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

@Setter
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CacheService<String> cacheService;

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        final String token = String.valueOf(authentication.getPrincipal());
        if (StringUtils.isEmpty(token)) {
            throw new BadCredentialsException("Token is null");
        }

        return createAuthToken(token);
    }

    public Authentication createAuthToken(final String token) {

        final String userName = cacheService.get(token);
        if (userName == null) {
            throw new UsernameNotFoundException("Invalid Session");
        }

        final User user = userService.getUserByUserName(userName);
        return new SystemUserAuthToken(token, new SystemUser(user));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}