package com.allianz.carbondioxidetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public Reading(){
    	
    }
    
    /**
	 * @param readingValue
	 * @param time
	 */
	public Reading(Float readingValue, Date time) {
		super();
		this.readingValue = readingValue;
		this.time = time;
	}

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
