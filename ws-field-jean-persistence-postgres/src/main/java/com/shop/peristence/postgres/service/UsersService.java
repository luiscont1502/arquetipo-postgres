package com.shop.peristence.postgres.service;

import com.shop.peristence.postgres.entity.UsersEntity;

import java.util.List;

public interface UsersService {
    List<UsersEntity> getAllUsuarios();
}
