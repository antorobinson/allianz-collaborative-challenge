package com.allianz.carbondioxidetracker.repository;

import com.allianz.carbondioxidetracker.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String>{



}
