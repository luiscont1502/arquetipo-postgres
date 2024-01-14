package com.shop.peristence.postgres.service;

import com.shop.peristence.postgres.entity.StaffEntity;

import java.util.List;

public interface StaffService {

    List<StaffEntity> findAllPersona();
    void saveOrUpdate(StaffEntity personalEntity);
}
