package com.shop.service.controller;

import com.shop.peristence.postgres.entity.StaffEntity;
import com.shop.peristence.postgres.service.StaffService;
import com.shop.persistence.security.dto.interfaces.UserInterfaces;
import com.shop.persistence.security.entity.StaffSecurityEntity;
import com.shop.persistence.security.service.StaffSecurityService;
import com.shop.service.dto.ConsultaDto;
import com.shop.persistence.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class StaffController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffSecurityService staffSecurityService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/getAll")
    private ResponseEntity<List<StaffEntity>> findAllPerson(){
        return ResponseEntity.ok( staffService.findAllPersona());
    }
    @PostMapping("/createPersonal")
    public ResponseEntity<?> createPersonal(@RequestBody StaffSecurityEntity staffSecurityEntity){
        StaffSecurityEntity p=staffSecurityEntity;
        staffSecurityEntity.getUsers().setPassword(staffSecurityEntity.getUsers().getPassword());
        staffSecurityService.saveOrUpdate(staffSecurityEntity);
        return ResponseEntity.ok(p);
    }
    @PostMapping("/findPersonal")
    public ResponseEntity<?> findPersonal(@RequestBody ConsultaDto consultaDto){
        UserInterfaces usuario= staffSecurityService.getUsuario(consultaDto.getCorreo());
        return ResponseEntity.ok(userDetailsService.loadUserByUsername(consultaDto.getCorreo()));
        //return ResponseEntity.ok(usuario);
    }


}
