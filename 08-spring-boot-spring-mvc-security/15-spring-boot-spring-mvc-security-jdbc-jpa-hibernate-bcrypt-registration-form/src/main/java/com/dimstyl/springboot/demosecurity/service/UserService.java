package com.dimstyl.springboot.demosecurity.service;

import com.dimstyl.springboot.demosecurity.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto findByUserName(String userName);

    void save(UserDto userDto);
}
