package se.lexicon.mark.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.mark.JPAworkshop.entity.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product testObject = null;
    int id = 10;
    String name = "Pen";
    double price = 10.0;

    @BeforeEach
    void setUp() {
        testObject = new Product(id, name, price);
    }

    @Test
    void successfullyCreated(){
        assertEquals(id, testObject.getProductId());
        assertEquals(name, testObject.getName());
        assertEquals(price, testObject.getPrice());
    }

    @Test
    void testEquals() {
        Product shouldBeEqual = new Product(id, name, price);

        assertTrue(testObject.equals(shouldBeEqual));
    }

    @Test
    void testHashCode() {
        Product shouldBeEqual = new Product(id, name, price);

        assertEquals(shouldBeEqual.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {

        String toString = testObject.toString();

        assertTrue(toString.contains("10"));
        assertTrue(toString.contains(name));
        assertTrue(toString.contains("10.0"));
    }
}