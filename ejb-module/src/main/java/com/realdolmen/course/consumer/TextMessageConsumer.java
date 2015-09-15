package com.realdolmen.course.consumer;


import com.realdolmen.course.domain.Status;
import com.realdolmen.course.persistence.PassengerEJB;
import com.realdolmen.course.persistence.StorePassenger;
import com.realdolmen.course.persistence.StorePassengerRemote;
import com.realdolmen.course.persistence.TicketEJB;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue"),
})
public class TextMessageConsumer implements MessageListener {

    @EJB
    //private StorePassenger storePassenger;
    private TicketEJB ticketEJB;

    @Override
    public void onMessage(Message message) {
        try {

            TextMessage textMessage = (TextMessage) message;
            String messagetoprocess = textMessage.getText();

            String[] parts = messagetoprocess.split("#");
            String ticketid = parts[1];;
            String price = parts[2];
            if(parts[0].equals("update")){
               ticketEJB.updateTicket(ticketid, price);
            } else if(parts[0].equals("create")){
                String passengerID = parts[3];

                ticketEJB.createTicket(Double.parseDouble(price), Status.PENDING, (Long.parseLong(passengerID, 10)));
              //  storePassenger.updateTicket(ticketid, price);
            }


            /*
            System.out.println("**********************");
            System.out.println(textMessage.getText());
            System.out.println("**********************");

            */
        } catch (JMSException e) {
            throw new RuntimeException("Deal with this", e);
        }
    }
}
