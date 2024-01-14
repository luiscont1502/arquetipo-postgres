package com.shop.peristence.postgres.entity;

import com.shop.peristence.postgres.entity.catalog.CityEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "users")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_users")
    private int idUsers;
    @Basic
    @Column(name = "id_city")
    private Integer idCity;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "names")
    private String names;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "identification")
    private String identification;
    @Basic
    @Column(name = "address1")
    private String address1;
    @Basic
    @Column(name = "address2")
    private String address2;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "customer_type")
    private String customerType;
    @Basic
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @Basic
    @Column(name = "modification_date")
    private Timestamp modificationDate;
    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false,insertable=false, updatable=false)
    private CityEntity ciudad;
}
