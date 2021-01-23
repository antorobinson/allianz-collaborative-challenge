package com.allianz.carbondioxidetracker.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="READING")
public class Reading {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="READING")
    private Float readingValue;

    @Column(name="TIME")
    private Date time;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="SENSOR_ID")
    private Sensor sensor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(Float readingValue) {
        this.readingValue = readingValue;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
