package edu.gatech.team10.weshelter;

/**
 * Created by Ben on 4/1/2018.
 */

public interface DBInterface {

    void readShelters();

    void readHomelessPerson();

    void readAdmin();

    void changeShelterCapacity(int key, int capacity);

    void writeNewHomelessPerson(User newUser);

    void HomelessPersonCheckIn(String username, int resKey, int resBeds,
                               boolean reservation);

    void writeNewAdmin(User newUser);


}
