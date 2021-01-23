package com.allianz.carbondioxidetracker.service;

import java.util.Date;

public class CarbonDioxideValueAddResult {

    private Long id ;
    private Date date;

    void setId(Long id) {
        this.id = id;
    }

    void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }


    public static Builder builder() {
        return new Builder() ;
    }

    public static class Builder {

        private final CarbonDioxideValueAddResult entity ;

        private Builder() {
            entity = new CarbonDioxideValueAddResult() ;
        }

        public CarbonDioxideValueAddResult build() {
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

    }
}
