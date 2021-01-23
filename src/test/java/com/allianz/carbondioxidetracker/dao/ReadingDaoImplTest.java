package com.allianz.carbondioxidetracker.dao;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class ReadingDaoImplTest {

    private ReadingRepository mockReadingRepository ;

    private ReadingDaoImpl readingDaoUnderTest;

    @Before
    public void setUp() {

        mockReadingRepository = Mockito.mock(ReadingRepository.class) ;
        readingDaoUnderTest = new ReadingDaoImpl();

        readingDaoUnderTest.setReadingRepository(mockReadingRepository);

    }

    @Test
    public void testSave() {

        final Reading entity = new Reading();

        final Date date = new Date() ;
        entity.setId(12L);
        entity.setTime(date);
        entity.setReadingValue(200.8F);

        Mockito.when(mockReadingRepository.save(entity)).thenReturn(entity) ;

        final Reading result = readingDaoUnderTest.save(entity);

        Assertions.assertThat(result).isNotNull() ;
    }
}
