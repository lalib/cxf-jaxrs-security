package com.bilalalp.cxfjaxrssecurity.webservice;

import com.bilalalp.cxfjaxrssecurity.dto.request.LoginRequest;
import com.bilalalp.cxfjaxrssecurity.dto.response.LoginResponse;
import com.bilalalp.cxfjaxrssecurity.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationWebServiceImpl implements AuthenticationWebService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public LoginResponse login(final LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }
}