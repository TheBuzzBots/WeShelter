package edu.gatech.team10.weshelter;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adrianna Brown on 2/18/2018.
 */

public class Model extends AppCompatActivity{

    private static final Model _instance = new Model();

    private List<Shelter> _shelters;
    private List<Shelter> _filteredShelters;
    private Shelter _activeShelter;

    private Map<String, User> _users;
    private User _activeUser;

    /**
     * Getter for _instance. Allows other classes in package to access Singleton.
     * @return Model _instance
     */
    public static Model getInstance() {
        return _instance;
    }

    private Model() {
        _users = new HashMap<>();
        _shelters = new ArrayList<>();
        _filteredShelters = new ArrayList<>();
    }

    /**
     * Getter for _shelters.
     * @return List of all Shelters
     */
    public List<Shelter> getShelters() {
        return _shelters;
    }

    /**
     * Setter for _shelters.
     * @param shelters list of shelters to set _shelters to
     */
    public void setShelters(List<Shelter> shelters) {
        this._shelters = shelters;
    }

    /**
     * Adds a Shelter to the list of all Shelters.
     * @param shelter the Shelter to be added
     */
    public void addShelter(Shelter shelter) {
        _shelters.add(shelter);
        _filteredShelters.add(shelter);
    }

    /**
     * Setter for _filteredShelters (a specific subset of _shelters).
     * @param shelters list of shelters to set _filteredShelters to
     */
    public void setFilteredShelters(List<Shelter> shelters) {
        this._filteredShelters =  shelters;
    }

    /**
     * Getter for _filteredShelters.
     * @return List of filtered shelters
     */
    public List<Shelter> getFilteredShelters() {
        return _filteredShelters;
    }

    /**
     * Setter for _activeShelter (Shelter selected by the User).
     * @param activeShelter the current Shelter
     */
    public void setActiveShelter(Shelter activeShelter) {
        this._activeShelter = activeShelter;
    }

    /**
     * Getter for _activeShelter.
     * @return Shelter the current Shelter
     */
    public Shelter getActiveShelter() {
        return _activeShelter;
    }

    /**
     * Setter for _activeUser (User currently using the app)
     * @param activeUser the current active user of the app
     * */
    public void setActiveUser(User activeUser) {
        _activeUser = activeUser;
    }

    /**
     * Getter for _activeUser.
     * @return User the current active user of the app
     * */
    public User getActiveUser() {
        return _activeUser;
    }

    /**
     * Getter for _users.
     * @return Map of all valid users
     */
    public Map<String, User> getUsers() {
        return _users;
    }

    /**
     * Adds a new User to the list of valid users.
     * @param username username of the new User
     * @param user User instance
     */
    public void addUser(String username, User user) {
        _users.put(username, user);
    }

    /**
     * Checks if a valid User exists in _users matching the given credentials.
     * @param user the username of the User
     * @param pass the password of the User
     * @return boolean if the User is a valid user
     */
    public boolean isValidUser(String user, String pass) {
        if (user == null || pass == null) {
            return false;
        } else if (!_users.containsKey(user)) {
            return false;
        } else {
            User u = _users.get(user);
            return u.checkPassword(pass);
        }
    }
}
