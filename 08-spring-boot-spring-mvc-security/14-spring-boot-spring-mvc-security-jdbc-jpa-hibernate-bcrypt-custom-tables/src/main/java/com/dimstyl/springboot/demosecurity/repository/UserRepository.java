package com.dimstyl.springboot.demosecurity.repository;

import com.dimstyl.springboot.demosecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
