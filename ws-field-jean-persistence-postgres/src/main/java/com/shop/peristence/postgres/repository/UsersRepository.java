package com.shop.peristence.postgres.repository;

import com.shop.peristence.postgres.entity.UsersEntity;
import com.shop.peristence.postgres.interfaces.UserInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
    boolean existsUsersEntitiesByUsername(String userName);

    @Query("select u.idUsers as idUsers ,u.city.name as city,u.names as names, u.lastname as lastname," +
            "u.identification as identification,u.email as email,u.customerType as customerType,u.username as username from UsersEntity u")
    List<UserInterface> findListUsers(Pageable page);
}
