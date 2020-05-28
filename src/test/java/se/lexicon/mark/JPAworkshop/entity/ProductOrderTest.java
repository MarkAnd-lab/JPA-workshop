package se.lexicon.mark.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductOrderTest {
    public static final Integer ID = 10;
    public static final LocalDateTime ORDER_DATE_TIME = LocalDateTime.parse("2000-01-01T00:00:00");
    public static final AppUser CUSTOMER = new AppUser("Simon", "Elbrink", "simon@gmail.com");
    ProductOrder testObject;

    @BeforeEach
    void setUp() {

        testObject = new ProductOrder(ID, ORDER_DATE_TIME,new ArrayList<>(), CUSTOMER);
    }

    @Test
    void successfullyCreated(){
        assertEquals(ID, testObject.getProductOrderId());
        assertEquals(ORDER_DATE_TIME, testObject.getOrderDateTime());
        assertTrue(testObject.getOrderItems().isEmpty());
        assertEquals(CUSTOMER, testObject.getCustomer());
    }

    @Test
    void testEquals() {
        ProductOrder copy = new ProductOrder(ID, ORDER_DATE_TIME,new ArrayList<>(), CUSTOMER);

        assertTrue(testObject.equals(copy));

    }

    @Test
    void testHashCode() {
        ProductOrder copy = new ProductOrder(ID, ORDER_DATE_TIME,new ArrayList<>(), CUSTOMER);
        assertEquals(copy.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = testObject.toString();

        assertTrue(toString.contains(String.valueOf(ID)));
        assertTrue(toString.contains(ORDER_DATE_TIME.toString()));
        assertTrue(toString.contains(CUSTOMER.toString()));
    }

    @Test
    void testAddOrderItem(){
        OrderItem orderItem1 = new OrderItem(30, 30, new Product(2,"Pen", 2.0), testObject);

        testObject.addOrderItem(orderItem1);

        assertTrue(testObject.getOrderItems().contains(orderItem1));

    }

    @Test
    void testRemoveOrderItem(){
        OrderItem orderItem1 = new OrderItem(30, 30, new Product(2,"Pen", 2.0), testObject);
        List<OrderItem> orderItems = Arrays.asList(orderItem1);

        testObject.addOrderItem(orderItem1);

        testObject.removeOrderItem(orderItem1);

        assertFalse(testObject.getOrderItems().contains(orderItem1));

    }


}