package com.FinalProject.FinalProject.user.service;

import com.FinalProject.FinalProject.user.converter.UserMapper;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import com.FinalProject.FinalProject.user.entity.User;
import com.FinalProject.FinalProject.user.dto.UserAuthDto;
import com.FinalProject.FinalProject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserEntityService userEntityService;
    private PasswordEncoder passwordEncoder;

    public UserDto save(UserSaveRequestDto userSaveRequestDto) {

        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        user.setUserName(userSaveRequestDto.getUserName());
        user.setPassword(passwordEncoder.encode(userSaveRequestDto.getPassword()));
        user.setName(userSaveRequestDto.getName());
        user.setSurname(userSaveRequestDto.getSurname());

        user = userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public UserDto getUserByUsername(String username) {
        User user = userEntityService.getUserByUsername(username);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    public UserAuthDto getAuthenticatedUser(String username) {
        User user = userEntityService.getUserByUsername(username);
        UserAuthDto userDto = UserMapper.INSTANCE.convertToUserAuthDto(user);
        return userDto;
    }
}