package edu.gatech.team10.weshelter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Adrianna Brown on 2/18/2018.
 */

public class Model {

    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** Set of valid users */
    private Map<String, User> _users;

    /** Current user of the app*/
    private User _activeUser;

    private Model() {
        _users = new HashMap<>();
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

    public Map<String, User> getUsers() {
        return _users;
    }

    public void addUser(String username, User user) {
        _users.put(username, user);
    }

}
