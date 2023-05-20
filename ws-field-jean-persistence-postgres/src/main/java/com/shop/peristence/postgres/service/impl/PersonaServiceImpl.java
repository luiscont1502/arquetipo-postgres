package com.shop.peristence.postgres.service.impl;

import com.shop.peristence.postgres.entity.PersonaEntity;
import com.shop.peristence.postgres.repository.PersonaRepository;
import com.shop.peristence.postgres.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<PersonaEntity> findAllPersona() {
        return personaRepository.findAll();
    }
}
