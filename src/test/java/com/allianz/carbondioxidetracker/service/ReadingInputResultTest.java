package com.allianz.carbondioxidetracker.service;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReadingInputResultTest {

    private ReadingInputResult readingInputResultUnderTest;

    @Before
    public void setUp() {
        readingInputResultUnderTest = new ReadingInputResult();
    }

    @Test
    public void testSetId() {
        // Setup

        // Run the test
        readingInputResultUnderTest.setReadingId(0L);

        // Verify the results
    }

    @Test
    public void testSetDate() {
        // Setup

        // Run the test
        readingInputResultUnderTest.setDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

        // Verify the results
    }

    @Test
    public void testBuilder() {
        // Setup

        // Run the test
        final ReadingInputResult.Builder result = ReadingInputResult.builder();

        // Verify the results
    }
}
