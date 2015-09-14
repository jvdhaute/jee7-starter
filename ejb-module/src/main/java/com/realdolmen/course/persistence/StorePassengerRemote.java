package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.domain.Status;

import javax.ejb.Remote;
import java.util.Date;

/**
 * Created by JVDAX31 on 14/09/2015.
 */
@Remote
public interface StorePassengerRemote {


    public void createPassenger(String ssn, String firstname, String lastName, Integer flyedmiles, Date birthdate, PassengerType passengerType);

    public void addAddress(String street1, String country, String street2, String city, String zipCode);
    public void addCreditCard(CreditCard creditCard);
    public void createTicket(Double price, Status status);
    public void checkOut();
    public void checkOutTicket();

}

