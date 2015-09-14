package com.realdolmen.course.domain;

/**
 * Created by JVDAX31 on 9/09/2015.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.Address;

@Entity
@NamedQueries({
        @NamedQuery(name="FIND_ALL_LAST", query="select p.lastName from Passenger p")
})
public class Passenger implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    public String firstName;
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Temporal(TemporalType.DATE)
    @Column( nullable = false, updatable = false)
    private Date birthDate;

    private Date dateLastUpdated;

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Transient
    private int age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date flightDate;
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;

    @Embedded
    private Address address;
    @ElementCollection
    private List<CreditCard> cards = new ArrayList<CreditCard>();

    protected Passenger(){

    }

    private void calcAge(){
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);
        Calendar today = Calendar.getInstance();
        int agecalc = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
            agecalc--;
        this.age = agecalc;
    }

    public Passenger(List<CreditCard> cards) {
        this.cards = cards;
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date birthDate, Date flightDate, PassengerType passengerType, Address address, List<CreditCard> cards) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.birthDate = birthDate;
        this.flightDate = flightDate;
        this.passengerType = passengerType;
        this.address = address;
        this.cards = cards;
        calcAge();


    }

    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date birthDate, Date flightDate, PassengerType passengerType) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.birthDate = birthDate;
        this.flightDate = flightDate;
        this.passengerType = passengerType;

       calcAge();





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

    public void addCreditCard(CreditCard creditCard){
        cards.add( creditCard);
    }

    @PrePersist
    @PreUpdate
    private void updateLastUpdated(){
        dateLastUpdated = new Date();
    }

    @PostPersist
    @PostUpdate
    @PostLoad
    private void recalcAge(){
        calcAge();
    }


};


