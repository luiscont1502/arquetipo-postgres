package com.shop.persistence.security.repository;

import com.shop.persistence.security.dto.interfaces.UserInterfaces;
import com.shop.persistence.security.entity.StaffSecurityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffSecurityRepository extends JpaRepository<StaffSecurityEntity,Integer> {

    @Query("select p.users.username as userName, p.users.password as password ,p.rol as rol from StaffSecurityEntity p where p.users.username=:username")
    UserInterfaces getUserByUsername(@Param("username")  String username);
}
