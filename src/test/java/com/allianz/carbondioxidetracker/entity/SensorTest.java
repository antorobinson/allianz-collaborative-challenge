package com.allianz.carbondioxidetracker.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class SensorTest {


    @Test
    public void testGettersAndSetters() {

        final Sensor entity = new Sensor() ;

        final Date date = new Date() ;

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

