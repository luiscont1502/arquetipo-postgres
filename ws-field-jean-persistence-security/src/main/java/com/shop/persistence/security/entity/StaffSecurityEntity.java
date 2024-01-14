package com.shop.persistence.security.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "staff")
public class StaffSecurityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_staff")
    private Integer idStaff;
    @Basic
    @Column(name = "id_branch")
    private Integer idBranch;
    @Basic
    @Column(name = "id_roles")
    private Integer idRoles;
    @Basic
    @Column(name = "id_users")
    private Integer idUsers;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "charge")
    private String charge;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "approval")
    private String approval;

    @ManyToOne
    @JoinColumn(name = "id_roles", referencedColumnName = "id_roles", insertable = false, updatable = false) // "cod_rol" es el nombre de la columna en la tabla personal que hace referencia al codRol de la tabla rol
    private RolesSecurityEntity rol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_users", referencedColumnName="id_users",insertable=false, updatable=false)
    private UsersSecurityEntity users;

}
