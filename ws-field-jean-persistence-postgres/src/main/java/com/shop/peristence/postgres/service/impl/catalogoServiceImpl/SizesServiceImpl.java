package com.shop.peristence.postgres.service.impl.catalogoServiceImpl;

import com.shop.peristence.postgres.dto.TallaProjection;
import com.shop.peristence.postgres.entity.catalog.SizesEntity;
import com.shop.peristence.postgres.repository.catalogoRepository.SizesRepository;
import com.shop.peristence.postgres.service.catalogoService.SizesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizesServiceImpl implements SizesService {
    @Autowired
    private SizesRepository sizesRepository;
    @Override
    public List<SizesEntity> findAllTalla() {
        return sizesRepository.findAll();
    }

    @Override
    public SizesEntity saveOrUpdate(SizesEntity talla) {
        return sizesRepository.save(talla);
    }

    @Override
    public List<TallaProjection> findTallaDto() {
        return sizesRepository.findTallaDto();
    }
}
