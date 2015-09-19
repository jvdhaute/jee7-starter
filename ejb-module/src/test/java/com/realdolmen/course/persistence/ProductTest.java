package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.OnlineOrder;
import com.realdolmen.course.domain.Order;
import com.realdolmen.course.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

/**
 * Created by JVDAX31 on 19/09/2015.
 */
public class ProductTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();


/*
    @Test
    public void productCanBeRetrievedById() throws Exception {
        assertEquals("s5", entityManager().find(Product.class, 2001).getName());
        assertEquals("iphone", entityManager().find(Product.class, 2003).getDescription());
    }

    @Test
    public void onlineOrderCanBeRetrievedById() throws Exception {
        assertEquals("id 1001", entityManager().find(OnlineOrder.class, 1001).getDescription());
        assertEquals("id 1003", entityManager().find(OnlineOrder.class, 1003).getDescription());
    }

    @Test
    public void orderHasProduct() throws Exception {
        assertEquals("s5", entityManager().find(OnlineOrder.class, 1001).getProducts().get(0).getName());
        assertEquals("iphone", entityManager().find(OnlineOrder.class, 1003).getProducts().get(0).getDescription());
    }

    @Test
    public void productHasOrder() throws Exception {
        assertEquals("id 1001", entityManager().find(Product.class, 2001).getOrders().get(0).getDescription());
        assertEquals("id 1003", entityManager().find(Product.class, 2003).getOrders().get(0).getDescription());
    }


    @Test
    public void passengerCanBePersisted() throws Exception {

        Product p = new Product("laptop", 1010, 500, "this is a laptop");
        entityManager().persist(p);
        assertNotNull(p.getId());


    }

    @Test
    public void orderCanBePersisted() throws Exception {
        OnlineOrder onlineOrder = new OnlineOrder("test", new Date());
        entityManager().persist(onlineOrder);
        assertNotNull(onlineOrder.getId());
    }

    @Test
    public void orderwithproductCanBePersisted() throws Exception {
        OnlineOrder onlineOrder = new OnlineOrder("test2", new Date());

        Product p = new Product("laptop2", 1010, 500, "this is a laptop");
        onlineOrder.addProduct(p);
        entityManager().persist(p);
        entityManager().persist(onlineOrder);
        assertNotNull(onlineOrder.getId());
        assertNotNull(p.getId());
    }


    @Test
    public void orderHasTwoProducts() throws Exception {
        assertEquals(2, entityManager().find(OnlineOrder.class, 1002).getProducts().size());

    }

    */
    @Test
    public void orderAddsNewProduct() throws Exception {
        Product p = new Product("external Adapter", 2000, 550, "this is an adapter");
        OnlineOrder onlineOrder = entityManager().find(OnlineOrder.class, 1003);
        onlineOrder.addProduct(p);
        entityManager().persist(p);
        entityManager().merge(onlineOrder);
        assertEquals(2, entityManager().find(OnlineOrder.class, 1003).getProducts().size());

    }



}
