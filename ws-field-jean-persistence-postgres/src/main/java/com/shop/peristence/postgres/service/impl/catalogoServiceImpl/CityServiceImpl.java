package com.shop.peristence.postgres.service.impl.catalogoServiceImpl;

import com.shop.peristence.postgres.entity.catalog.CityEntity;
import com.shop.peristence.postgres.repository.catalogoRepository.CityRepository;
import com.shop.peristence.postgres.service.catalogoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<CityEntity> findAllCiudad() {
        return cityRepository.findAll();
    }
}
