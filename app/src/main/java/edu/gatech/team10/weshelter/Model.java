package edu.gatech.team10.weshelter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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

    private List<Shelter> _filteredShelters;

    /** Set of valid users */
    private Map<String, User> _users;

    /** Current user of the app*/
    private User _activeUser;

    private Model() {
        _users = new HashMap<>();
        _shelters = new ArrayList<>();
        _filteredShelters = new ArrayList<>();
    }

    public List<Shelter> getShelters() {
        return _shelters;
    }

//    public void readShelters(InputStream is) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
//        String line;
//        try {
//            br.readLine(); //get rid of header line
//            while ((line = br.readLine()) != null) {
//
//                String[] data = line.split("\\|");
//                Shelter shelter = new Shelter();
//
//                int key = Integer.parseInt(data[0]);
//                double longitude = Double.parseDouble(data[4]);
//                double latitude = Double.parseDouble(data[5]);
//
//                shelter.setKey(key);
//                shelter.setName(data[1]);
//                shelter.setCapacity(data[2]);
//                shelter.setRestriction(data[3]);
//                shelter.setLongitude(longitude);
//                shelter.setLatitude(latitude);
//                shelter.setAddress(data[6]);
//                shelter.setSpecialNote(data[7]);
//                shelter.setPhone(data[8]);
//
//                addShelter(shelter);
//            }
//            br.close();
//        } catch (IOException e) {
//            Log.e("IO", "error reading assets", e);
//        }
//    }

    public void setShelters(List<Shelter> shelters) {
        this._shelters = shelters;
    }

    public void addShelter(Shelter shelter) {
        _shelters.add(shelter);
        _filteredShelters.add(shelter);
    }

    public void setFilteredShelters(List<Shelter> shelters) {
        this._filteredShelters =  shelters;
    }

    public List<Shelter> getFilteredShelters() {
        return _filteredShelters;
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
