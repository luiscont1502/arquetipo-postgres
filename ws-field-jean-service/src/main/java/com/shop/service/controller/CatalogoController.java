package com.shop.service.controller;

import com.shop.peristence.postgres.dto.TallaProjection;
import com.shop.peristence.postgres.entity.BrandEntity;
import com.shop.peristence.postgres.entity.catalog.CityEntity;
import com.shop.peristence.postgres.entity.catalog.SizesEntity;
import com.shop.peristence.postgres.service.catalogoService.CityService;
import com.shop.peristence.postgres.service.catalogoService.BrandService;
import com.shop.peristence.postgres.service.catalogoService.SizesService;
import com.shop.service.dto.ErrorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private SizesService sizesService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CityService cityService;
    @GetMapping("/talla/getAll")
    private ResponseEntity<List<SizesEntity>> findAllTalla(){
        return ResponseEntity.ok(sizesService.findAllTalla());
    }
    @GetMapping("/talla/getAllDto")
    private ResponseEntity<List<TallaProjection>> findAllTallaDto(){
        return ResponseEntity.ok(sizesService.findTallaDto());
    }

    @GetMapping("/marca/getAll")
    private ResponseEntity<List<BrandEntity>> findAllMarca(){
        return ResponseEntity.ok(brandService.findAllMarca());
    }

    @GetMapping("/ciudad/getAll")
    private ResponseEntity<List<CityEntity>> findAllCiudad(){return ResponseEntity.ok(cityService.findAllCiudad());}

    @PostMapping("/Talla")
    private ResponseEntity<Integer> saveTalla(@RequestBody SizesEntity talla){
        try{
            SizesEntity tallaSave= sizesService.saveOrUpdate(talla);
            return new ResponseEntity<>(tallaSave.getIdSizes(), HttpStatus.OK);
        }catch(Exception e){
            ErrorResponseDto errorResponse=new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),e.getMessage());
            return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
        }

    }
}
