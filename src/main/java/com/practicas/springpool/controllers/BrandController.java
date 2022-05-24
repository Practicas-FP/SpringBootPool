package com.practicas.springpool.controllers;

import com.practicas.springpool.models.dao.BrandEntityDAO;
import com.practicas.springpool.models.entities.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmypool/brand")
public class BrandController {
    @Autowired
    private BrandEntityDAO brandEntityDAO;

    @GetMapping
    public List<BrandEntity> findAllBrand(){
        return (List<BrandEntity>) brandEntityDAO.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<BrandEntity> findBrandById(@PathVariable(value = "code") String code) {
        Optional<BrandEntity> brand = brandEntityDAO.findById(Integer.parseInt(code));

        if(brand.isPresent()) {
            return  ResponseEntity.ok().body(brand.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public BrandEntity saveBrand(@Validated @RequestBody BrandEntity brand) {
        return brandEntityDAO.save(brand);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteBrand(@PathVariable(value = "code") String code) {
        Optional<BrandEntity> brand = brandEntityDAO.findById(Integer.parseInt(code));
        if(brand.isPresent()) {
            brandEntityDAO.deleteById(Integer.parseInt(code));
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
