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
package com.allianz.carbondioxidetracker.service;

import java.util.Date;

public class ReadingInputResult {

    private Long readingId;
    private String sensorId;
    private Date date;
    private Float readingValue;

    void setReadingId(Long readingId) {
        this.readingId = readingId;
    }

    void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    void setDate(Date date) {
        this.date = date;
    }

    void setReadingValue(Float readingValue) {
        this.readingValue = readingValue;
    }

    public Long getReadingId() {
        return readingId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Date getDate() {
        return date;
    }

    public Float getReadingValue() {
        return readingValue;
    }

    public static Builder builder() {
        return new Builder() ;
    }

    public static class Builder {

        private final ReadingInputResult entity ;

        private Builder() {
            entity = new ReadingInputResult() ;
        }

        public ReadingInputResult build() {
            return entity ;
        }

        public Builder setReadingId(Long id) {

            entity.setReadingId(id);
            return this ;
        }

        public Builder setSensorId(String sensorId) {

            entity.setSensorId(sensorId);
            return this;
        }

        public Builder setDate(Date date) {

            entity.setDate(date);
            return this ;
        }

        public Builder setReadingValue(Float readingValue) {

            entity.setReadingValue(readingValue) ;
            return this ;
        }

    }
}
