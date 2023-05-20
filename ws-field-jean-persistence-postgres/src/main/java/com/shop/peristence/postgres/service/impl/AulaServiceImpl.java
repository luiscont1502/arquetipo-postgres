package com.shop.peristence.postgres.service.impl;

import com.shop.peristence.postgres.entity.AulaEntity;
import com.shop.peristence.postgres.repository.AulaRepository;
import com.shop.peristence.postgres.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;
    @Override
    public List<AulaEntity> findAllAula() {
        return aulaRepository.findAll();
    }

    @Override
    public AulaEntity findAulaEntitiesByCodAula(Long codAula) {
        return aulaRepository.findAulaByCodAula(codAula);
    }
}
