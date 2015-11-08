package com.bilalalp.cxfjaxrssecurity.service.authentication;

import com.bilalalp.cxfjaxrssecurity.dto.request.LoginRequest;
import com.bilalalp.cxfjaxrssecurity.dto.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest);
}