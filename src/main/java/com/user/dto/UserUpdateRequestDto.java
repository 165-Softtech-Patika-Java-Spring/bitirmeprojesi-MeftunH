package com.user.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String userName;

}
