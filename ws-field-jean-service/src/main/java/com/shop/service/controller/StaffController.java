package com.shop.service.controller;

import com.shop.peristence.postgres.entity.StaffEntity;
import com.shop.peristence.postgres.interfaces.StaffInterface;
import com.shop.peristence.postgres.interfaces.UserInterface;
import com.shop.peristence.postgres.service.StaffService;
import com.shop.persistence.security.dto.interfaces.UserInterfaces;
import com.shop.persistence.security.entity.StaffSecurityEntity;
import com.shop.persistence.security.service.StaffSecurityService;
import com.shop.service.dto.ConsultaDto;
import com.shop.persistence.security.service.impl.UserDetailsServiceImpl;
import com.shop.service.enums.EnumResponse;
import com.shop.service.model.ResponseData;
import com.shop.service.model.ResponseModel;
import com.shop.service.model.SearchDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@Log4j2
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
    @PostMapping("/createStaff")
    public ResponseEntity<ResponseModel> createPersonal(@RequestBody StaffEntity staffEntity){
        ResponseModel response = new ResponseModel(EnumResponse.OK.code());
        try {
            staffService.saveOrUpdate(staffEntity);
            response.setMessage("Registro Exitoso");
        }catch (Exception e){
            log.info("Error saveUser(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/findAllStaff")
    public ResponseEntity<ResponseData<List<StaffInterface>>> findListStaff(@RequestBody SearchDto searchDto){
        ResponseData<List<StaffInterface>> response=new ResponseData<>(EnumResponse.VACIO.code());
        try{
            List<StaffInterface> usuario= staffService.findListStaff(PageRequest.of(searchDto.getPage(),searchDto.getSize()));
            response.setData(usuario);
        }catch(Exception e){
            log.info("Error findListStaff(): ",e);
            response.setMessage("Error : "+e.getMessage());
            response.setCode(EnumResponse.ERROR.code());
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
