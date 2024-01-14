package com.shop.peristence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "supplier")
public class SupplierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_supplier")
    private int idSupplier;
    @Basic
    @Column(name = "id_users")
    private Integer idUsers;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "ruc")
    private String ruc;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "product")
    private String product;
}
