package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ReadingServiceImplTest {

    private ReadingRepository mockReadingRepository ;
    private ReadingInputCommandAdaptor mockReadingInputCommandAdaptor ;
    private ReadingServiceImpl readingServiceImplUnderTest;

    @Before
    public void setUp() {

        mockReadingRepository = Mockito.mock(ReadingRepository.class) ;
        mockReadingInputCommandAdaptor = Mockito.mock(ReadingInputCommandAdaptor.class) ;

        readingServiceImplUnderTest = new ReadingServiceImpl();

        readingServiceImplUnderTest.setReadingRepository(mockReadingRepository);
        readingServiceImplUnderTest.setReadingInputCommandAdaptor(mockReadingInputCommandAdaptor);
    }

    @Test(expected = IValidationException.class)
    public void testAddNullReading() {

        final ReadingInputCommand command = null;
        readingServiceImplUnderTest.addReading(command);
    }

    @Test
    public void testAddReading() {

        final ReadingInputCommand command = new ReadingInputCommand();
        command.setCarbonValue(0.0f);

        final Reading reading = new Reading();
        reading.setId(2L);
        reading.setReadingValue(command.getCarbonValue());

        Mockito.when(mockReadingInputCommandAdaptor.adopt(command)).thenReturn(reading) ;
        Mockito.when(mockReadingRepository.save(reading)).thenReturn(reading) ;

        final ReadingInputResult result = readingServiceImplUnderTest.addReading(command);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getReadingId()).isEqualTo(reading.getId()) ;
        Assertions.assertThat(result.getDate()).isEqualTo(reading.getTime()) ;
        Assertions.assertThat(result.getReadingValue()).isEqualTo(reading.getReadingValue()) ;
    }
}
