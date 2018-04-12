package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Cancels the login attempt.
     * @param v current view
     */
    public void cancelLogin(View v){
        finish();
    }

    /**
     * Verifies the login attempt.
     * @param v current view
     */
    public void verifyLogin(View v) {
        //gets text input from view fields
        EditText usernameField = (EditText) findViewById(R.id.editText_login_username);
        EditText passwordField = (EditText) findViewById(R.id.editText_login_password);

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        //fetches map of valid users
        Map<String, User> users = Model.getInstance().getUsers();

        if (Model.getInstance().isValidUser(username, password)) {
            User user = users.get(username);
            Model.getInstance().setActiveUser(user);
            startActivity(new Intent(LoginActivity.this, ShelterListActivity.class));
        } else {
            Snackbar.make(v, "Invalid Username or Password.", Snackbar.LENGTH_LONG).show();
        }
    }
}
