package edu.gatech.team10.weshelter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Adrianna Brown on 2/26/2018.
 */

public class HomelessPerson extends User {

    private boolean reservation;
    private int resKey;
    private int resBeds;

    public HomelessPerson() {
        super();
    }

    public HomelessPerson(String username, String password, String name) {
        super(username, password, name, "User");
    }

    public boolean getReservation() {
        return reservation;
    }

    public void setReservation(boolean res) {
        this.reservation = res;
    }

    public int getResKey() {
        return resKey;
    }

    public void setResKey(int key) {
        this.resKey = key;
    }

    public int getResBeds() {
        return resBeds;
    }

    public void setResBeds(int beds) {
        this.resBeds = beds;
    }

    public void makeReservation(int key, int beds) {
        this.resKey = key;
        this.resBeds = beds;
        setReservation(true);
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("User/" + getUsername());
        userRef.child("resBeds").setValue(beds);
        userRef.child("resKey").setValue(key);
        userRef.child("reservation").setValue(true);
    }
}
