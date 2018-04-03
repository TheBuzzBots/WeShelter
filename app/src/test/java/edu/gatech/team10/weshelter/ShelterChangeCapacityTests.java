package edu.gatech.team10.weshelter;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Adrianna Brown
 * Unit tests for changeCapacity() in Shelter.
 *
 * Covers if-statement based on subtract boolean.
 * Covers every int beds partition.
 * Covers if-statement when newCapacity is negative.
 */
public class ShelterChangeCapacityTests {
    private Model testModel;
    private Shelter shelter;
    private DBInterface db;

    /**
     * Sets up mock database to ensure no calls are made to production database during testing.
     */
    @Before
    public void setUp() {
        testModel = Model.getInstance();
        db = mock(DBInterface.class);
        testModel.setDatabase(db);

        doNothing().when(db).changeShelterCapacity(isA(Integer.class), isA(Integer.class));

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
