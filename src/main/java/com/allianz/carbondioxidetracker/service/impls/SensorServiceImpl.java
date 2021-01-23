package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SensorServiceImpl implements SensorService {
	
	SensorRepository sensorRepository;
	
	@Autowired
	public void setSensorRepository(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	@Override
	public List<Sensor> retrieveSensors() {
		List<Sensor> sensorList = sensorRepository.findAll();
		return sensorList;
	}

	@Override
	public Sensor getSensorById(String sensorId) {
		Optional<Sensor> optSensor = sensorRepository.findById(sensorId);
		return optSensor.get();
	}

	@Override
	public void saveSensor(Sensor sensor) {
		sensorRepository.save(sensor);
		
	}

	@Override
	public void getSensorReadingsByCity(String city) {
		
		
	}

	@Override
	public void getSensorReadingsByDistrict(String district) {
		// TODO Auto-generated method stub
		
	}
	

}
