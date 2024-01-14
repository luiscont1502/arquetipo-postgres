package com.shop.peristence.postgres.repository.catalogoRepository;

import com.shop.peristence.postgres.dto.TallaProjection;
import com.shop.peristence.postgres.entity.catalog.SizesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizesRepository extends JpaRepository<SizesEntity,Long> {
    @Query("select t.idSizes,t.name from SizesEntity t")
    List<TallaProjection> findTallaDto();
}
