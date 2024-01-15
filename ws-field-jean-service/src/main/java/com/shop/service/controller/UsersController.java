package com.shop.service.controller;

import com.shop.peristence.postgres.entity.UsersEntity;
import com.shop.peristence.postgres.interfaces.UserInterface;
import com.shop.peristence.postgres.service.UsersService;
import com.shop.persistence.security.entity.StaffSecurityEntity;
import com.shop.persistence.security.service.StaffSecurityService;
import com.shop.service.enums.EnumResponse;
import com.shop.service.model.ResponseData;
import com.shop.service.model.ResponseModel;
import com.shop.service.model.SearchDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private StaffSecurityService staffSecurityService;

    @Autowired
    private UsersService usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/userAll")
    public ResponseEntity<ResponseData<List<StaffSecurityEntity>>> getUserAll(){
        ResponseData<List<StaffSecurityEntity>> response= new ResponseData<>(EnumResponse.VACIO.code());
        try {
            response.setData(staffSecurityService.getUsuarios());
        }catch (Exception e){
            log.error("Error en el getUserAll()",e);
            response.setMessage(e.getMessage());
        }
       return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/fingUserByEmail")
    public ResponseEntity<?> getUsuarioByCorreo(@Param("email") String email){
        return ResponseEntity.ok(staffSecurityService.getUsuario("luiscont1502@gmail.com"));
    }
    @PostMapping("/createUser")
    public ResponseEntity<ResponseModel> saveUser(@RequestBody UsersEntity  users){
        ResponseModel response = new ResponseModel(EnumResponse.OK.code());
        try {
            boolean userExist=usersService.findUserExist(users.getUsername());
            if(userExist){
                response.setMessage("El Usuario existe");
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            users.setCreationDate(new Timestamp(new Date().getTime()));
            users.setModificationDate(new Timestamp(new Date().getTime()));
            usersService.saveOrUpdate(users);
            response.setMessage("Registro Exitoso");
        }catch (Exception e){
            log.info("Error saveUser(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/GetAllUsers")
    public ResponseEntity<ResponseData<List<UserInterface>>> findListUsers(@RequestBody SearchDto searchDto){
        ResponseData<List<UserInterface>> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            response.setData(usersService.findListUsers(PageRequest.of(searchDto.getPage(),searchDto.getSize())));
        }catch(Exception e){
            log.info("Error saveUser(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }




}
