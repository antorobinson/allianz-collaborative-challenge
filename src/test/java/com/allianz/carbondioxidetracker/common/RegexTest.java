package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RegexTest {

    @Test
    public void testGetValue() {
        Assertions.assertThat(Regex.ALPHA_NUMERIC).isNotNull() ;
    }
}
