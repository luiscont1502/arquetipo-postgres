package com.shop.service.controller;

import com.shop.peristence.postgres.entity.AulaEntity;
import com.shop.peristence.postgres.entity.PersonaEntity;
import com.shop.peristence.postgres.service.AulaService;
import com.shop.peristence.postgres.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping("/getAll")
    private ResponseEntity<List<AulaEntity>> findAllPerson(){
        return ResponseEntity.ok(aulaService.findAllAula());
    }

    @GetMapping("/findBy/{codAula}")
    private ResponseEntity<AulaEntity> findAulaByCodAula(@PathVariable("codAula") Long codAula){
        return ResponseEntity.ok(aulaService.findAulaEntitiesByCodAula(codAula));
    }

}
