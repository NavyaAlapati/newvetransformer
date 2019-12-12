package com.mmg.vetransformers.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mmg.vetransformers.Activity_Opstions;
import com.mmg.vetransformers.R;



public class Activity_Login extends Activity {
    EditText username;
    EditText password;
    Button login;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewBinds();
    }

    private void viewBinds() {
        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login    = findViewById(R.id.ogin);
        title    = findViewById(R.id.title);
        title.setText("Login");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Login.this, Activity_Opstions.class);
                startActivity(intent);
            }
        });
    }
}
