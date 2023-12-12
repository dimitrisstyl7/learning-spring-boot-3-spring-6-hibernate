package com.dimstyl.springboot.demosecurity.mapper;

import com.dimstyl.springboot.demosecurity.dto.UserDto;
import com.dimstyl.springboot.demosecurity.entity.User;

public interface UserMapper {
    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);
}
