package com.example.becarios.models.dao;

import com.example.becarios.models.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeEntityDAO extends CrudRepository<EmployeeEntity, Integer> {
}
