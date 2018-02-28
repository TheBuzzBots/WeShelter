package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
