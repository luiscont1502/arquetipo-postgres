package com.shop.persistence.security.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "customer")
public class CustomerSecurityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic
    @Column(name = "id_users")
    private Integer idUsers;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "frecuency")
    private Integer frecuency;
}
