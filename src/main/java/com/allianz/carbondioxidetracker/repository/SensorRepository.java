package com.allianz.carbondioxidetracker.repository;

import com.allianz.carbondioxidetracker.entity.Sensor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String>{

	@Query("SELECT s FROM Sensor s WHERE LOWER(s.city) = LOWER(:cityName)")
	public List<Sensor> findSensorByCity(@Param("cityName") String cityName);
	
	@Query("SELECT s FROM Sensor s WHERE LOWER(s.district) = LOWER(:district)")
	public List<Sensor> findSensorByDistrict(@Param("district") String district);
	
}
