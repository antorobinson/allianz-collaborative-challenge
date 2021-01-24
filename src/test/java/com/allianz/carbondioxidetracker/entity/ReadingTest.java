package com.allianz.carbondioxidetracker.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

public class ReadingTest {

    @Test
    public void testConstructor() {

        final Date date = new Date() ;
        final Reading entity = new Reading(12F , date) ;

        Assertions.assertThat(entity.getReadingValue()).isEqualTo(12F) ;
        Assertions.assertThat(entity.getTime()).isEqualTo(date) ;
    }

    @Test
    public void testGettersAndSetters() {

        final Reading entity = new Reading() ;

        final Date date = new Date() ;

        entity.setId(2L);
        entity.setTime(date);
        entity.setReadingValue(300F);

        Assertions.assertThat(entity.getId()).isEqualTo(2L) ;
        Assertions.assertThat(entity.getTime()).isEqualTo(date) ;
        Assertions.assertThat(entity.getReadingValue()).isEqualTo(300F) ;
    }
}
