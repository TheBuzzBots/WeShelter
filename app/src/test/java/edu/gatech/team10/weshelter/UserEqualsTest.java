package edu.gatech.team10.weshelter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualsUserTest {
    User mark;
    User nami;
    User shannon;
    User megan;
    User millie;
    User nullUser;

    @Before
    public void setUp() {
        mark = new HomelessPerson("mark","myNameIsM@rk","Mark");
        nami = new HomelessPerson("nami","n@emiOtsuk","Nami");
        shannon = new HomelessPerson("nami","n@emiOtsuk","Nami");
        megan = new HomelessPerson("megan","M3g@n1234","Megan");
        millie = new HomelessPerson("millie","y0ungMill$","Millie");
        nullUser = null;

    }
    /**
     * Tests whether the object equals null and returns false;
     */
    @Test
    public void testUserEqualsNull() {
        boolean result = false;
        assertEquals(result,nullUser);
    }

    /**
     * Tests whether a null object returns false;
     */
    @Test
    public void testNullUser() {
        boolean result = false;
        assertEquals(result,mark.equals(nullUser));
    }

    /**
     * Tests whether an object gives true when compared to itself
     */
    @Test
    public void testEqualsItself() {
        boolean result = true;
        assertEquals(result,mark.equals(mark));
    }

    /**
     * Tests whether an object gives false when compared
     * to another object with different attributes
     */
    @Test
    public void testNotEqualsItself() {
        boolean result = false;
        assertEquals(result,mark.equals(nami));
    }

    /**
     * Tests whether two different objects with the
     * same attributes are equal
     */
    @Test
    public void testEquals() {
        boolean result = false;
        assertEquals(result,nami.equals(shannon));
    }
}
