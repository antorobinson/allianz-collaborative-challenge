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
