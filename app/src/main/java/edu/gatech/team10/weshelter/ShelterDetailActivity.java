package edu.gatech.team10.weshelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ShelterDetailActivity extends AppCompatActivity {

    private final Model model = Model.getInstance();
    private final User user = model.getActiveUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.canCheckIn()) {
                    startActivity(new Intent(ShelterDetailActivity.this, ShelterCheckInActivity.class));
                } else {
                    Snackbar.make(view, "Admin/Guest cannot check-in.", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        TextView shelterName = findViewById(R.id.textView_shelter_detail_name);
        shelterName.setText(model.getActiveShelter().getName());
        TextView restrictions = findViewById(R.id.textView_shelter_detail_restrictions);
        restrictions.setText(model.getActiveShelter().getRestriction());
        TextView capacity = findViewById(R.id.textView_shelter_detail_capacity);
        capacity.setText(model.getActiveShelter().getCapacity());
        TextView vacancy = findViewById(R.id.textView_shelter_detail_vacancy);
        vacancy.setText(Integer.toString(model.getActiveShelter().getCapacityInt()));
        TextView address = findViewById(R.id.textView_shelter_detail_address);
        address.setText(model.getActiveShelter().getAddress());
        TextView phone = findViewById(R.id.textView_shelter_detail_phone);
        phone.setText(model.getActiveShelter().getPhone());
        TextView note = findViewById(R.id.textView_shelter_detail_note);
        note.setText(model.getActiveShelter().getSpecialNote());
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView vacancy = findViewById(R.id.textView_shelter_detail_vacancy);
        vacancy.setText(Integer.toString(model.getActiveShelter().getCapacityInt()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
