package com.FinalProject.FinalProject.user.converter;

import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserUpdateRequestDto;
import com.FinalProject.FinalProject.user.entity.User;
import com.FinalProject.FinalProject.user.dto.UserAuthDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequestDto userSaveRequestDto);

    User convertToUser(UserUpdateRequestDto userUpdateRequestDto);

    List<UserDto> convertToUserDtoList(List<User> userList);

    UserDto convertToUserDto(User user);
    UserAuthDto convertToUserAuthDto(User user);
}
