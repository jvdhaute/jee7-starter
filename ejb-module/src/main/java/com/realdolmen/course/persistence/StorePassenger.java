package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 14/09/2015.
 */

@Stateful
@LocalBean
public class StorePassenger implements StorePassengerRemote {


    @EJB
    private PassengerEJB passengerEJB;

    private Passenger passenger;
    private Ticket ticket;

    public StorePassenger() {
    }

    public void createPassenger(String ssn, String firstname, String lastName, Integer flyedmiles, Date birthdate, PassengerType passengerType) {


        Date now = new Date();
        List<CreditCard> lst = new ArrayList<CreditCard>();
        passenger= new Passenger(ssn, firstname, lastName, flyedmiles, birthdate,now, passengerType);


    }

    public void addAddress(String street1, String country, String street2, String city, String zipCode){
        Address address = new Address(street1, country, street2, city, zipCode);
        passenger.setAddress(address);

    }

    public void addCreditCard(CreditCard creditCard){
        passenger.addCreditCard(creditCard);
    }

    public void createTicket(Double price, Status status){
       ticket = new Ticket(price, status, passenger);
    }


    public void checkOut(){
        passengerEJB.createPassenger(this.passenger);

    }

    public void checkOutTicket(){
        passengerEJB.createPassenger(this.passenger);
        passengerEJB.createTicket(this.ticket);
    }


    public void updateTicket(String id, String price){
        Ticket t = passengerEJB.findTicketById(Long.parseLong(id, 10));
        t.setPrice(Double.parseDouble(price));
        passengerEJB.updateTicket(t);

    }
    /*
     SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateformat3.parse("17/07/1989");
        Date now = new Date();
        Address ad = new Address("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);
        CreditCard card2 = new CreditCard("500000", "19/03/2020", 1000, CreditCardType.MASTER);
        List<CreditCard> lst = new ArrayList<CreditCard>();
        lst.add(card);
        lst.add(card2);
    */

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
