package com.FinalProject.FinalProject.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSaveRequestDto {
    private String name;
    private String surname;
    private String password;
    private String userName;

}
