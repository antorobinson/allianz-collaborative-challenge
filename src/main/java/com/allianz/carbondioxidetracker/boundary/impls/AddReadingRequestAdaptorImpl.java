package com.allianz.carbondioxidetracker.boundary.impls;


import com.allianz.carbondioxidetracker.boundary.adaptors.AddReadingRequestAdaptor;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.controller.CarbonReadingInputRequest;
import com.allianz.carbondioxidetracker.entity.Reading;
import org.springframework.stereotype.Component;

@Component
class AddReadingRequestAdaptorImpl implements AddReadingRequestAdaptor {

//    @Override
//    public CarbonDioxideValueAddCommand adopt(AddCarbonReadingRequest request) {
//
//        if (IEmptyValidation.isEmpty(request)) return null ;
//
//        final CarbonDioxideValueAddCommand command = new CarbonDioxideValueAddCommand() ;
//
//        command.setSensorId(request.getSensorId());
//        command.setDate(command.getDate());
//        command.setCarbonValue(request.getCarbonValue());
//
//        return command;
//    }

    @Override
    public Reading adopt(CarbonReadingInputRequest request) {

        if (IEmptyValidation.isEmpty(request)) return null ;

        final Reading reading = new Reading() ;

        reading.setId(request.getSensorId());
        reading.setTime(request.getDate());
        reading.setReadingValue(request.getCarbonValue());

        return reading;
    }
}
