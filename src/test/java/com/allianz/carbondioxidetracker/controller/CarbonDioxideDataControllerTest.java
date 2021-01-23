package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.boundary.adaptors.AddReadingRequestAdaptor;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.CarbonDioxideValueAddResult;
import com.allianz.carbondioxidetracker.service.ReadingService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarbonDioxideDataControllerTest {

    private AddReadingRequestAdaptor addReadingRequestAdaptor;

//    private CarbonDioxideDataService carbonDioxideDataService;

    private ReadingService readingService;

    private CarbonDioxideDataController controllerUnderTest;

    @Before
    public void setUp() {

        addReadingRequestAdaptor = Mockito.mock(AddReadingRequestAdaptor.class) ;
//        carbonDioxideDataService = Mockito.mock(CarbonDioxideDataService.class) ;
        readingService = Mockito.mock(ReadingService.class) ;
        controllerUnderTest = new CarbonDioxideDataController();

        controllerUnderTest.setAddCarbonReadingRequestAdaptor(addReadingRequestAdaptor);
        controllerUnderTest.setReadingService(readingService);
    }

    @Test(expected = IValidationException.class)
    public void testAddReadingWithNullRequest() {

        final AddCarbonReadingRequest readingRequest = null;

        controllerUnderTest.addReading(readingRequest) ;
    }

    @Test(expected = IValidationException.class)
    public void testAddReadingWithInvalidRequest() {

        final AddCarbonReadingRequest readingRequest = new AddCarbonReadingRequest();
        readingRequest.setSensorId(2L);

        controllerUnderTest.addReading(readingRequest) ;
    }

    @Test
    public void testAddReading() {


        final AddCarbonReadingRequest readingRequest = new AddCarbonReadingRequest();
        readingRequest.setSensorId(2L);
        readingRequest.setDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        readingRequest.setCarbonValue(336F);

        final Reading reading = Mockito.mock(Reading.class);
        final CarbonDioxideValueAddResult serviceResponse = Mockito.mock(CarbonDioxideValueAddResult.class);

        Mockito.when(addReadingRequestAdaptor.adopt(readingRequest)).thenReturn(reading) ;
        Mockito.when(readingService.addReading(reading)).thenReturn(reading) ;

        final ResponseEntity<Reading> result = controllerUnderTest.addReading(readingRequest);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK) ;
        Assertions.assertThat(result.getBody()).isEqualTo(reading) ;
    }


}
