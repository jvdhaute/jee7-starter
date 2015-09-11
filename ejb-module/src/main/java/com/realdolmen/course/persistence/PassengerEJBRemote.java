package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by JVDAX31 on 11/09/2015.
 */

@Remote
public interface PassengerEJBRemote {

    List<Passenger> findPassengers();
    Passenger findPassengerById(Long id);

    void deletePassenger(Passenger passenger);
}
