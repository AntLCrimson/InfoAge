package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button signinbtn, signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signinbtn = (Button)findViewById(R.id.signin);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signin_activity = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(signin_activity);
            }
    });
        signupbtn = (Button)findViewById(R.id.signup);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup_activity = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(signup_activity);
            }
        });
}}