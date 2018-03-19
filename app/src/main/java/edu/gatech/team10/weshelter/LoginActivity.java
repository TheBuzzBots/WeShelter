package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.InputStream;
import java.util.Map;

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
        //gets text input from view fields
        usernameField = (EditText) findViewById(R.id.editText_login_username);
        passwordField = (EditText) findViewById(R.id.editText_login_password);

        //fetches map of valid users
        Map<String, User> users = Model.getInstance().getUsers();

        //checks if username is valid user
        if (users.containsKey(usernameField.getText().toString())) {
            User user = users.get(usernameField.getText().toString());
            //checks if password is correct for specified user
            if (user.checkPassword(passwordField.getText().toString())) {
                Model.getInstance().setActiveUser(user);
                startActivity(new Intent(LoginActivity.this, ShelterListActivity.class));
            } else {
                Snackbar.make(v, "Invalid Password.", Snackbar.LENGTH_LONG).show();
            }
        } else {
            Snackbar.make(v, "Invalid Username.", Snackbar.LENGTH_LONG).show();
        }
    }


}
