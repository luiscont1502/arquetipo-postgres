package com.shop.peristence.postgres.service;

import com.shop.peristence.postgres.entity.StaffEntity;
import com.shop.peristence.postgres.interfaces.StaffInterface;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StaffService {

    List<StaffEntity> findAllPersona();
    void saveOrUpdate(StaffEntity personalEntity);
    List<StaffInterface> findListStaff(Pageable page);
}
