package com.allianz.carbondioxidetracker;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;

public class PojoTestUtils {

    private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create()
            .with(new GetterTester())
            .with(new SetterTester())

            .build();

    private static final Validator TO_STRING_VALIDATOR = ValidatorBuilder.create()
//            .with(new ToStringTester())
            .with(new ToStringTest())

            .build();

    private static final Validator TO_STRING_NEW_VALIDATOR = ValidatorBuilder.create()
            .with(new ToStringTest())

            .build();

    public static void validatePojo(final Class<?>... clazz) {

        for (Class<?> c : clazz) {
            validateAccessors(c);
            validateToString(c);
        }
    }


    public static void validateAccessorsClasses(final Class<?>... clazz) {

        for (Class<?> c : clazz) {
            validateAccessors(c);
        }
    }

    public static void validateToStringClasses(final Class<?>... clazz) {

        for (Class<?> c : clazz) {
            validateToString(c);
        }
    }


    public static void validateAccessors(final Class<?> clazz) {
        ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }

    public static void testToString(final Class<?> clazz) {
        TO_STRING_NEW_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }

    public static void validateToString(final Class<?> clazz) {
        TO_STRING_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }

    public static class ToStringTest implements Tester {

        public void run(final PojoClass pojoClass) {

            final Object classInstance = ValidationHelper.getBasicInstance(pojoClass);

            String s = null;
            try {
                s = (String) classInstance.getClass().getMethod("toString").invoke(classInstance);
                Affirm.affirmNotNull(classInstance.getClass().getSimpleName() + "." + "toString()", s);
            } catch (Exception e) {
                Affirm.affirmNull(classInstance.getClass().getSimpleName() + "." + "toString()", s);
            }

        }
    }

}
