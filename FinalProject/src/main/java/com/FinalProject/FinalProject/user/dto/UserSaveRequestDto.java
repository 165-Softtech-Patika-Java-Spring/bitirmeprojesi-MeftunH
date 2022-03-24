package com.FinalProject.FinalProject.user.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;

@Data
public class UserSaveRequestDto {
    private String name;
    private String surname;
    private String password;
    private String userName;

}
