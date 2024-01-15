package com.shop.peristence.postgres.service.catalogoService;

import com.shop.peristence.postgres.interfaces.SizesProjection;
import com.shop.peristence.postgres.entity.catalog.SizesEntity;

import java.util.List;

public interface SizesService {
    List<SizesEntity> findAllTalla();

    SizesEntity saveOrUpdate(SizesEntity talla);
    List<SizesProjection> findTallaDto();


}
