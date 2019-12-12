package com.mmg.vetransformers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mmg.vetransformers.details.Activity_Details;
import com.mmg.vetransformers.registration.Activity_Registration;

public class Activity_Opstions extends Activity {
    Button registration;
    Button details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        viewBinds();
    }

    private void viewBinds() {
        registration = findViewById(R.id.registration);
        details      = findViewById(R.id.details);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Opstions.this, Activity_Registration.class);
                startActivity(intent);
            }
        });

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Opstions.this, Activity_Details.class);
                startActivity(intent);
            }
        });
    }
}
