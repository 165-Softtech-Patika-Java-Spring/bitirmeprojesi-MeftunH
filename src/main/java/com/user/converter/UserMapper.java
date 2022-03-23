package com.user.converter;

import com.user.dto.UserDto;
import com.user.dto.UserSaveRequestDto;
import com.user.dto.UserUpdateRequestDto;
import com.user.entity.User;
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
}
