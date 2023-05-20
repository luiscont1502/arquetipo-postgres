package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity,Long> {
}
