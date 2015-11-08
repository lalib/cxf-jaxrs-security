package com.bilalalp.cxfjaxrssecurity.service.user;

import com.bilalalp.cxfjaxrssecurity.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final List<User> USER_LIST = new ArrayList<>();

    @PostConstruct
    public void init() {

        final User firstUser = new User();
        firstUser.setUsername("bilalalp");
        firstUser.setPassword("bilalalp");
        firstUser.setRoles(Arrays.asList("ROLE_ADMIN", "ROLE_OPERATOR", "ROLE_USER"));

        final User secondUser = new User();
        secondUser.setUsername("halil");
        secondUser.setPassword("halil");
        secondUser.setRoles(Arrays.asList("ROLE_OPERATOR", "ROLE_USER"));

        final User thirdUser = new User();
        thirdUser.setUsername("ulas");
        thirdUser.setPassword("ulas");
        thirdUser.setRoles(Collections.singletonList("ROLE_USER"));

        USER_LIST.add(firstUser);
        USER_LIST.add(secondUser);
        USER_LIST.add(thirdUser);
    }

    @Override
    public User getUserByUsernameAndPassword(final String userName, final String password) {
        final Optional<User> any = USER_LIST.stream()
                .filter(user -> user.getUsername().equals(userName) && user.getPassword().equals(password))
                .findAny();
        return any.isPresent() ? any.get() : null;
    }

    @Override
    public User getUserByUserName(final String userName) {
        final Optional<User> any = USER_LIST.stream().filter(user -> user.getUsername().equals(userName)).findAny();
        return any.isPresent() ? any.get() : null;
    }
}