package com.shop.peristence.postgres.service.impl;

import com.shop.peristence.postgres.entity.AlumnoEntity;
import com.shop.peristence.postgres.repository.AlumnoRepository;
import com.shop.peristence.postgres.service.AlumnoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Override
    public List<AlumnoEntity> finAllAlumno() {
        return alumnoRepository.findAll();
    }
}
