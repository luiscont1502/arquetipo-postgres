package com.shop.peristence.postgres.service.impl;

import com.shop.peristence.postgres.entity.UsersEntity;
import com.shop.peristence.postgres.repository.UsersRepository;
import com.shop.peristence.postgres.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UsersEntity> getAllUsuarios() {
        return usersRepository.findAll();
    }
}
