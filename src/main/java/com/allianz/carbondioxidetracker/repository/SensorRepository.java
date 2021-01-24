package com.allianz.carbondioxidetracker.repository;

import com.allianz.carbondioxidetracker.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String>{

	@Query("SELECT s FROM Sensor s WHERE LOWER(s.city) = LOWER(:cityName)")
	public List<Sensor> findSensorByCity(@Param("cityName") String cityName);
	
	@Query("SELECT s FROM Sensor s WHERE LOWER(s.district) = LOWER(:district)")
	public List<Sensor> findSensorByDistrict(@Param("district") String district);
	
//	@Query("SELECT s FROM Sensor s inneJOIN s.sensorReadings r WHERE LOWER(s.city) = LOWER(:cityName) AND t.time > :fromDate")
//	public List<Sensor> findSensorByCityAndFDate(@Param("cityName") String cityName, @Param("fromDate") Date fromDate);
//	
}
