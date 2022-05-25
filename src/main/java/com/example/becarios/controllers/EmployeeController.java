package com.example.becarios.controllers;

import com.example.becarios.models.dao.EmployeeEntityDAO;
import com.example.becarios.models.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmypool/employee")
public class EmployeeController {

    @Autowired
    private EmployeeEntityDAO employeeEntityDAO;

    @GetMapping
    public List<EmployeeEntity> findAllEmployees(){
        return (List<EmployeeEntity>) employeeEntityDAO.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable(value = "code") String code) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(Integer.parseInt(code));

        if(employee.isPresent()) {
            return  ResponseEntity.ok().body(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@Validated @RequestBody EmployeeEntity employee) {
        return employeeEntityDAO.save(employee);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "code") String code) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(Integer.parseInt(code));
        if(employee.isPresent()) {
            employeeEntityDAO.deleteById(Integer.parseInt(code));
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
