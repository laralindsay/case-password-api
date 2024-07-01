package com.example.passwordvalidatorapi.services;

import com.example.passwordvalidatorapi.domain.user.User;
import com.example.passwordvalidatorapi.dto.UserDto;
import com.example.passwordvalidatorapi.repositories.UserRepository;
import com.example.passwordvalidatorapi.utils.enums.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto createdUser(UserDto userDto){
        User userDtoToBeCreated = EntityToDtoMapper.mapUserDtoToUser(userDto);

        User savedUser =  userRepository.save(userDtoToBeCreated);

        return EntityToDtoMapper.mapUserToUserDto(savedUser);
    }

}
