package com.example.passwordvalidatorapi.utils.enums;

import com.example.passwordvalidatorapi.domain.user.User;
import com.example.passwordvalidatorapi.dto.UserDto;

import java.util.stream.Collectors;

public class EntityToDtoMapper {
    public static UserDto mapUserToUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static User mapUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public static void mapUserDtoToUser(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
    }
}
