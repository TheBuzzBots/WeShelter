package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class WelcomeActivity extends AppCompatActivity {

    final private Model model = Model.getInstance();
    private FirebaseDB database = new FirebaseDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!(model.getHasLoadedData())) {
            model.setHasLoadedData(true);
            database.readShelters();
            database.readHomelessPerson();
            database.readAdmin();
        }
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

}
