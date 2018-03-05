package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.InputStream;

public class WelcomeActivity extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Shelter");
    final private Model model = Model.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 0;
                for (DataSnapshot shelterSnapshot : dataSnapshot.getChildren()) {

                    String name = Integer.toString(i);

                    Shelter shelter = new Shelter("");
                    shelter.setAddress(shelterSnapshot.child("Address").getValue(String.class));
                   // System.out.println("Address: " + shelter.getAddress());
                    Log.d("Firebase Read", "Added Address");
                    shelter.setCapacity(shelterSnapshot.child("Capacity").getValue(String.class));
                    //System.out.println("Capacity: " + shelter.getCapacity());
                    shelter.setLongitude(shelterSnapshot.child("Longitude").getValue(String.class));
                    //System.out.println("Longitude " + shelter.getLongitude());
                    shelter.setLatitude(shelterSnapshot.child("Latitude ").getValue(String.class));
                    //System.out.println("Latitude: "+ shelterSnapshot.child("Latitude ").getValue(String.class));
                    shelter.setPhone(shelterSnapshot.child("Phone Number").getValue(String.class));
                    shelter.setRestriction(shelterSnapshot.child("Restricitons").getValue(String.class));
                    shelter.setSpecialNote(shelterSnapshot.child("Special Notes").getValue(String.class));
                    shelter.setKey(shelterSnapshot.child("Unique Key").getValue(String.class));
                    model.addShelter(shelter);
                    i++;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.v("Database Error", "Failed to read value.", error.toException());
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loadShelters();
    }

    public void loginFromWelcome(View v){
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    public void registerFromWelcome(View v) {
        startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
    }

    private void loadShelters() {
        InputStream is = getResources().openRawResource(R.raw.shelterdata);
        Model.getInstance().readShelters(is);
    }
}
