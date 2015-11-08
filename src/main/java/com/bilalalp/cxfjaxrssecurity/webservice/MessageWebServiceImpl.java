package com.bilalalp.cxfjaxrssecurity.webservice;

import com.bilalalp.cxfjaxrssecurity.dto.MessageDto;
import com.bilalalp.cxfjaxrssecurity.service.user.LoggedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageWebServiceImpl implements MessageWebService {

    @Autowired
    private LoggedUserService loggedUserService;

    @Override
    public MessageDto sayHello() {
        return new MessageDto("Hello!");
    }

    @Override
    public MessageDto getLoggerUserName() {
        return new MessageDto(loggedUserService.getLoggerUser().getUsername());
    }

    @Override
    public MessageDto getTime() {
        return new MessageDto(new Date().toString());
    }
}