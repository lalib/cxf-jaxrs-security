package com.bilalalp.cxfjaxrssecurity.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    private String username;

    private String password;

    private List<String> roles;
}