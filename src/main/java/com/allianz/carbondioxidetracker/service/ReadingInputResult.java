package com.allianz.carbondioxidetracker.service;

import java.util.Date;

public class ReadingInputResult {

    private Long id ;
    private Date date;
    private Float readingValue;

    void setId(Long id) {
        this.id = id;
    }

    void setDate(Date date) {
        this.date = date;
    }

    public void setReadingValue(Float readingValue) {
        this.readingValue = readingValue;
    }

    public Long getId() {
        return id;
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

        public Builder setId(Long id) {

            entity.setId(id);
            return this ;
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
