package com.bilalalp.cxfjaxrssecurity.webservice;

import com.bilalalp.cxfjaxrssecurity.dto.MessageDto;
import org.springframework.security.access.annotation.Secured;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface MessageWebService {

    @Secured(value = "ROLE_OPERATOR")
    @GET
    MessageDto sayHello();

    @Secured(value = "ROLE_ADMIN")
    @GET
    @Path(value = "getName")
    MessageDto getLoggerUserName();

    @Secured(value = "ROLE_USER")
    @GET
    @Path(value = "getTime")
    MessageDto getTime();
}