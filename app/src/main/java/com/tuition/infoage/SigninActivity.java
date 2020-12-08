package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    TextView signup_intent;
    Button signin_intent;
    EditText nameEditText, passwordEditText;
    CheckBox forgotPasswordCheckBox;
    FirebaseAuth MFBA;

    String name, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        nameEditText = findViewById(R.id.editTextTextPersonNameSignIn);
        passwordEditText = findViewById(R.id.editTextTextPasswordSignIn);



        signup_intent = (TextView)findViewById(R.id.signup_intent);
        signup_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup_activity = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(signup_activity);
            }});
        signin_intent = (Button) findViewById(R.id.signup_btn);
        signin_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            name = nameEditText.getText().toString();
            password = passwordEditText.getText().toString();

                if(password.isEmpty()){
                    passwordEditText.setError("Password field is empty");
                    passwordEditText.requestFocus();
                }

                else if(name.isEmpty()){
                    nameEditText.setError("Password field is empty");
                    nameEditText.requestFocus();
                }

                else if(!password.isEmpty() && !name.isEmpty()){

                    
                }





                Intent signin_activity = new Intent(getApplicationContext(), HomeAcitivity.class);
                startActivity(signin_activity);
            }
        });
    }
}