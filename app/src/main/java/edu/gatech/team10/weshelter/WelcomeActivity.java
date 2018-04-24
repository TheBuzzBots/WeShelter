package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class WelcomeActivity extends AppCompatActivity {

    final private Model model = Model.getInstance();
    private DBInterface database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        model.setDatabase(new FirebaseDB());
        database = model.getDatabase();
        database.readShelters();
        database.readHomelessPerson();
        database.readAdmin();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    /**
     * On button click, goes to Login screen.
     * @param v current view
     */
    public void loginFromWelcome(View v){
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    /**
     * On button click, goes to Registration screen
     * @param v current view
     */
    public void registerFromWelcome(View v) {
        startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
    }

    /**
     * On text click, goes straight to Shelter list
     * @param v current view
     */
    public void guestLoginFromWelcome(View v) {
        model.setActiveUser(new Guest());
        startActivity(new Intent(WelcomeActivity.this, ShelterListActivity.class));
    }
}
