package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import javax.validation.constraints.*;


public class ISelfValidationTest {


    @Test(expected = IValidationException.class)
    public void testValidateSelfException() {
        new SampleUser().validateSelf();
    }

    @Test(expected = IValidationException.class)
    public void testValidateSelfWithValidFirstNameOnly() {

        final SampleUser user = new SampleUser() ;
        user.firstName = "T T Marshel" ;

        Assertions.assertThat(user.validateSelf()).isTrue();
    }

    @Test(expected = IValidationException.class)
    public void testValidateSelfWithValidFirstNameLastNameOnly() {

        final SampleUser user = new SampleUser() ;
        user.firstName = "T T Marshel" ;
        user.lastName = "" ;

        Assertions.assertThat(user.validateSelf()).isTrue();
    }

    @Test(expected = IValidationException.class)
    public void testValidateSelfWithValidFirstNameLastNameIsStudentOnly() {

        final SampleUser user = new SampleUser() ;
        user.firstName = "T T Marshel" ;
        user.lastName = "" ;
        user.isStudent = true ;

        Assertions.assertThat(user.validateSelf()).isTrue();
    }

    @Test(expected = IValidationException.class)
    public void testValidateSelfWithValidFirstNameLastNameIsStudentAboutMeOnly() {

        final SampleUser user = new SampleUser() ;
        user.firstName = "T T Marshel" ;
        user.lastName = "" ;
        user.isStudent = true ;
        user.aboutMe = "My Name is aboutMe" ;

        Assertions.assertThat(user.validateSelf()).isTrue();
    }

    @Test(expected = IValidationException.class)
    public void testValidateSelfWithValidFirstNameLastNameIsStudentAboutMeAgeOnly() {

        final SampleUser user = new SampleUser() ;
        user.firstName = "T T Marshel" ;
        user.lastName = "" ;
        user.isStudent = true ;
        user.age = 18 ;
        user.aboutMe = "My Name is aboutMe" ;

        Assertions.assertThat(user.validateSelf()).isTrue();
    }


    @Test
    public void testValidateSelf() {

        final SampleUser user = new SampleUser() ;
        user.firstName = "T T Marshel" ;
        user.lastName = "" ;
        user.isStudent = true ;
        user.aboutMe = "My Name is aboutMe" ;
        user.age = 18 ;
        user.email = "test@test.com" ;

        user.validateSelf();
    }

    private static class SampleUser extends ISelfValidation {

        @NotBlank(message = "firstName cannot be empty")
        private String firstName;

        @NotNull(message = "lastName cannot be null")
        private String lastName;

        @AssertTrue(message = "isStudent must be true")
        private boolean isStudent;

        @Size(min = 10, max = 200, message
                = "aboutMe must be between 10 and 200 characters")
        private String aboutMe;

        @Min(value = 18, message = "age should not be less than 18")
        @Max(value = 150, message = "age should not be greater than 150")
        private int age;

        @NotBlank(message = "firstName cannot be empty")
        @Email(message = "email should be valid")
        private String email;
    }
}
