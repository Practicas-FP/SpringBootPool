package com.practicas.springpool.models.dao;

import com.practicas.springpool.models.entities.LendEntity;
import org.springframework.data.repository.CrudRepository;

public interface LendEntityDAO extends CrudRepository<LendEntity, Integer> {
}
