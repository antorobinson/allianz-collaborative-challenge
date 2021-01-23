package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class NumberParserTest {

    @Test
    public void testParseInt() {

        Assertions.assertThat(NumberParser.parseInt("700")).isEqualTo(700) ;
        Assertions.assertThat(NumberParser.parseInt("s")).isZero() ;
    }


    @Test
    public void testParseDouble() {

        Assertions.assertThat(NumberParser.parseDouble("700.0")).isEqualTo(700.0) ;
        Assertions.assertThat(NumberParser.parseDouble("s")).isZero() ;
    }

    @Test
    public void testIsNumber() {

        Assertions.assertThat(NumberParser.isNumber("s")).isFalse() ;
        Assertions.assertThat(NumberParser.isNumber("1")).isTrue() ;
    }

    @Test
    public void testToString() {
        Assertions.assertThat(NumberParser.toString(null)).isEmpty();
        Assertions.assertThat(NumberParser.toString(0)).isEqualTo("0");
        Assertions.assertThat(NumberParser.toString(700)).isEqualTo("700") ;
        Assertions.assertThat(NumberParser.toString(700.0)).isEqualTo("700.0") ;
        Assertions.assertThat(NumberParser.toString(700.10)).isEqualTo("700.1") ;
        Assertions.assertThat(NumberParser.toString(700.01)).isEqualTo("700.01") ;
    }
}
