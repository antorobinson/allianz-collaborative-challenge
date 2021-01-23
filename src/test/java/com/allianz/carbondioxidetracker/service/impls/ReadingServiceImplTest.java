package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReadingServiceImplTest {

    private ReadingRepository mockReadingRepository ;
    private ReadingServiceImpl readingServiceImplUnderTest;

    @Before
    public void setUp() {

        mockReadingRepository = Mockito.mock(ReadingRepository.class) ;
        readingServiceImplUnderTest = new ReadingServiceImpl();

        readingServiceImplUnderTest.setReadingRepository(mockReadingRepository);
    }

    @Test(expected = IValidationException.class)
    public void testAddNullReading() {

        final Reading reading = null;
        readingServiceImplUnderTest.addReading(reading);
    }

    @Test
    public void testAddReading() {

        final Reading reading = new Reading();
        reading.setReadingValue(0.0f);
        reading.setTime(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

        final Reading savedReading = new Reading();
        savedReading.setId(2L);
        savedReading.setReadingValue(reading.getReadingValue());
        savedReading.setTime(reading.getTime());

        Mockito.when(mockReadingRepository.save(reading)).thenReturn(savedReading) ;

        final Reading result = readingServiceImplUnderTest.addReading(reading);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result).isEqualTo(savedReading) ;
    }
}
