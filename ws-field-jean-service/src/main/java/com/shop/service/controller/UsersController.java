package com.shop.service.controller;

import com.shop.persistence.security.service.StaffSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private StaffSecurityService staffSecurityService;

    @GetMapping("/userAll")
    public ResponseEntity<?> getUserAll(){
        //List<UsuarioEntity> usuarios=usuarioService.getAllUsuarios();

       return ResponseEntity.ok(staffSecurityService.getUsuarios());
    }
    @GetMapping("/userByCorreo")
    public ResponseEntity<?> getUsuarioByCorreo(@Param("correo") String correo){
        //List<UsuarioEntity> usuarios=usuarioService.getAllUsuarios();

        return ResponseEntity.ok(staffSecurityService.getUsuario("luiscont1502@gmail.com"));
    }
    /*@PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Autenticar al usuario
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        // Generar token JWT
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateAccessToken(userDetails.getUsername());

        // Devolver el token en la respuesta
        return ResponseEntity.ok(jwtToken);
    }*/

}
