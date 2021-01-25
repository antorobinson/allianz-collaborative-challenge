package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.repository.entity.Reading;
import com.allianz.carbondioxidetracker.repository.entity.Sensor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import com.allianz.carbondioxidetracker.service.adaptors.SensorGetResponseAdaptor;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SensorServiceImplTest {

    private SensorRepository mockSensorRepository;

    private ReadingInputCommandAdaptor mockReadingInputCommandAdaptor;

    private SensorGetResponseAdaptor mockSensorGetResponseAdaptor;

    private SensorServiceImpl sensorServiceImplUnderTest;

    @Before
    public void setUp() {

        mockReadingInputCommandAdaptor = Mockito.mock(ReadingInputCommandAdaptor.class) ;
        mockSensorGetResponseAdaptor = Mockito.mock(SensorGetResponseAdaptor.class) ;
        mockSensorRepository = Mockito.mock(SensorRepository.class) ;

        sensorServiceImplUnderTest = new SensorServiceImpl();

        sensorServiceImplUnderTest.setReadingInputCommandAdaptor(mockReadingInputCommandAdaptor);
        sensorServiceImplUnderTest.setSensorGetResponseAdaptor(mockSensorGetResponseAdaptor);
        sensorServiceImplUnderTest.setSensorRepository(mockSensorRepository);
    }

    @Test(expected = IValidationException.class)
    public void testAddReadingNullCommand() {

        final ReadingInputCommand command = null;

        Mockito.when(mockReadingInputCommandAdaptor.adopt(command)).thenReturn(null) ;
        sensorServiceImplUnderTest.addReading(command);
    }

    @Test(expected = IValidationException.class)
    public void testAddReadingNullSensor() {

        final ReadingInputCommand command = new ReadingInputCommand();
        command.setSensorId("TPK1");
        command.setCarbonValue(15F);

        final Reading reading = new Reading() ;
        final Date date = new Date() ;
        reading.setId(12L);
        reading.setTime(date);
        reading.setReadingValue(command.getCarbonValue());

        final Sensor sensor = null ;

        Optional<Sensor> sensorWrapper = Optional.ofNullable(sensor) ;

        Mockito.when(mockReadingInputCommandAdaptor.adopt(command)).thenReturn(reading) ;
        Mockito.when(mockSensorRepository.findById(command.getSensorId())).thenReturn(sensorWrapper) ;
        sensorServiceImplUnderTest.addReading(command);
    }

    @Test
    public void testAddReading() {

        final ReadingInputCommand command = new ReadingInputCommand();
        command.setSensorId("TPK1");
        command.setCarbonValue(15F);

        final Reading reading = new Reading() ;
        final Date date = new Date() ;
        reading.setId(12L);
        reading.setTime(date);
        reading.setReadingValue(command.getCarbonValue());

        final Sensor sensor = new Sensor() ;
        sensor.setSensorReadings(new ArrayList<>());

        Optional<Sensor> sensorWrapper = Optional.of(sensor) ;

        Mockito.when(mockReadingInputCommandAdaptor.adopt(command)).thenReturn(reading) ;
        Mockito.when(mockSensorRepository.findById(command.getSensorId())).thenReturn(sensorWrapper) ;
        Mockito.when(mockSensorRepository.save(sensor)).thenReturn(sensor) ;
        final ReadingInputResult result = sensorServiceImplUnderTest.addReading(command);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getReadingId()).isEqualTo(reading.getId()) ;
        Assertions.assertThat(result.getSensorId()).isEqualTo(command.getSensorId()) ;
        Assertions.assertThat(result.getDate()).isEqualTo(date) ;
        Assertions.assertThat(result.getReadingValue()).isEqualTo(15F) ;
    }

    @Test
    public void testRetrieveSensors() {

        final List<Sensor> list = new ArrayList<>() ;
        list.add(new Sensor()) ;
        list.add(new Sensor()) ;

        Mockito.when(mockSensorRepository.findAll()).thenReturn(list) ;
        final List<Sensor> result = sensorServiceImplUnderTest.retrieveSensors();
        Assertions.assertThat(result.size()).isEqualTo(2) ;
    }

    @Test
    public void testGetSensorById() {

        final String sensorId = "TPK1" ;
        final Sensor sensor = new Sensor() ;
        final Optional<Sensor> sensorWrapper = Optional.of(sensor) ;

        Mockito.when(mockSensorRepository.findById(sensorId)).thenReturn(sensorWrapper) ;
        final Sensor result = sensorServiceImplUnderTest.getSensorById(sensorId);

        Assertions.assertThat(result).isEqualTo(sensor) ;
    }

    @Test
    public void testSaveSensor() {

        final Sensor sensor = new Sensor("sensorId", "city", "district");

        Mockito.when(mockSensorRepository.save(sensor)).thenReturn(sensor) ;
        sensorServiceImplUnderTest.saveSensor(sensor);

        Mockito.verify(mockSensorRepository).save(sensor);
    }

    @Test
    public void testGetSensorReadingsByCity() {

        final String city = "city" ;
        final List<Sensor> list = new ArrayList<>() ;
        final Sensor sensor = new Sensor("sensorId", "city", "district") ;
        list.add(sensor) ;

        Mockito.when(mockSensorRepository.findSensorByCity(city)).thenReturn(list) ;
        final List<Sensor> result = sensorServiceImplUnderTest.getSensorReadingsByCity(city);

        Assertions.assertThat(result.size()).isEqualTo(1) ;
    }

    @Test
    public void testGetSensorReadingsByDistrict() {

        final String district = "district" ;
        final List<Sensor> list = new ArrayList<>() ;
        final Sensor sensor = new Sensor("sensorId", "city", "district") ;
        list.add(sensor) ;

        Mockito.when(mockSensorRepository.findSensorByDistrict(district)).thenReturn(list) ;
        final List<Sensor> result = sensorServiceImplUnderTest.getSensorReadingsByDistrict(district);

        Assertions.assertThat(result.size()).isEqualTo(1) ;
    }
}
