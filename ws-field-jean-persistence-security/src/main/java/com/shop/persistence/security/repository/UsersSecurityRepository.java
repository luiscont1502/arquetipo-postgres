package com.shop.persistence.security.repository;

import com.shop.persistence.security.entity.UsersSecurityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSecurityRepository extends JpaRepository<UsersSecurityEntity,Integer> {
 UsersSecurityEntity findFirstByEmail(String correo);
}
