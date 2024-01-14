package com.shop.peristence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "actions")
public class ActionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_actions")
    private int idActions;
    @Basic
    @Column(name = "id_staff")
    private Integer idStaff;
    @Basic
    @Column(name = "id_roles")
    private Integer idRoles;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "visualization")
    private Boolean visualization;
    @Basic
    @Column(name = "deactivation")
    private Boolean deactivation;
}
