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
package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.common.IAdaptor;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * This class is a Adaptor class implements from ReadingInputCommandAdaptor to adopt ReadingInputCommand to Reading
 * <p>
 * See {@link ReadingInputCommand}
 * See {@link Reading}
 * See {@link IAdaptor}
 * </p>
 * @version v1
 * @since 1.0
 */
@Component
class ReadingInputCommandAdaptorImpl implements ReadingInputCommandAdaptor {

    /**
     * This methode takes ReadingInputCommand as an argument and give Reading as a return type
     * @param command is an instance of ReadingInputCommand class
     * @return is an converted instance of Reading
     */
    @Override
    public Reading adopt(ReadingInputCommand command) {

        if (IEmptyValidation.isEmpty(command)) return null ;

        final Reading reading = new Reading() ;

        reading.setTime(new Date());
        reading.setReadingValue(command.getCarbonValue()) ;

        return reading;
    }
}
