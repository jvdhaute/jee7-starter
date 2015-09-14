package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.PaymentEJBRemote;
import com.realdolmen.course.persistence.StorePassengerRemote;
import org.junit.Test;

import java.util.concurrent.Future;

/**
 * Created by JVDAX31 on 14/09/2015.
 */
public class RemotePaymentEJBTest extends RemoteIntegrationTest {

    @Test
    public void checkPaymentResult() throws Exception {
        PaymentEJBRemote paymentEJBRemote = lookup("ear-module-1.1/ejb-module-1.1/PaymentEJB!com.realdolmen.course.persistence.PaymentEJBRemote");
        Future<String> status = paymentEJBRemote.payByCreditCard();
        assertEquals("test ok", status.get());

    }

}
