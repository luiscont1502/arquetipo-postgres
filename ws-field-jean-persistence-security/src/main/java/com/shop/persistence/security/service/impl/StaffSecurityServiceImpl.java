package com.shop.persistence.security.service.impl;

import com.shop.persistence.security.dto.interfaces.UserInterfaces;
import com.shop.persistence.security.entity.StaffSecurityEntity;
import com.shop.persistence.security.repository.StaffSecurityRepository;
import com.shop.persistence.security.service.StaffSecurityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
public class StaffSecurityServiceImpl implements StaffSecurityService {
    @Autowired
    private StaffSecurityRepository staffSecurityRepository;

    @Override
    public void saveOrUpdate(StaffSecurityEntity staffSecurityEntity) {
        try{
            staffSecurityRepository.save(staffSecurityEntity);
        }catch(Exception e){
            log.info("Error en saveOrUpdate() PersonalSecurityServiceImpl ");
        }
    }

    @Override
    public UserInterfaces getUsuario(String username) {
        try{
            return staffSecurityRepository.getUserByUsername(username);
        }catch(Exception e){
            log.info("Error en saveOrUpdate() PersonalSecurityServiceImpl ");
            return null;
        }

    }

    @Override
    public List<StaffSecurityEntity> getUsuarios() {
        return staffSecurityRepository.findAll();
    }
}
