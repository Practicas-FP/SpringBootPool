package com.practicas.springpool.models.dao;

import com.practicas.springpool.models.entities.BrandEntity;
import org.springframework.data.repository.CrudRepository;

public interface BrandEntityDAO extends CrudRepository<BrandEntity, Integer> {
}
