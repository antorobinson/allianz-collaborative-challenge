package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.ReadingService;
import com.allianz.carbondioxidetracker.service.SensorService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarbonDioxideDataControllerTest {

    private ReadingService mockReadingService;

    private SensorService mockSensorService;

    private ReadingInputRequestAdaptor mockReadingInputRequestAdaptor;

    private CarbonDioxideDataController controllerUnderTest;


    @Before
    public void setUp() {

        mockReadingService = Mockito.mock(ReadingService.class) ;
        mockSensorService = Mockito.mock(SensorService.class) ;
        mockReadingInputRequestAdaptor = Mockito.mock(ReadingInputRequestAdaptor.class) ;

        controllerUnderTest = new CarbonDioxideDataController();

        controllerUnderTest.setReadingService(mockReadingService);
        controllerUnderTest.setSensorService(mockSensorService);
        controllerUnderTest.setReadingInputRequestAdaptor(mockReadingInputRequestAdaptor);
    }

    @Test(expected = IValidationException.class)
    public void testAddReadingWithNullRequest() {

        final ReadingInputRequest readingRequest = null;

        controllerUnderTest.addReading(readingRequest) ;
    }

    @Test(expected = IValidationException.class)
    public void testAddReadingWithInvalidRequest() {

        final ReadingInputRequest readingRequest = new ReadingInputRequest();
        readingRequest.setSensorId(2L);

        controllerUnderTest.addReading(readingRequest) ;
    }

    @Test
    public void testAddReading() {

        final ReadingInputRequest readingRequest = new ReadingInputRequest();
        readingRequest.setSensorId(2L);
        readingRequest.setDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        readingRequest.setCarbonValue(336F);

        final ReadingInputCommand command = Mockito.mock(ReadingInputCommand.class);
        final ReadingInputResult readingResult = Mockito.mock(ReadingInputResult.class);

        Mockito.when(mockReadingInputRequestAdaptor.adopt(readingRequest)).thenReturn(command) ;
        Mockito.when(mockReadingService.addReading(command)).thenReturn(readingResult) ;

        final ResponseEntity<ReadingInputResult> result = controllerUnderTest.addReading(readingRequest);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK) ;
        Assertions.assertThat(result.getBody()).isEqualTo(readingResult) ;
    }
}
