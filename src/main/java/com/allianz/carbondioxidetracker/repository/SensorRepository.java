package com.allianz.carbondioxidetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allianz.carbondioxidetracker.entity.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String>{



}
