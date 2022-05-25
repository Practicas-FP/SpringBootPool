package com.example.becarios.controllers;

import com.example.becarios.models.dao.DeviceEntityDAO;
import com.example.becarios.models.dao.LendEntityDAO;
import com.example.becarios.models.entities.DeviceEntity;
import com.example.becarios.models.entities.LendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmypool/lend")
public class LendController {

    @Autowired
    private LendEntityDAO lendEntityDAO;

    @Autowired
    private DeviceEntityDAO deviceEntityDAO;

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

    @PostMapping("/lenddevice")
    public LendEntity endLending(@Validated @RequestBody LendEntity lending) {
        Calendar calendar = Calendar.getInstance();
        Date ourJavaDateObject = new Date(calendar.getTime().getTime());
        lending.setLendingDate(ourJavaDateObject);
        DeviceEntity device = deviceEntityDAO.findById(lending.getDeviceId()).get();
        device.setIsBooked(1);
        deviceEntityDAO.save(device);
        return lendEntityDAO.save(lending);
    }

    @PostMapping("/returndevice/{code}")
    public ResponseEntity<?> endLending(@PathVariable(value = "code") String code) {
        Optional<LendEntity> lending = lendEntityDAO.findById(Integer.parseInt(code));
        if(lending.isPresent()) {
            LendEntity lendEntity = lending.get();

            Calendar calendar = Calendar.getInstance();
            Date ourJavaDateObject = new Date(calendar.getTime().getTime());

            lendEntity.setReturningDate(ourJavaDateObject);
            lendEntityDAO.save(lendEntity);

            DeviceEntity deviceEntity = deviceEntityDAO.findById(lendEntity.getDeviceId()).get();
            deviceEntity.setIsBooked(0);
            deviceEntityDAO.save(deviceEntity);

            return ResponseEntity.ok().body("Prestamo devuelto");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteLending(@PathVariable(value = "code") String code) {
        Optional<LendEntity> lending = lendEntityDAO.findById(Integer.parseInt(code));
        if(lending.isPresent()) {
            lendEntityDAO.deleteById(Integer.parseInt(code));
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

/*    @PutMapping("/{code}")
    public ResponseEntity<?> endLending(@PathVariable(value = "code") String code) {
        Optional<LendEntity> lending = lendEntityDAO.findById(Integer.parseInt(code));
        if(lending.isPresent()) {
            lendEntityDAO.deleteById(Integer.parseInt(code));
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
