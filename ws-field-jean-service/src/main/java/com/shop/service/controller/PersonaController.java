package com.shop.service.controller;


import com.shop.peristence.postgres.entity.PersonaEntity;
import com.shop.peristence.postgres.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/getAll")
    private ResponseEntity<List<PersonaEntity>> findAllPerson(){
        return ResponseEntity.ok( personaService.findAllPersona());
    }
}
