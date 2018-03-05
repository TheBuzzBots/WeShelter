package edu.gatech.team10.weshelter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Adrianna Brown on 2/18/2018.
 */

public class Model extends AppCompatActivity{

    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }




    /** set of shelters */
    private List<Shelter> _shelters;

    private Shelter _activeShelter;

    /** Set of valid users */
    private Map<String, User> _users;

    /** Current user of the app*/
    private User _activeUser;

    private Model() {
        _users = new HashMap<>();
        _shelters = new ArrayList<>();
        //will probably connect to the database here
    }

    public List<Shelter> getShelters() {
        return _shelters;
    }

    public void setShelters(List<Shelter> shelters) {
        this._shelters = shelters;
    }

    public void addShelter(Shelter shelter) {
        _shelters.add(shelter);
    }

    public void setActiveShelter(Shelter activeShelter) {
        this._activeShelter = activeShelter;
    }

    public Shelter getActiveShelter() {
        return _activeShelter;
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
