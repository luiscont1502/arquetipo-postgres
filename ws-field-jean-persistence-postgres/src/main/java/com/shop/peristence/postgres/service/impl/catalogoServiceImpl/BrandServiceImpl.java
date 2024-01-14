package com.shop.peristence.postgres.service.impl.catalogoServiceImpl;

import com.shop.peristence.postgres.entity.BrandEntity;
import com.shop.peristence.postgres.repository.catalogoRepository.BrandRepository;
import com.shop.peristence.postgres.service.catalogoService.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<BrandEntity> findAllMarca() {
        return brandRepository.findAll();
    }
}
