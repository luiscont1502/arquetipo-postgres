package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.StaffEntity;
import com.shop.peristence.postgres.interfaces.StaffInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<StaffEntity,Integer> {

    @Query("select s.branch.name as branch, s.rol.name as rol,s.users.username as user,s.charge as charge,s.type as type from StaffEntity s")
    List<StaffInterface> findListStaff(Pageable page);

}
