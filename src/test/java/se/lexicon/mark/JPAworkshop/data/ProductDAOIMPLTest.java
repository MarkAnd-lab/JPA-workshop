package se.lexicon.mark.JPAworkshop.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.mark.JPAworkshop.entity.Product;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class ProductDAOImplTest {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    TestEntityManager entityManager;

    Product testObject;

    @BeforeEach
    void setUp() {
        testObject = entityManager.persistAndFlush(new Product("Pen", 10.0));
    }

/*
    @AfterEach
    void tearDown() {
        productDAO.delete(testObject);
        entityManager.remove(testObject);
        entityManager.flush();
    }
*/

    @Test
    void create() {
        //Arrange
        Product newProduct = new Product("boot", 100.0);

        //Act
        productDAO.create(newProduct);

        //Assert
        assertEquals(newProduct, entityManager.find(Product.class, newProduct.getProductId()));
    }

    @Test
    void findById() {

        //Arrange
        Product expected = testObject;

        //Act
        Product actual = productDAO.findById(testObject.getProductId());

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void findAll() {

        //Arrange
        Collection<Product> expected = Arrays.asList(testObject);

        //Act
        Collection<Product> actual = productDAO.findAll();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void findByName() {
        //Arrange
        Collection<Product> expected = Arrays.asList(testObject);

        //Act
        Collection<Product> actual = productDAO.findByName(testObject.getName());

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void update() {
        //Arrange
        Product expected = new Product(testObject.getProductId(), "Pen", 19.90);

        //Act
        Product actual = productDAO.update(expected);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void delete() {

        //Arrange
        boolean deleted = false;

        //Act
        deleted = productDAO.delete(testObject);

        //Assert
        assertNull(entityManager.find(Product.class, testObject.getProductId()));
        assertTrue(deleted);
    }
}