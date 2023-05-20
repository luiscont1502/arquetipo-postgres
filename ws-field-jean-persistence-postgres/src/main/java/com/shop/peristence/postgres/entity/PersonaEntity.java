package com.shop.peristence.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "persona", schema = "public", catalog = "postgres")
public class PersonaEntity {
    @Id
    @Column(name = "cod_persona")
    private Long codPersona;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "ced")
    private String ced;

}
