package com.allianz.carbondioxidetracker.boundary;


import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.controller.ReadingInputRequest;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import org.springframework.stereotype.Component;

@Component
class ReadingInputRequestAdaptorImpl implements ReadingInputRequestAdaptor {

    @Override
    public ReadingInputCommand adopt(ReadingInputRequest request) {

        if (IEmptyValidation.isEmpty(request)) return null ;

        final ReadingInputCommand command = new ReadingInputCommand() ;

        command.setSensorId(request.getSensorId());
        command.setCarbonValue(request.getCarbonValue());

        return command;
    }
}
