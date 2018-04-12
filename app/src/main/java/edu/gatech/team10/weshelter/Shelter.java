package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/24/2018.
 */

public class Shelter {
    private int key;
    private String name;
    private String capacity;
    private int capacity_int;
    private String restriction;
    private double longitude;
    private double latitude;
    private String address;
    private String specialNote;
    private String phone;

    /**
     * Constructs a Shelter with a null name.
     */
    public Shelter() {
        this(null);
    }

    /**
     * Constructs a Shelter with the given name.
     * @param name name of the Shelter
     */
    public Shelter(String name) {
        this.name = name;
    }

    /**
     * Getter for unique key identifying Shelter.
     * @return int key of shelter
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Setter for unique key.
     * @param key id number to set key to
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Getter for name.
     * @return String name of the shelter
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for name.
     * @param name String to set the name of the Shelter to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for capacity (the String representing specific room types, if specified).
     * @return String the specific capacity
     */
    public String getCapacity() {
        return this.capacity;
    }

    /**
     * Setter for capacity.
     * @param capacity the specific capacity for the Shelter
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter for capacity_int (the int representing the general number of beds).
     * @return int number of beds available
     */
    public int getCapacityInt() {
        return this.capacity_int;
    }

    /**
     * Setter for capacity_int.
     * @param capacity_int the current number of beds available
     */
    public void setCapacityInt(int capacity_int) {
        if (capacity_int >= 0) {
            this.capacity_int = capacity_int;
        }
    }

    /**
     * Getter for restriction (types of people Shelter service is limited to).
     * @return String demographic restriction
     */
    public String getRestriction() {
        return this.restriction;
    }

    /**
     * Setter for restriction.
     * @param restriction demographic restriction
     */
    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    /**
     * Getter for specialNote (extra details about the Shelter).
     * @return String about the shelter
     */
    public String getSpecialNote() {
        return specialNote;
    }

    /**
     * Setter for specialNote.
     * @param specialNote about the shelter
     */
    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    /**
     * Getter for longitude (location of Shelter).
     * @return double shelter's longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Setter for longitude.
     * @param longitude shelter's longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter for latitude (location of Shelter)
     * @return double shelter's latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Setter for latitude.
     * @param latitude shelter's latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter for address.
     * @return String shelter's address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Setter for address.
     * @param address shelter's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for phone (the phone number for the shelter).
     * @return String shelter's phone number
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter for phone.
     * @param phone shelter's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Changes capacity_int to reflect current vacancies.
     *
     * Has to violate the Law of Demeter
     * Otherwise, Shelters in Firebase must have have a FirebaseDB attribute.
     * @param beds number of beds to be changed by
     * @param subtract true if beds should be removed, false if beds should be added
     */
    public void changeCapacity(int beds, boolean subtract) {
        int newCapacity;

        if (subtract) {
            newCapacity = capacity_int - beds;
        } else {
            newCapacity = capacity_int + beds;
        }

        if (newCapacity < 0) {
            return;
        }

        this.capacity_int = newCapacity;
    }

    /**
     * Checks if some requested number of beds are available in the Shelter (within capacity_int).
     * @param beds number of beds requested
     * @return whether a reservation can be made for the requested number of beds
     */
    public boolean isValidBeds(int beds) {
        if (beds <= 0) {
            return false;
        } else return beds <= capacity_int;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof Shelter)) {
            return false;
        }
        Shelter other = (Shelter) o;
        return (other.key == this.key) && (other.name.equals(this.name));
    }
}
