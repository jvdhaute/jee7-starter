package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.PassengerEJBRemote;
import com.realdolmen.course.persistence.StorePassengerRemote;
import org.junit.Test;

public class TextMessageConsumerTest extends RemoteJmsTest {
    @Test
    public void produceTextMessage() throws Exception {
      //  producer.send(session.createTextMessage("update#1#600"));

        producer.send(session.createTextMessage("create#1#60000#1"));
      //  PassengerEJBRemote p =  lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");
        //assertEquals((Double) 600.0, p.findTicketById(1L).getPrice());
        }
}
