package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/26/2018.
 */

public class HomelessPerson extends User {

    public HomelessPerson() {
        super();
    }

    public HomelessPerson(String username, String password, String name) {
        super(username, password, name, "User");
    }
}
