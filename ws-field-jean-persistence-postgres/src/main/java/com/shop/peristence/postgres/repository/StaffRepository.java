package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Long> {

}
