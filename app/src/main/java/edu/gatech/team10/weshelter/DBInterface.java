package edu.gatech.team10.weshelter;

/**
 * Created by Ben on 4/1/2018.
 */

public interface DBInterface {

    public void readShelters();

    public void readHomelessPerson();

    public void readAdmin();

    public void changeShelterCapacity(int key, int capacity);

    public void writeNewHomelessPerson(User newUser);

    public void HomelessPersonCheckIn(String username, int resKey, int resBeds,
                                     boolean reservation);

    public void writeNewAdmin(User newUser);


}
