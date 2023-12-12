package com.dimstyl.springboot.demosecurity.repository.impl;

import com.dimstyl.springboot.demosecurity.entity.UserRoles;
import com.dimstyl.springboot.demosecurity.repository.UserRolesDao;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRolesDaoImpl implements UserRolesDao {
    private final EntityManager entityManager;

    @Autowired
    public UserRolesDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(UserRoles userRoles) {
        entityManager.persist(userRoles);
    }
}
