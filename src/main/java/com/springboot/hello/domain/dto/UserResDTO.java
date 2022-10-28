package com.springboot.hello.domain.dto;

import com.springboot.hello.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResDTO {
    private String id;
    private String name;

    public static UserResDTO form(User user) {
        return new UserResDTO(user.getId(), user.getName());
    }
}