package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/26/2018.
 */

public class Admin extends User {

    public Admin() {
        super();
        setType("Admin");
    }

    public Admin(String username, String password, String name) {
        super(username, password, name, "Admin");
    }
}
