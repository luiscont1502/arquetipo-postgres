package com.shop.peristence.postgres.service;

import com.shop.peristence.postgres.entity.AulaEntity;
import com.shop.peristence.postgres.entity.PersonaEntity;

import java.util.List;

public interface AulaService {
    List<AulaEntity> findAllAula();
    AulaEntity findAulaEntitiesByCodAula(Long codAula);
}
