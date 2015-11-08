package com.bilalalp.cxfjaxrssecurity.service.authentication;

import com.bilalalp.cxfjaxrssecurity.dto.UserDto;
import com.bilalalp.cxfjaxrssecurity.dto.request.LoginRequest;
import com.bilalalp.cxfjaxrssecurity.dto.response.LoginResponse;
import com.bilalalp.cxfjaxrssecurity.entity.User;
import com.bilalalp.cxfjaxrssecurity.service.cache.CacheService;
import com.bilalalp.cxfjaxrssecurity.service.user.UserService;
import com.bilalalp.cxfjaxrssecurity.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private CacheService<String> cacheService;

    @Override
    public LoginResponse login(final LoginRequest loginRequest) {

        final LoginResponse loginResponse = new LoginResponse();

        final UserDto userDto = loginRequest.getUserDto();
        final User user = userService.getUserByUsernameAndPassword(userDto.getUserName(), userDto.getPassword());

        if (user == null) {
            loginResponse.setSuccess(Boolean.FALSE);
            loginResponse.setMessage("User Not Found!");
        } else {
            final String key = String.valueOf(PasswordUtil.md5(user.getPassword()));
            cacheService.put(key, user.getUsername());
            loginResponse.setToken(key);
        }

        return loginResponse;
    }
}