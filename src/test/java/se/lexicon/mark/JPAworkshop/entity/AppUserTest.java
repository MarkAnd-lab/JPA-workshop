package se.lexicon.mark.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.mark.JPAworkshop.entity.AppUser;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    // Arrange
    AppUser theObject = null;
    Integer id = 10;
    String firstName = "Mark";
    String lastName = "Andersson";
    String email = "mark-andersson@hotmail.com";

    @BeforeEach
    void setUp() {
        theObject = new AppUser(id,firstName,lastName,email);

    }
    @Test
    void testSuccessfullyCreated(){

        assertEquals(10, theObject.getAppUserId());
        assertEquals("Mark", theObject.getFirstName());
        assertEquals("Andersson", theObject.getLastName());
        assertEquals("mark-andersson@hotmail.com", theObject.getEmail());

    }

    @Test
    void testEquals() {
        AppUser isEqual = new AppUser(id,firstName,lastName,email);

        assertTrue(theObject.equals(isEqual));
    }

    @Test
    void testHashCode() {
        AppUser isEqual = new AppUser(id,firstName,lastName,email);

        assertEquals(isEqual.hashCode(), theObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = theObject.toString();

        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains((firstName)));
        assertTrue(toString.contains(lastName));
        assertTrue(toString.contains(email));


    }
}