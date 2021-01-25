/*
 * This is only for an interview purpose in Allianz Technology,
 * This code is developed by 4 interview candidates.
 * This is written in free version Java 8 .
 * This is written in spring boot version 2.4.2 .
 * This is an open source .
 * This code meets most of the SOLID principles.
 * No Copyrights or no rights reserved .
 * Any one can use this code for their organization, personal or learning purposes.
 * ANY ONE CAN ALTER THIS CODE OR THIS FILE.
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 */
package com.allianz.carbondioxidetracker.common;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ISelfValidation {

    private static final Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public final boolean validateSelf() {

        final Set<ConstraintViolation<ISelfValidation>> violations = validator.validate(this);
        if (violations.isEmpty()) return true;

        final StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<ISelfValidation> violation : violations) {

            if (stringBuilder.length() > 0) {
                stringBuilder.append(" / ");
            }

            stringBuilder.append(violation.getMessage()) ;
        }

        throw IValidationException.of(ErrorCode.BAD_REQUEST, stringBuilder.toString());
    }

}
