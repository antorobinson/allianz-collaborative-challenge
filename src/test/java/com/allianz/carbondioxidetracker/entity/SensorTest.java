package com.allianz.carbondioxidetracker.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

public class SensorTest {

    @Test
    public void testConstructor() {

        final Sensor sensor = new Sensor("TPK1" , "CITY" , "KNI") ;

        Assertions.assertThat(sensor.getSensorId()).isEqualTo("TPK1") ;
        Assertions.assertThat(sensor.getCity()).isEqualTo("CITY") ;
        Assertions.assertThat(sensor.getDistrict()).isEqualTo("KNI") ;
    }

    @Test
    public void testGettersAndSetters() {

        final Sensor entity = new Sensor() ;

        entity.setSensorId("sensorId");
        entity.setCity("city");
        entity.setDistrict("district");
        entity.setSensorReadings(new ArrayList<>());

        Assertions.assertThat(entity.getSensorId()).isEqualTo("sensorId") ;
        Assertions.assertThat(entity.getCity()).isEqualTo("city") ;
        Assertions.assertThat(entity.getDistrict()).isEqualTo("district") ;
        Assertions.assertThat(entity.getSensorReadings()).isEmpty(); ;
    }
}

