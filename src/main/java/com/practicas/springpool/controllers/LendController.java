package com.practicas.springpool.controllers;

import com.practicas.springpool.models.dao.LendEntityDAO;
import com.practicas.springpool.models.entities.LendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmypool/lend")
public class LendController {

    @Autowired
    private LendEntityDAO lendEntityDAO;

    @GetMapping
    public List<LendEntity> findAllLendings(){
        return (List<LendEntity>) lendEntityDAO.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<LendEntity> findLendingById(@PathVariable(value = "code") String code) {
        Optional<LendEntity> lending = lendEntityDAO.findById(Integer.parseInt(code));

        if(lending.isPresent()) {
            return  ResponseEntity.ok().body(lending.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LendEntity saveLending(@Validated @RequestBody LendEntity lending) {
        return lendEntityDAO.save(lending);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteLending(@PathVariable(value = "code") String code) {
        Optional<LendEntity> user = lendEntityDAO.findById(Integer.parseInt(code));
        if(user.isPresent()) {
            lendEntityDAO.deleteById(Integer.parseInt(code));
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
