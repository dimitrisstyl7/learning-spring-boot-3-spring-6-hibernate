package com.dimstyl.cruddemo.repository;

import com.dimstyl.cruddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
