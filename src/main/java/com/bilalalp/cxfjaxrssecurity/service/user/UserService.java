package com.bilalalp.cxfjaxrssecurity.service.user;

import com.bilalalp.cxfjaxrssecurity.entity.User;

public interface UserService {

    User getUserByUsernameAndPassword(String userName, String password);

    User getUserByUserName(String userName);
}