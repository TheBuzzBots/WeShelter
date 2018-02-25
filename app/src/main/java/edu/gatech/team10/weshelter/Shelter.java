package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/24/2018.
 */

public class Shelter {
    private int key;
    private String name;
    private int capacity;
    private int currOccupancy;
    private String[] demographic;
    private double longitude;
    private double latitude;
    private String address;
    private String phone;

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

    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrOccupancy() {
        return this.currOccupancy;
    }
    public void setCurrOccupancy(int currOccupancy) {
        this.currOccupancy = currOccupancy;
    }

    public String[] getDemographic() {
        return this.demographic;
    }
    public String demoToString() {
        String demo = "";
        for (int i = 0; i < demographic.length; i++) {
            if (i == demographic.length - 1) {
                demo += demographic[i];
            } else {
                demo += demographic[i] + ", ";
            }
        }
        return demo;
    }
    public void setDemographic(String...demo) {
        this.demographic = new String[demo.length];
        int i = 0;
        for (String s : demo) {
            demographic[i] = s;
            i++;
        }
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
