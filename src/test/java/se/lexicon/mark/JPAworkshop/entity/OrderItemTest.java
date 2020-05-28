package se.lexicon.mark.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {
    OrderItem testObject;
    Integer id;
    Integer quantity;
    Product product;
    ProductOrder productOrder;


    @BeforeEach
    void setUp() {

        testObject = null;
        id = 10;
        quantity = 100;
        product = null;
        productOrder = null;

        product = new Product(10,"Pen", 10.0);
        productOrder = new ProductOrder();

        testObject = new OrderItem(id, quantity, product, productOrder);

    }

    @Test
    void SuccessfullyCreated(){
        assertEquals(id, testObject.getOrderItemId());
        assertEquals(quantity, testObject.getQuantity());
        assertEquals(product, testObject.getProduct());
        assertEquals(productOrder, testObject.getProductOrder());

    }

    @Test
    void testEquals() {
        OrderItem shouldBeEqual = new OrderItem(id, quantity, product, productOrder);

        assertTrue(testObject.equals(shouldBeEqual));
    }

    @Test
    void testHashCode() {
        OrderItem shouldBeEqual = new OrderItem(id, quantity, product, productOrder);
        assertEquals(shouldBeEqual.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {

        String toString = testObject.toString();

        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(quantity.toString()));
        assertTrue(toString.contains((product.toString())));
    }

    @Test
    void calculateOrderItems() {
        // Arrange
        double expected = 1000.0;

        // Act
        double actual = testObject.calculateOrderItems();

        // Assert
        assertEquals(expected,actual);
    }
    @Test
    void calculateOrderItemWithZeroQuantity() {
        // Arrange
        double expected = 0.0;
        testObject.setQuantity(0);

        // Act
        double actual = testObject.calculateOrderItems();

        // Assert
        assertEquals(expected,actual);
    }

}