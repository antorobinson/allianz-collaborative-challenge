package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import org.springframework.stereotype.Component;

@Component
class ReadingInputCommandAdaptorImpl implements ReadingInputCommandAdaptor {

    @Override
    public Reading adopt(ReadingInputCommand command) {

        if (IEmptyValidation.isEmpty(command)) return null ;

        final Reading reading = new Reading() ;

        reading.setTime(command.getDate());
        reading.setReadingValue(command.getCarbonValue()) ;

        return reading;
    }
}
