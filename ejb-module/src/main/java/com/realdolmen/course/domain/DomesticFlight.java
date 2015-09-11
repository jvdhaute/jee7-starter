package com.realdolmen.course.domain;



import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by JVDAX31 on 10/09/2015.
 */

@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;
    private String reference;

    public DomesticFlight(Date departureTime, Date arrivalTime, String number, String airlineCompany, String reference) {
        super(departureTime, arrivalTime, number);
        this.airlineCompany = airlineCompany;
        this.reference = reference;
    }

    protected DomesticFlight(){

    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
