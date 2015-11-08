package com.bilalalp.cxfjaxrssecurity.webservice;


import com.bilalalp.cxfjaxrssecurity.dto.request.LoginRequest;
import com.bilalalp.cxfjaxrssecurity.dto.response.LoginResponse;
import org.springframework.security.access.annotation.Secured;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/auth")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface AuthenticationWebService {

    @Secured(value = "IS_AUTHENTICATED_ANONYMOUSLY")
    @POST
    LoginResponse login(LoginRequest loginRequest);
}