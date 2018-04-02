package edu.gatech.team10.weshelter;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ben on 4/1/2018.
 */

public class FirebaseDB implements DBInterface {

    DatabaseReference shelterRef = FirebaseDatabase.getInstance().getReference("Shelter");
    DatabaseReference homelessRef = FirebaseDatabase.getInstance().getReference("User/HomelessPerson");
    DatabaseReference adminRef = FirebaseDatabase.getInstance().getReference("User/Admin");
    final private Model model = Model.getInstance();

    public void readShelters(){
        shelterRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot shelterSnapshot : dataSnapshot.getChildren()) {

                    Shelter shelter = new Shelter();
                    shelter.setAddress(shelterSnapshot.child("Address").getValue(String.class));
                    shelter.setCapacity(shelterSnapshot.child("Capacity").getValue(String.class));
                    shelter.setCapacityInt(Integer.parseInt((String) shelterSnapshot.child("Int Capacity").getValue()));
                    shelter.setLongitude(Double.parseDouble((String) shelterSnapshot.child("Longitude ").getValue()));
                    shelter.setLatitude(Double.parseDouble((String) shelterSnapshot.child("Latitude ").getValue()));
                    shelter.setPhone(shelterSnapshot.child("Phone Number").getValue(String.class));
                    shelter.setName(shelterSnapshot.child("Shelter Name").getValue(String.class));
                    shelter.setRestriction(shelterSnapshot.child("Restrictions").getValue(String.class));
                    shelter.setSpecialNote(shelterSnapshot.child("Special Notes").getValue(String.class));
                    shelter.setKey(Integer.parseInt((String) shelterSnapshot.child("Unique Key").getValue()));
                    shelter.setCapacityInt(Integer.parseInt((String) shelterSnapshot.child("Int Capacity").getValue()));
                    model.addShelter(shelter);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("Database Error", "Failed to read value.", error.toException());

            }
        });


    }

    @Override
    public void readHomelessPerson() {
        homelessRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    HomelessPerson homelessUser = new HomelessPerson();
                    homelessUser.setResBeds(userSnapshot.child("resBeds").getValue(Long.class).intValue());
                    homelessUser.setReservation(userSnapshot.child("reservation").getValue(Boolean.class));
                    homelessUser.setResKey(userSnapshot.child("resKey").getValue(Long.class).intValue());
                    homelessUser.setName(userSnapshot.child("name").getValue(String.class));
                    homelessUser.setPassword(userSnapshot.child("password").getValue(String.class));
                    homelessUser.setType(userSnapshot.child("type").getValue(String.class));
                    homelessUser.setUsername(userSnapshot.child("username").getValue(String.class));
                    model.addUser(homelessUser.getUsername(), homelessUser);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Database Error", "Failed to read value.", databaseError.toException());
            }
        });
    }

    @Override
    public void readAdmin() {
        adminRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    Admin adminUser = new Admin();
                    adminUser.setName(userSnapshot.child("name").getValue(String.class));
                    adminUser.setPassword(userSnapshot.child("password").getValue(String.class));
                    adminUser.setType(userSnapshot.child("type").getValue(String.class));
                    adminUser.setUsername(userSnapshot.child("username").getValue(String.class));
                    model.addUser(adminUser.getUsername(), adminUser);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Database Error", "Failed to read value.", databaseError.toException());
            }
        });
    }

    @Override
    public void writeNewHomelessPerson(User newUser) {
        homelessRef.child(newUser.getUsername()).setValue(newUser);
    }

    @Override
    public void writeNewAdmin(User newUser) {
        adminRef.child(newUser.getUsername()).setValue(newUser);
    }

    @Override
    public void changeShelterCapacity(int key, int capacity) {
        shelterRef.child(Integer.toString(key)).child("Int Capacity")
                .setValue(Integer.toString(capacity));

    }

    @Override
    public void HomelessPersonCheckIn(String username, int resBeds, int resKey,
                                     boolean reservation) {
        DatabaseReference userRef = FirebaseDatabase.getInstance()
                .getReference("User/HomelessPerson/" + username);
        userRef.child("resBeds").setValue(resBeds);
        userRef.child("resKey").setValue(resKey);
        userRef.child("reservation").setValue(reservation);

    }
}
