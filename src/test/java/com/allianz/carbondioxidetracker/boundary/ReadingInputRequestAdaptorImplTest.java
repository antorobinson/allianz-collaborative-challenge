package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.controller.ReadingInputRequest;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ReadingInputRequestAdaptorImplTest {

    private ReadingInputRequestAdaptorImpl readingInputRequestAdaptorImplUnderTest;

    @Before
    public void setUp() {
        readingInputRequestAdaptorImplUnderTest = new ReadingInputRequestAdaptorImpl();
    }

    @Test
    public void testAdopt() {

        final ReadingInputRequest request = new ReadingInputRequest();
        request.setSensorId("TPK1");
        request.setCarbonValue(340F);

        final ReadingInputCommand result = readingInputRequestAdaptorImplUnderTest.adopt(request);
        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getCarbonValue()).isEqualTo(request.getCarbonValue()) ;
    }

    @Test
    public void testAdoptNullRequest() {

        final ReadingInputRequest request = null;
        final ReadingInputCommand result = readingInputRequestAdaptorImplUnderTest.adopt(request);

        Assertions.assertThat(result).isNull();
    }
}
