package com.shop.persistence.security.service.impl;

import com.shop.persistence.security.entity.UsersSecurityEntity;
import com.shop.persistence.security.repository.UsersSecurityRepository;
import com.shop.persistence.security.service.UsersSecurityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UsersSecurityServiceImpl implements UsersSecurityService {
    @Autowired
    private UsersSecurityRepository usersSecurityRepository;
    @Override
    public void SaveOrUpdate(UsersSecurityEntity usersSecurityEntity) {
        try {
            usersSecurityRepository.save(usersSecurityEntity);
        }catch(Exception e){
        log.info("Error en SaveOrUpdate() : {}",e.getMessage());
        }
    }

    @Override
    public List<UsersSecurityEntity> findAllUsuarios() {
        return usersSecurityRepository.findAll();
    }

}
