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
