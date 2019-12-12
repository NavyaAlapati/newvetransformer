package com.mmg.vetransformers.registration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.mmg.vetransformers.R;
import com.mmg.vetransformers.database.DBHelper;

public class Activity_Registration extends Activity {
    EditText name;
    EditText mobile_number;
    EditText amount_paid;
    EditText other_details;
    Button registration_button;
    TextView title;
    TextView email;
    DBHelper  dbHelper;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        dbHelper = new DBHelper(this);
        viewBinds();

    }

    private void viewBinds() {
        linearLayout        =  findViewById(R.id.linear);
        name                = findViewById(R.id.name);
        mobile_number       = findViewById(R.id.mobile_number);
        amount_paid         = findViewById(R.id.amount_paid);
        email               = findViewById(R.id.email);
        other_details       = findViewById(R.id.other_details);
        registration_button = findViewById(R.id.registration_button);
        title               = findViewById(R.id.title);
        title.setText("Registration");
        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = name.getText().toString();
                String mobile   = mobile_number.getText().toString();
                String amount   = amount_paid.getText().toString();
                String emailid  = email.getText().toString();
                String other    = other_details.getText().toString();
                if(fullname!=null&&mobile!=null&&amount!=null)
                {
                    dbHelper.insertContact(fullname,mobile,emailid,amount,other);

                    Snackbar snackbar = Snackbar.make(linearLayout, "Data Inserted", Snackbar.LENGTH_LONG);
                    snackbar.show();
                      name.setText("");
                      mobile_number.setText("");
                      amount_paid.setText("");
                      email.setText("");
                      other_details.setText("");
                }else {
                    Snackbar snackbar = Snackbar.make(linearLayout, "Data Not Inserted", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }
}
