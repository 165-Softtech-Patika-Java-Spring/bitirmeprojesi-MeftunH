package com.FinalProject.FinalProject.user.service;

import com.FinalProject.FinalProject.general.exceptions.ItemNotFoundException;
import com.FinalProject.FinalProject.user.converter.UserMapper;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import com.FinalProject.FinalProject.user.dto.UserUpdateRequestDto;
import com.FinalProject.FinalProject.user.entity.User;
import com.FinalProject.FinalProject.user.dto.UserAuthDto;
import com.FinalProject.FinalProject.user.enums.UserNotFoundErrorMessage;
import com.FinalProject.FinalProject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserEntityService userEntityService;
    @Autowired
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

    public boolean existsUserByUserName(String username) {
        User user = userEntityService.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        User user = userEntityService.getByIdWithControl(id);

        userEntityService.delete(user);
    }

    public UserDto update(UserUpdateRequestDto userUpdateRequestDto) {
        controlIsUserExist(userUpdateRequestDto);

        User user;
        user = UserMapper.INSTANCE.convertToUser(userUpdateRequestDto);
        userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }
    private void controlIsUserExist(UserUpdateRequestDto userUpdateRequestDto) {

        Long id = userUpdateRequestDto.getId();

        boolean isExist = userEntityService.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(UserNotFoundErrorMessage.UserNotFoundErrorMessage);
        }
    }
}