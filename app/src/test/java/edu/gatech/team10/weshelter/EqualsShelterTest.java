package edu.gatech.team10.weshelter;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Hyunjae Lee on 4/11/2018.
 */

public class EqualsShelterTest {

    private Shelter shelter1;
    private Shelter shelter2;
    private Shelter shelter3;
    private Object random;

    /**
     * Sets up model and shelter.
     */
    @Before
    public void setUp() {
        shelter1 = new Shelter("Shelter");
        shelter1.setCapacityInt(10);
        shelter1.setKey(13);
        shelter2 = new Shelter("Shelter");
        shelter2.setCapacityInt(10);
        shelter2.setKey(13);
        shelter3 = null;
        random = new Object();
    }

    /**
     * Tests to see if a null object gives false.
     */
    @Test
    public void testEqualsNull() {
        boolean expected = false;
        assertEquals(expected, shelter1.equals(shelter3));
    }

    /**
     * Tests to see if the object gives true
     * when compared to itself.
     */
    @Test
    public void testEqualsItself() {
        boolean expected = true;
        assertEquals(expected, shelter1.equals(shelter1));
    }

    /**
     * Tests to see if the object gives false
     * when compared to something other than shelter.
     */
    @Test
    public void testEqualsUser() {
        boolean expected = false;
        assertEquals(expected, shelter1.equals(random));
    }

    /**
     * Tests to see if the object gives true
     * when compared to an object with same attributes
     */
    @Test
    public void testEquals() {
        boolean expected = true;
        assertEquals(expected, shelter1.equals(shelter2));
    }
}
