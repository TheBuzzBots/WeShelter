package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ShelterDetailActivity extends AppCompatActivity {

    private Model model = Model.getInstance();
    private User user = model.getActiveUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.canCheckIn()) {
                    startActivity(new Intent(ShelterDetailActivity.this, ShelterCheckInActivity.class));
                } else {
                    Snackbar.make(view, "Admin cannot check-in.", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        TextView shelterName = (TextView) findViewById(R.id.textView_shelter_detail_name);
        shelterName.setText(model.getActiveShelter().getName());
        TextView restrictions = (TextView) findViewById(R.id.textView_shelter_detail_restrictions);
        restrictions.setText(model.getActiveShelter().getRestriction());
        TextView capacity = (TextView) findViewById(R.id.textView_shelter_detail_capacity);
        capacity.setText(model.getActiveShelter().getCapacity());
        TextView vacancy = (TextView) findViewById(R.id.textView_shelter_detail_vacancy);
        vacancy.setText(Integer.toString(model.getActiveShelter().getCapacityInt()));
        TextView address = (TextView) findViewById(R.id.textView_shelter_detail_address);
        address.setText(model.getActiveShelter().getAddress());
        TextView phone = (TextView) findViewById(R.id.textView_shelter_detail_phone);
        phone.setText(model.getActiveShelter().getPhone());
        TextView note = (TextView) findViewById(R.id.textView_shelter_detail_note);
        note.setText(model.getActiveShelter().getSpecialNote());
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView vacancy = (TextView) findViewById(R.id.textView_shelter_detail_vacancy);
        vacancy.setText(Integer.toString(model.getActiveShelter().getCapacityInt()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
