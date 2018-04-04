package edu.gatech.team10.weshelter;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ShelterCheckInActivity extends AppCompatActivity {

    private EditText neededBeds;
    private HomelessPerson user = (HomelessPerson) Model.getInstance().getActiveUser();
    private Shelter shelter = Model.getInstance().getActiveShelter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_check_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        neededBeds = (EditText) findViewById(R.id.editText_checkin_numbeds);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    /**
     * Verifies the attempt to check into a shelter.
     * @param v current view
     */
    public void verifyCheckIn(View v) {

        if (neededBeds.getText().toString().equals("")) {
            Snackbar.make(v, "Please select a number of beds.", Snackbar.LENGTH_LONG).show();
        } else {

            int numBeds = Integer.parseInt(neededBeds.getText().toString());

            if (user.getReservation()) {
                Snackbar.make(v, "Please cancel existing reservation before making a new one.",
                        Snackbar.LENGTH_LONG).show();
            } else if (!shelter.isValidBeds(numBeds)) {
                Snackbar.make(v, "Please select a valid number of beds.",
                        Snackbar.LENGTH_LONG).show();
            } else {
                shelter.changeCapacity(numBeds, true);
                FirebaseDB database = new FirebaseDB();
                database.changeShelterCapacity(shelter.getKey(), shelter.getCapacityInt());
                user.makeReservation(shelter.getKey(), numBeds);

                finish();
            }
        }
    }

    /**
     * Cancels an existing reservation with the current shelter.
     * @param v current view
     */
    public void cancelCheckIn(View v) {

        if (!user.getReservation()) {
            Snackbar.make(v, "You have no existing reservation to cancel.",
                    Snackbar.LENGTH_LONG).show();
        } else if (!user.isReservedShelter(shelter.getKey())) {
            Snackbar.make(v, "Your existing reservation is not with this shelter.",
                    Snackbar.LENGTH_LONG).show();
        } else {
            shelter.changeCapacity(user.getResBeds(), false);
            FirebaseDB database = new FirebaseDB();
            database.changeShelterCapacity(shelter.getKey(), shelter.getCapacityInt());
            user.cancelReservation();
            finish();
        }

    }

}
