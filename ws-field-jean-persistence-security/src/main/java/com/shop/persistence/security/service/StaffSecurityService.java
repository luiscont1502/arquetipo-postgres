package com.shop.persistence.security.service;

import com.shop.persistence.security.dto.interfaces.UserInterfaces;
import com.shop.persistence.security.entity.StaffSecurityEntity;

import java.util.List;

public interface StaffSecurityService {
    void saveOrUpdate(StaffSecurityEntity staffSecurityEntity);

    UserInterfaces getUsuario(String username);

    List<StaffSecurityEntity> getUsuarios();
}
