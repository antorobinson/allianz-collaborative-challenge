package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class SensorServiceImplTest {

    private SensorRepository mockSensorRepository;

    private ReadingInputCommandAdaptor mockReadingInputCommandAdaptor;

    private SensorServiceImpl sensorServiceImplUnderTest;

    @Before
    public void setUp() {

        mockReadingInputCommandAdaptor = Mockito.mock(ReadingInputCommandAdaptor.class) ;
        mockSensorRepository = Mockito.mock(SensorRepository.class) ;

        sensorServiceImplUnderTest = new SensorServiceImpl();

        sensorServiceImplUnderTest.setReadingInputCommandAdaptor(mockReadingInputCommandAdaptor);
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
}
