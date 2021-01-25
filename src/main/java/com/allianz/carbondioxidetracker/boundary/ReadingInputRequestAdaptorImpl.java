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
import com.allianz.carbondioxidetracker.controller.ReadingInputRequest;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import org.springframework.stereotype.Component;
/**
 * This class is a Adaptor class implements from ReadingInputRequestAdaptor to adopt ReadingInputRequest to
 * ReadingInputCommand
 * <p>
 * See {@link ReadingInputRequest}
 * See {@link ReadingInputCommand}
 * See {@link IAdaptor}
 * </p>
 * @version v1
 * @since 1.0
 */
@Component
class ReadingInputRequestAdaptorImpl implements ReadingInputRequestAdaptor {

    /**
     * This methode takes ReadingInputRequest as an argument and give ReadingInputCommand as a return type
     * @param request is an instance of ReadingInputRequest class
     * @return is an converted instance of ReadingInputCommand
     */
    @Override
    public ReadingInputCommand adopt(ReadingInputRequest request) {

        if (IEmptyValidation.isEmpty(request)) return null ;

        final ReadingInputCommand command = new ReadingInputCommand() ;

        command.setSensorId(request.getSensorId());
        command.setCarbonValue(request.getCarbonValue());

        return command;
    }
}
