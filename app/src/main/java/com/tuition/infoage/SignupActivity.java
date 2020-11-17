package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {
    Button signup_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup_intent = (Button) findViewById(R.id.signup_btn);
        signup_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup_activity = new Intent(getApplicationContext(), HomeAcitivity.class);
                startActivity(signup_activity);
            }});

    }
}