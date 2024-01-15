package com.shop.peristence.postgres.service.impl;

import com.shop.peristence.postgres.entity.StaffEntity;
import com.shop.peristence.postgres.interfaces.StaffInterface;
import com.shop.peristence.postgres.repository.StaffRepository;
import com.shop.peristence.postgres.service.StaffService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Override
    public List<StaffEntity> findAllPersona() {
        try {
            return staffRepository.findAll();
        }catch(Exception e){
            log.info("Error : {}",e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void saveOrUpdate(StaffEntity staffEntity) {
        try {
            staffRepository.save(staffEntity);
        }catch(Exception e){
            log.info("Error : {}",e.getMessage());
        }
    }

    @Override
    public List<StaffInterface> findListStaff(Pageable page) {
        return staffRepository.findListStaff(page);
    }
}
