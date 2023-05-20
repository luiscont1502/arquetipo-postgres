package com.shop.peristence.postgres.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "aula", schema = "public", catalog = "postgres")
public class AulaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod_aula")
    private Long codAula;
    @Column(name = "estado")
    private Integer estado;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "aprobacion")
    private String aprobacion;

    @OneToMany(mappedBy = "aula",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AlumnoEntity> alumnos;

}
