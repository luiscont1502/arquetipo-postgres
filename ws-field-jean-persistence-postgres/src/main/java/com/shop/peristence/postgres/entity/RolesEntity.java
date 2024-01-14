package com.shop.peristence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "roles")
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_roles")
    private int idRoles;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "name")
    private String name;

}
