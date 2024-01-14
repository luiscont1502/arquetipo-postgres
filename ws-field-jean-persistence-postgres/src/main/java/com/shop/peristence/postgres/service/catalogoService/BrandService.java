package com.shop.peristence.postgres.service.catalogoService;

import com.shop.peristence.postgres.entity.BrandEntity;

import java.util.List;

public interface BrandService {
    List<BrandEntity> findAllMarca();
}
