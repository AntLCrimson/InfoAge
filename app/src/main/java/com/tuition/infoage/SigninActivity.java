package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {
    TextView signup_intent;
    Button signin_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //signup_intent = (TextView)findViewById(R.id.signup_intent);
        signup_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup_activity = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(signup_activity);
            }});
        signin_intent = (Button) findViewById(R.id.signup_btn);
        signin_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signin_activity = new Intent(getApplicationContext(), HomeAcitivity.class);
                startActivity(signin_activity);
            }
        });
    }
}