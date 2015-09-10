package com.realdolmen.course.domain;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by JVDAX31 on 10/09/2015.
 */
@Entity
public class InternationalFlight extends Flight {

    private Boolean blacklisted;
    private String regulations;

    public InternationalFlight(Date departureTime, Date arrivalTime, String number, Boolean blacklisted, String regulations) {
        super(departureTime, arrivalTime, number);
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    protected InternationalFlight(){

    }


    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
