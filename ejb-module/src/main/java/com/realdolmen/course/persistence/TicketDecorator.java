package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Ticket;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by JVDAX31 on 16/09/2015.
 */

@Decorator
public abstract class TicketDecorator implements OrderBeanInterface {

    @Inject @Delegate @Any
    OrderBeanInterface orderBean;



    @Override
    public Ticket getTicketToSave(){

        System.out.println("New ticket created");
        return orderBean.getTicketToSave();
    }

}
