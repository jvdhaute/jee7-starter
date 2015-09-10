package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 10/09/2015.
 */
public class FlightPersistenceTest extends DataSetPersistenceTest {

    @Test
    public  void testDomesticFlightCanBePerstisted() throws Exception{

        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateformat3.parse("17/07/1989");
        Date now = new Date();


        DomesticFlight dom = new DomesticFlight(date1, now, "a300", "snb", "dsdfsd");




        entityManager().persist(dom);
        // entityManager().persist(t);

        assertNotNull(dom.getId());

    }

    @Test
    public  void testInternationalFlightCanBePerstisted() throws Exception{

        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateformat3.parse("17/07/1989");
        Date now = new Date();


        InternationalFlight dom = new InternationalFlight(date1, now, "a300", true , "dsdfsd");




        entityManager().persist(dom);
        // entityManager().persist(t);assertEquals("Nineteen Eighty Four", entityManager().find(Book.class, 1000).getTitle());

        assertNotNull(dom.getId());

    }

    @Test
    public  void testInternationalFlightFound() throws Exception {

        assertEquals("snb", entityManager().find(DomesticFlight.class, 1000L).getAirlineCompany());

    }


    @Test
    public  void testDomesticFlightStoredInFlight() throws Exception {
        DomesticFlight f =  entityManager().find(DomesticFlight.class, 1001L);

        assertEquals("ryanair", f.getAirlineCompany());

    }

    @Test
    public  void testInternationFlightStoredInFlight() throws Exception {
        InternationalFlight f =  entityManager().find(InternationalFlight.class, 1002L);

        assertEquals("sdf", f.getRegulations());

    }


}
