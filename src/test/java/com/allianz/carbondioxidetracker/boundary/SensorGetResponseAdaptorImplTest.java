package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.repository.entity.Reading;
import com.allianz.carbondioxidetracker.repository.entity.Sensor;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SensorGetResponseAdaptorImplTest {

    private ReadingGetResponseAdaptor mockReadingGetResponseAdaptor;

    private SensorGetResponseAdaptorImpl sensorGetResponseAdaptorImplUnderTest;

    @Before
    public void setUp() {

        mockReadingGetResponseAdaptor = Mockito.mock(ReadingGetResponseAdaptor.class) ;
        sensorGetResponseAdaptorImplUnderTest = new SensorGetResponseAdaptorImpl();

        sensorGetResponseAdaptorImplUnderTest.setReadingGetResponseAdaptor(mockReadingGetResponseAdaptor) ;
    }

    @Test(expected = NullPointerException.class)
    public void testAdoptNullSensor() {

        final Sensor sensor = null;
        sensorGetResponseAdaptorImplUnderTest.adopt(sensor);
    }

    @Test
    public void testAdopt() {

        final Sensor sensor = new Sensor("sensorId", "city", "district");
        final List<Reading> list = new ArrayList<>() ;
        sensor.setSensorReadings(list);

        Mockito.when(mockReadingGetResponseAdaptor.adopt(list)).thenReturn(new ArrayList<>()) ;
        final SensorGetResponse result = sensorGetResponseAdaptorImplUnderTest.adopt(sensor);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getCity()).isEqualTo(sensor.getCity()) ;
        Assertions.assertThat(result.getSensorId()).isEqualTo(sensor.getSensorId()) ;
        Assertions.assertThat(result.getDistrict()).isEqualTo(sensor.getDistrict()) ;
        Assertions.assertThat(result.getSensorReadings()).isEmpty();
    }

}
