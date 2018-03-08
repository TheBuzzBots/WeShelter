package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/24/2018.
 */

public class Shelter {
    private int key;
    private String name;
    private String capacity;
    private int capacity_int;
    private int currOccupancy;
    private String restriction;
    private double longitude;
    private double latitude;
    private String address;
    private String specialNote;
    private String phone;

    public Shelter() {
        this(null);
    }

    public Shelter(String name) {
        this.name = name;
    }

    public int getKey() {
        return this.key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return this.capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getCapacityInt() {
        return this.capacity_int;
    }
    public void setCapacityInt(int capacity_int) {
        this.capacity_int = capacity_int;
    }

    public int getCurrOccupancy() {
        return this.currOccupancy;
    }
    public void setCurrOccupancy(int currOccupancy) {
        this.currOccupancy = currOccupancy;
    }
    public String getRestriction() {
        return this.restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }


    public double getLongitude() {
        return this.longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return this.name;
    }
}
