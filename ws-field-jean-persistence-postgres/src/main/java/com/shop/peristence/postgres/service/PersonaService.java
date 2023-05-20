package com.shop.peristence.postgres.service;

import com.shop.peristence.postgres.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    List<PersonaEntity> findAllPersona();
}
