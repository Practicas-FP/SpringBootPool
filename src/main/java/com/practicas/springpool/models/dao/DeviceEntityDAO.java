package com.practicas.springpool.models.dao;

import com.practicas.springpool.models.entities.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeviceEntityDAO extends CrudRepository<DeviceEntity, Integer> {
}
