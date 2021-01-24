package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.SensorService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CarbonDioxideDataControllerTest {

    private SensorService mockSensorService;

    private ReadingInputRequestAdaptor mockReadingInputRequestAdaptor;

    private CarbonDioxideDataController controllerUnderTest;


    @Before
    public void setUp() {

        mockSensorService = Mockito.mock(SensorService.class) ;
        mockReadingInputRequestAdaptor = Mockito.mock(ReadingInputRequestAdaptor.class) ;

        controllerUnderTest = new CarbonDioxideDataController();

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
        readingRequest.setSensorId("TPK1");

        controllerUnderTest.addReading(readingRequest) ;
    }

    @Test
    public void testAddReading() {

        final ReadingInputRequest readingRequest = new ReadingInputRequest();
        readingRequest.setSensorId("TPK1");
        readingRequest.setCarbonValue(336F);

        final ReadingInputCommand command = Mockito.mock(ReadingInputCommand.class);
        final ReadingInputResult readingResult = Mockito.mock(ReadingInputResult.class);

        Mockito.when(mockReadingInputRequestAdaptor.adopt(readingRequest)).thenReturn(command) ;
        Mockito.when(mockSensorService.addReading(command)).thenReturn(readingResult) ;

        final ResponseEntity<ReadingInputResult> result = controllerUnderTest.addReading(readingRequest);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK) ;
        Assertions.assertThat(result.getBody()).isEqualTo(readingResult) ;
    }
}
