package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void cancelLogin(View v){
        finish();
    }

    public void verifyLogin(View v) {
        usernameField = (EditText) findViewById(R.id.editText_login_username);
        passwordField = (EditText) findViewById(R.id.editText_login_password);

        if (usernameField.getText().toString().equals("user")
                && passwordField.getText().toString().equals("password")) {
            startActivity(new Intent(LoginActivity.this, ShelterListActivity.class));
        } else {
            Snackbar.make(v, "Invalid Username or Password.", Snackbar.LENGTH_LONG).show();
        }
    }

}
