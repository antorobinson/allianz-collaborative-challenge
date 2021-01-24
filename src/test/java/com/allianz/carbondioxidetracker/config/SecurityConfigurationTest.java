package com.allianz.carbondioxidetracker.config;

import org.junit.Before;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfigurationTest {

    private SecurityConfiguration securityConfigurationUnderTest;

    @Before
    public void setUp() {
        securityConfigurationUnderTest = new SecurityConfigurationImpl();
    }

    private static class SecurityConfigurationImpl extends SecurityConfiguration {

        public void doTest(HttpSecurity http) throws Exception {
            configure(http);
        }
     }
}
