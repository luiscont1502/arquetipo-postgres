package com.shop.persistence.security.service;

import com.shop.persistence.security.entity.UsersSecurityEntity;

import java.util.List;

public interface UsersSecurityService {
    void SaveOrUpdate(UsersSecurityEntity usersSecurityEntity);

    List<UsersSecurityEntity> findAllUsuarios();

}
