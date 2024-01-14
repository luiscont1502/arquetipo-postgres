package com.shop.persistence.security.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "city")
public class CitySecurityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_city")
    private int idCity;
    @Basic
    @Column(name = "name")
    private String name;

}
