package com.practicas.springpool.models.dao;

import com.practicas.springpool.models.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeEntityDAO extends CrudRepository<EmployeeEntity, Integer> {
}
