package com.realdolmen.course.persistence;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * Created by JVDAX31 on 14/09/2015.
 */
@Stateless
@Asynchronous
public class PaymentEJB implements PaymentEJBRemote {

    @Override
    public Future<String> payByCreditCard() {
        return new AsyncResult<String>("test ok");
    }
}
