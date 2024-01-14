package com.shop.persistence.security.dto.interfaces;

import com.shop.persistence.security.entity.RolesSecurityEntity;

public interface UserInterfaces {

    String getUserName();

    String getPassword();

    RolesSecurityEntity getRol();
}
