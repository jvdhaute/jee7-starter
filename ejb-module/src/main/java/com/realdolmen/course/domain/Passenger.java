package com.realdolmen.course.domain;

/**
 * Created by JVDAX31 on 9/09/2015.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import com.realdolmen.course.domain.PassengerType;
@Entity
public class Passenger implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Temporal(TemporalType.DATE)
    @Column( nullable = false, updatable = false)
    private Date birthDate;
    @Transient
    private int age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date flightDate;
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;

    protected Passenger(){

    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date birthDate, Date flightDate, PassengerType passengerType) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.birthDate = birthDate;
        this.flightDate = flightDate;
        this.passengerType = passengerType;

        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);
        Calendar today = Calendar.getInstance();
        int agecalc = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
            agecalc--;
        this.age = agecalc;





    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
};


