package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Long> {
}
