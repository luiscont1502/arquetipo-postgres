package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.AulaEntity;
import com.shop.peristence.postgres.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AulaRepository extends JpaRepository<AulaEntity,Long> {

    @Query("select a from AulaEntity a where a.codAula=:codAula")
    AulaEntity findAulaByCodAula(@Param("codAula") Long codAula);
}
