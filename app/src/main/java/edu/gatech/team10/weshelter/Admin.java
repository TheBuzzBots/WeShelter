package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/26/2018.
 */

class Admin extends User {

    /**
     * Constructs a default Admin user. See abstract User class.
     */
    Admin() {
        super();
        setType("Admin");
    }

    /**
     * Constructs an Admin user from given parameters.
     * @param username username of the Admin
     * @param password password of the Admin
     * @param name name of the Admin
     */
    Admin(String username, String password, String name) {
        super(username, password, name, "Admin");
    }
}
