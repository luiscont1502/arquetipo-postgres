package com.shop.peristence.postgres.repository.catalogoRepository;

import com.shop.peristence.postgres.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity,Long> {
}
