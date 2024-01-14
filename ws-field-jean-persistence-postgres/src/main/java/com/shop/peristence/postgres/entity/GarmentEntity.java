package com.shop.peristence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "garment")
public class GarmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_garment")
    private int idGarment;
    @Basic
    @Column(name = "id_brand")
    private Integer idBrand;
    @Basic
    @Column(name = "id_sizes")
    private Integer idSizes;
    @Basic
    @Column(name = "id_branch")
    private Integer idBranch;
    @Basic
    @Column(name = "id_supplier")
    private Integer idSupplier;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "unitary_price")
    private BigDecimal unitaryPrice;
    @Basic
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "sex")
    private String sex;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @Basic
    @Column(name = "modification_date")
    private Timestamp modificationDate;

}
