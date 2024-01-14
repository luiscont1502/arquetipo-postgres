package com.shop.persistence.security.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "branch")
public class BranchSecurityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_branch")
    private int idBranch;
    @Basic
    @Column(name = "id_city")
    private Integer idCity;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "name")
    private String name;
}
