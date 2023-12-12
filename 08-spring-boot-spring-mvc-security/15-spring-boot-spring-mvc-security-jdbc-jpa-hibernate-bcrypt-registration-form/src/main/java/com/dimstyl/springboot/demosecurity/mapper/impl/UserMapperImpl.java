package com.dimstyl.springboot.demosecurity.mapper.impl;

import com.dimstyl.springboot.demosecurity.dto.UserDto;
import com.dimstyl.springboot.demosecurity.entity.User;
import com.dimstyl.springboot.demosecurity.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User mapToUser(UserDto userDto) {
        return User.builder()
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .enabled(true)
                .build();
    }

    @Override
    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .build();
    }
}
