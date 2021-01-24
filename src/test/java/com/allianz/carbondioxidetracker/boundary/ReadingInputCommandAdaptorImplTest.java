package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ReadingInputCommandAdaptorImplTest {

    private ReadingInputCommandAdaptorImpl readingInputCommandAdaptorUnderTest;

    @Before
    public void setUp() {
        readingInputCommandAdaptorUnderTest = new ReadingInputCommandAdaptorImpl();
    }

    @Test
    public void testAdopt() {

        final ReadingInputCommand command = new ReadingInputCommand();
        command.setSensorId("TPK1");
        command.setCarbonValue(340F);

        final Reading result = readingInputCommandAdaptorUnderTest.adopt(command);
        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getTime()).isNotNull() ;
        Assertions.assertThat(result.getReadingValue()).isEqualTo(command.getCarbonValue()) ;
    }


    @Test
    public void testAdoptNullRequest() {

        final ReadingInputCommand request = null;

        final Reading result = readingInputCommandAdaptorUnderTest.adopt(request);
        Assertions.assertThat(result).isNull();
    }
}
