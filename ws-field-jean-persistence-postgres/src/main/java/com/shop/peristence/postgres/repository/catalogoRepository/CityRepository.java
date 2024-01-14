package com.shop.peristence.postgres.repository.catalogoRepository;

import com.shop.peristence.postgres.entity.catalog.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity,Long> {

}
