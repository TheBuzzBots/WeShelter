package edu.gatech.team10.weshelter;

/**
 * Created by Adrianna Brown on 2/18/2018.
 */

public class Model {

    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** Current user of the app*/
    private User _activeUser;

    private Model() {
        //will probably connect to the database here
    }

    /** @param activeUser the current active user of the app */
    public void setActiveUser(User activeUser) {
        _activeUser = activeUser;
    }

    /** @return User the current active user of the app */
    public User getActiveUser() {
        return _activeUser;
    }

}
