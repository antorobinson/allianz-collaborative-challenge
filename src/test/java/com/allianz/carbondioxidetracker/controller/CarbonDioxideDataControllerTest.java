package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.IResponse;
import com.allianz.carbondioxidetracker.common.IResponseBuilder.ResponseBody;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.SensorService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        final ResponseEntity<ResponseBody<ReadingInputResult>> result = controllerUnderTest
                .addReading(readingRequest);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK) ;
        Assertions.assertThat(result.getBody().getData()).isEqualTo(readingResult) ;
    }

    @Test(expected = ParseException.class)
    public void testGetReadingPerCityThrowsParseException() throws Exception {

        final ReadingGetRequest readingGetRequest = new ReadingGetRequest();

        Mockito.when(mockSensorService.search(readingGetRequest)).thenThrow(ParseException.class) ;
        controllerUnderTest.getReadingPerCity(readingGetRequest);
    }

    @Test
    public void testGetReadingPerCity() throws Exception {

        final ReadingGetRequest readingGetRequest = new ReadingGetRequest();
        final List<SensorGetResponse> list = new ArrayList<>() ;

        Mockito.when(mockSensorService.search(readingGetRequest)).thenReturn(list) ;
        controllerUnderTest.getReadingPerCity(readingGetRequest);

        final IResponse<ResponseBody<List<SensorGetResponse>>> result = controllerUnderTest
                .getReadingPerCity(readingGetRequest);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK) ;
        Assertions.assertThat(result.getBody().getData()).isEqualTo(list) ;
    }

}
