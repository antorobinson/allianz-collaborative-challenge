package com.allianz.carbondioxidetracker.common;

import java.util.ArrayList;
import java.util.List;

public interface IAdaptor<I, T> {

    T adopt(I object);

    default List<T> adopt(List<I> objects) {

        final List<T> list = new ArrayList<>();

        if (objects == null) return list;

        for (I object : objects) {

            final T t = adopt(object) ;
            if (t != null) {
                list.add(t) ;
            }
        }

        return list ;
    }
}
