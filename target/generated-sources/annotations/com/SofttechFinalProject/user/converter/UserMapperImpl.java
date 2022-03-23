package com.SofttechFinalProject.user.converter;

import com.SofttechFinalProject.user.dto.UserDto;
import com.SofttechFinalProject.user.dto.UserSaveRequestDto;
import com.SofttechFinalProject.user.dto.UserUpdateRequestDto;
import com.SofttechFinalProject.user.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-24T00:32:57+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(UserSaveRequestDto userSaveRequestDto) {
        if ( userSaveRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userSaveRequestDto.getName() );
        user.setSurname( userSaveRequestDto.getSurname() );
        user.setUserName( userSaveRequestDto.getUserName() );
        user.setPassword( userSaveRequestDto.getPassword() );

        return user;
    }

    @Override
    public User convertToUser(UserUpdateRequestDto userUpdateRequestDto) {
        if ( userUpdateRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userUpdateRequestDto.getId() );
        user.setName( userUpdateRequestDto.getName() );
        user.setSurname( userUpdateRequestDto.getSurname() );
        user.setUserName( userUpdateRequestDto.getUserName() );
        user.setPassword( userUpdateRequestDto.getPassword() );

        return user;
    }

    @Override
    public List<UserDto> convertToUserDtoList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( convertToUserDto( user ) );
        }

        return list;
    }

    @Override
    public UserDto convertToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setSurname( user.getSurname() );
        userDto.setUserName( user.getUserName() );

        return userDto;
    }
}
