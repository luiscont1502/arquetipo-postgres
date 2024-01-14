package com.shop.peristence.postgres.service.catalogoService;

import com.shop.peristence.postgres.entity.catalog.CityEntity;

import java.util.List;

public interface CityService {
    List<CityEntity> findAllCiudad();
}
