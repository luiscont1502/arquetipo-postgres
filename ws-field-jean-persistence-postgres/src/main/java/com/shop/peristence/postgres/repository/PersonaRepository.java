package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {

}
