package com.shop.peristence.postgres.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "alumno", schema = "public", catalog = "postgres")
public class AlumnoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod_alumno")
    private int codAlumno;

    @Column(name = "cod_aula")
    private Integer codAula;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "aprobacion")
    private String aprobacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_aula",insertable=false, updatable=false)
    @JsonBackReference
    private AulaEntity aula;


}
