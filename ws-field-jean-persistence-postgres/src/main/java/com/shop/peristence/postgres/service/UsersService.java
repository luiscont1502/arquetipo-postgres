package com.shop.peristence.postgres.service;

import com.shop.peristence.postgres.entity.UsersEntity;
import com.shop.peristence.postgres.interfaces.UserInterface;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsersService {
    List<UsersEntity> getAllUsuarios();
    void saveOrUpdate( UsersEntity users);
    boolean findUserExist(String username);
    List<UserInterface> findListUsers(Pageable page);

}
