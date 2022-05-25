package com.example.becarios.models.dao;

import com.example.becarios.models.entities.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeviceEntityDAO extends CrudRepository<DeviceEntity, Integer> {
}
