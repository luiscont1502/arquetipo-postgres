package com.shop.service.controller;

import com.shop.peristence.postgres.entity.AlumnoEntity;
import com.shop.peristence.postgres.entity.AulaEntity;
import com.shop.peristence.postgres.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    @GetMapping("/getAll")
    private ResponseEntity<List<AlumnoEntity>> findAllPerson(){
        return ResponseEntity.ok(alumnoService.finAllAlumno());
    }

}
