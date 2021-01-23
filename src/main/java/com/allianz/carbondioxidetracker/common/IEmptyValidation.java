package com.allianz.carbondioxidetracker.common;


import org.springframework.util.ObjectUtils;


public final class IEmptyValidation {

    private IEmptyValidation() {
    }

    public static boolean isEmpty(Object obj) {

        if (obj == null) {
            return true;
        }

        if (obj instanceof String) {
            String s = ((String) obj);
            obj = s.trim() ;
        }

        return ObjectUtils.isEmpty(obj)  ;
    }

}
