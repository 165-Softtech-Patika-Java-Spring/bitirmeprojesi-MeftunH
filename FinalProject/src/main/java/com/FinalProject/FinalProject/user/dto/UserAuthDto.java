package com.FinalProject.FinalProject.user.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private Long id;
    private String name;
    private String password;
    private String surname;
    private String userName;
}
