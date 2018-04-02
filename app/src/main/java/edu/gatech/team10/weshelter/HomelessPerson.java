package edu.gatech.team10.weshelter;


/**
 * Created by Adrianna Brown on 2/26/2018.
 */

public class HomelessPerson extends User {

    private boolean reservation;
    private int resKey;
    private int resBeds;

    /**
     * Constructs a default HomelessPerson (HP) User. See abstract User class.
     */
    public HomelessPerson() {
        super();
    }

    /**
     * Constructs a HomelessPerson User from given parameters.
     * @param username username of HomelessPerson
     * @param password password of HomelessPerson
     * @param name name of HomelessPerson
     */
    public HomelessPerson(String username, String password, String name) {
        super(username, password, name, "User");
    }

    /**
     * Getter for reservation boolean.
     * @return boolean if the User already has a reservation
     */
    public boolean getReservation() {
        return reservation;
    }

    /**
     * Setter for reservation boolean.
     * @param res whether or not the User has a reservation at a Shelter
     */
    public void setReservation(boolean res) {
        this.reservation = res;
    }

    /**
     * Getter for resKey value.
     * @return int the key of the Shelter with which the HP has a reservation
     */
    public int getResKey() {
        return resKey;
    }

    /**
     * Setter for resKey value.
     * @param key int the key of the Shelter with which the HP is making a reservation
     */
    public void setResKey(int key) {
        this.resKey = key;
    }

    /**
     * Getter for resBeds value.
     * @return int number of beds the HP has reserved
     */
    public int getResBeds() {
        return resBeds;
    }

    /**
     * Setter for resBeds value.
     * @param beds the number of beds the HP has reserved
     */
    public void setResBeds(int beds) {
        this.resBeds = beds;
    }

    /**
     * Makes a reservation for the HP.
     *
     * Has to violate the Law of Demeter.
     * Otherwise, Homeless Users in Firebase must have a Firebase attribute.
     * @param key the key of the Shelter at which the HP is making a reservation
     * @param beds the number of beds that the HP has reserved
     */
    public void makeReservation(int key, int beds) {
        this.resBeds = beds;
        this.resKey = key;
        this.reservation = true;
        FirebaseDB database = new FirebaseDB();
        database.HomelessPersonCheckIn(getUsername(), resKey, resBeds, reservation);
    }

    /**
     * Cancels the HP's reservation.
     *
     * Has to violate the Law of Demeter.
     * Otherwise, Homeless Users in Firebase must have a Firebase attribute.
     */
    public void cancelReservation() {
        this.reservation = false;
        this.resBeds = 0;
        this.resKey = 0;
        FirebaseDB database = new FirebaseDB();
        database.HomelessPersonCheckIn(getUsername(), resKey, resBeds, reservation);
    }

    /**
     * Checks if the HP has a reservation with a certain Shelter.
     * @param shelterKey unique key identifier of Shelter
     * @return boolean if the HP has a reservation at the given Shelter
     */
    public boolean isReservedShelter(int shelterKey) {
        return resKey == shelterKey;
    }
}
