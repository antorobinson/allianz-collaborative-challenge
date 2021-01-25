/*
 * This is only for an interview purpose in Allianz Technology,
 * This code is developed by 4 interview candidates.
 * This is written in free version Java 8 .
 * This is written in spring boot version 2.4.2 .
 * This is an open source .
 * This code meets most of the SOLID principles.
 * No Copyrights or no rights reserved .
 * Any one can use this code for their organization, personal or learning purposes.
 * ANY ONE CAN ALTER THIS CODE OR THIS FILE.
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 */
package com.allianz.carbondioxidetracker.repository;

import com.allianz.carbondioxidetracker.repository.entity.Sensor;
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
	
}
