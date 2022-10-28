package com.springboot.hello.domain.dto;

import com.springboot.hello.domain.User;
import lombok.Getter;

@Getter

public class UserReqDTO {
    private String id;
    private String name;
    private String password;

    public User toEntity() {
        return new User(id, name, password);
    }
}
