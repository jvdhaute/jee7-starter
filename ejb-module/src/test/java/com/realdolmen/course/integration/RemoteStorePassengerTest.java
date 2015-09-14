package com.realdolmen.course.integration;

import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.CreditCardType;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.persistence.PassengerEJBRemote;
import com.realdolmen.course.persistence.StorePassenger;
import com.realdolmen.course.persistence.StorePassengerRemote;
import org.junit.Test;

import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JVDAX31 on 14/09/2015.
 */
public class RemoteStorePassengerTest extends  RemoteIntegrationTest {


    /*

    @Test
    public void storeNewPassengerRemotely() throws Exception {
        StorePassengerRemote passengerRemote  = lookup("ear-module-1.1/ejb-module-1.1/StorePassenger!com.realdolmen.course.persistence.StorePassengerRemote");



        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = dateformat.parse("19/03/1990");
        Date now = new Date();
        passengerRemote.createPassenger("123", "Jeroen", "Vdh", 500, birthdate, PassengerType.OCCASIONAL);


        passengerRemote.addAddress("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);

        passengerRemote.addCreditCard(card);

        passengerRemote.checkOut();


    }


    */


    @Test
    public void storeNewTicketRemotely() throws Exception {
        StorePassengerRemote passengerRemote  = lookup("ear-module-1.1/ejb-module-1.1/StorePassenger!com.realdolmen.course.persistence.StorePassengerRemote");



        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = dateformat.parse("19/03/1990");
        Date now = new Date();
        passengerRemote.createPassenger("123", "Jeroen", "Vdh", 500, birthdate, PassengerType.OCCASIONAL);


        passengerRemote.addAddress("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);

        passengerRemote.addCreditCard(card);
        passengerRemote.addCreditCard(card);
        passengerRemote.createTicket(50.0, Status.PENDING);

        passengerRemote.checkOutTicket();




    }


}
