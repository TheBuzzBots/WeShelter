package edu.gatech.team10.weshelter;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Ben on 4/8/2018.
 */

public class ShelterIsValidBedsTests {
    private Shelter shelter;

    /**
     * Sets up a shelter with initial capacity_int of 10.
     */
    @Before
    public void setUp() {
        shelter = new Shelter();
        shelter.setCapacityInt(10);
    }

    /**
     * Tests to see if a negative beds would give false from the method.
     */
    @Test
    public void testBedNegative() {

        int beds = -2;
        boolean expected = false;
        assertEquals(expected, shelter.isValidBeds(beds));

    }

    /**
     * Tests to see if zero beds would give false.
     */
    @Test
    public void testBedZero() {
        int beds = 0;
        boolean expected = false;
        assertEquals(expected, shelter.isValidBeds(beds));

    }

    /**
     * Tests to see if more than capacity_int would give false.
     */
    @Test
    public void testBedExceeds() {
        int beds = 11;
        boolean expected = false;
        assertEquals(expected, shelter.isValidBeds(beds));
    }

    /**
     * Tests to see if beds==capacity_int would give true.
     */
    @Test
    public void testBedEqualCapacity() {
        int beds = 10;
        boolean expected = true;
        assertEquals(expected, shelter.isValidBeds(beds));
    }

    /**
     * Tests to see if 0 < beds < capacity_int would give true.
     */
    @Test
    public void testBedLessThanCapacity() {
        int beds = 5;
        boolean expected = true;
        assertEquals(expected, shelter.isValidBeds(beds));
    }

}
