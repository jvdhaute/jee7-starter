package com.realdolmen.course.persistence;

import javax.ejb.Remote;
import java.util.concurrent.Future;

/**
 * Created by JVDAX31 on 14/09/2015.
 */
@Remote
public interface PaymentEJBRemote {
    public Future<String> payByCreditCard();
}
