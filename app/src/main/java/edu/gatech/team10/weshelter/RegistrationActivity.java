package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText usernameField;
    private EditText passwordField;
    private Spinner typeSpinner;
    private FirebaseDB database = new FirebaseDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameField = (EditText) findViewById(R.id.editText_reg_name);
        usernameField = (EditText) findViewById(R.id.editText_reg_username);
        passwordField = (EditText) findViewById(R.id.editText_reg_password);
        typeSpinner = (Spinner) findViewById(R.id.spinner_reg_usertype);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, User.legalTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        typeSpinner.setSelection(0);
    }

    /**
     * Cancels the registration attempt and returns to Welcome screen.
     * @param v current view
     */
    public void cancelRegistration(View v) {
        finish();
    }

    /**
     * Validates the registration attempt.
     * @param v current view
     */
    public void validateRegistration(View v) {
        String name = nameField.getText().toString();
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String type = typeSpinner.getSelectedItem().toString();

        if (name.equals("") || username.equals("") || password.equals("")) {
            Snackbar.make(v, "Please complete all fields.", Snackbar.LENGTH_LONG).show();
        } else if (Model.getInstance().getUsers().containsKey(username)) {
            Snackbar.make(v, "Username already exists.", Snackbar.LENGTH_LONG).show();
        } else {
            User newUser;
            if (type.equals("User")) {
                newUser = new HomelessPerson(username, password, name);
                database.writeNewHomelessPerson(newUser);
            } else {
                newUser = new Admin(username, password, name);
                database.writeNewAdmin(newUser);
            }
            Model.getInstance().addUser(usernameField.getText().toString(), newUser);
            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
        }
    }
}
