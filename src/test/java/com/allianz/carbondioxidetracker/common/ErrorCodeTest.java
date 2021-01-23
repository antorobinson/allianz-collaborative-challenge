package com.allianz.carbondioxidetracker.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorCodeTest {

    @Test
    public void testGetValue() {
        assertEquals("NULL_REQUEST", ErrorCode.NULL_REQUEST.getValue());
        assertEquals("BAD_REQUEST", ErrorCode.BAD_REQUEST.getValue());
        assertEquals("NULL_COMMAND", ErrorCode.NULL_COMMAND.getValue());
    }
}
