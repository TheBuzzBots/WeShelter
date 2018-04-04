package edu.gatech.team10.weshelter;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Adrianna Brown on 4/3/2018.
 */

public class ShelterChangeCapacityTests {

    private Shelter shelter;

    /**
     * Sets up model and shelter.
     */
    @Before
    public void setUp() {
        shelter = new Shelter();
        shelter.setCapacityInt(100);
        shelter.setKey(13);
    }

    /**
     * Beds < 0
     * Subtract true
     * 100 - (-5) = 105
     */
    @Test
    public void testBedNegSubTrue() {
        shelter.setCapacityInt(100);
        int beds = -5;
        boolean sub = true;
        int expected = 105;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());
    }

    /**
     * Beds < 0
     * Subtract false
     * 100 + (-5) = 95
     */
    @Test
    public void testBedNegSubFalse() {
        shelter.setCapacityInt(100);
        int beds = -5;
        boolean sub = false;
        int expected = 95;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());
    }

    /**
     * Beds == 0
     * Subtract true
     * 100 - (0) = 100
     */
    @Test
    public void testBedZeroSubTrue() {
        shelter.setCapacityInt(100);
        int beds = 0;
        boolean sub = true;
        int expected = 100;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());
    }

    /**
     * Beds == 0
     * Subtract false
     * 100 + (0) = 100
     */
    @Test
    public void testBedZeroSubFalse() {
        shelter.setCapacityInt(100);
        int beds = 0;
        boolean sub = false;
        int expected = 100;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());
    }

    /**
     * Beds > 0
     * Subtract true
     * 100 - (5) = 95
     */
    @Test
    public void testBedPosSubTrue() {
        shelter.setCapacityInt(100);
        int beds = 5;
        boolean sub = true;
        int expected = 95;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());
    }

    /**
     * Beds > 0
     * Subtract false
     * 100 + (5) = 105
     */
    @Test
    public void testBedPosSubFalse() {
        shelter.setCapacityInt(100);
        int beds = 5;
        boolean sub = false;
        int expected = 105;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());

    }

    /**
     * Beds > 0
     * Subtract true
     * Change exceeds capacity (expected: no change to capacityInt)
     */
    @Test
    public void testBedPosSubTrueExceedLimit() {
        shelter.setCapacityInt(100);
        int beds = 101;
        boolean sub = true;
        int expected = 100;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());

    }

    /**
     * Beds < 0
     * Subtract false
     * Change exceeds capacity (expected: no change to capacityInt)
     */
    @Test
    public void testBedNegSubFalseExceedLimit() {
        shelter.setCapacityInt(100);
        int beds = -101;
        boolean sub = false;
        int expected = 100;

        shelter.changeCapacity(beds, sub);

        assertEquals(expected, shelter.getCapacityInt());
    }
}
