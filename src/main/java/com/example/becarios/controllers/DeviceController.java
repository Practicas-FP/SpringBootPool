package com.example.becarios.controllers;

import com.example.becarios.models.dao.DeviceEntityDAO;
import com.example.becarios.models.entities.DeviceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmypool/device")
public class DeviceController {

    @Autowired
    private DeviceEntityDAO deviceEntityDAO;

    @GetMapping
    public List<DeviceEntity> findAllUsers(){
        return (List<DeviceEntity>) deviceEntityDAO.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<DeviceEntity> findDeviceById(@PathVariable(value = "code") String code) {
        Optional<DeviceEntity> device = deviceEntityDAO.findById(Integer.parseInt(code));

        if(device.isPresent()) {
            return  ResponseEntity.ok().body(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DeviceEntity saveDevice(@Validated @RequestBody DeviceEntity device) {
        return deviceEntityDAO.save(device);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteDevice(@PathVariable(value = "code") String code) {
        Optional<DeviceEntity> device = deviceEntityDAO.findById(Integer.parseInt(code));
        if(device.isPresent()) {
            deviceEntityDAO.deleteById(Integer.parseInt(code));
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
