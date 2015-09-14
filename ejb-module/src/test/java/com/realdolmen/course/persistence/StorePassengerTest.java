package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 14/09/2015.
 */
public class StorePassengerTest extends DataSetPersistenceTest {

    private PassengerEJB passengerEJB;

    @Before
    public void initializeEJB() {
        passengerEJB = new PassengerEJB();
        passengerEJB.entityManager = entityManager();
    }

/*

    @Test
    public void testNewPassenger() throws Exception {

        StorePassenger storePassenger = new StorePassenger();

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = dateformat.parse("19/03/1990");
        Date now = new Date();
        storePassenger.createPassenger("123", "Jeroen", "Vdh", 500, birthdate, PassengerType.OCCASIONAL);


        storePassenger.addAddress("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);

        storePassenger.addCreditCard(card);
        storePassenger.createTicket(50.0, Status.PENDING);

        storePassenger.checkOut;



    }

    */



}
