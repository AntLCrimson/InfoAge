package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    Button signup_intent;
    String name, email, password, reTypePs;
    EditText nameInput, emailInput, passwordInput, passwordInputReType;
    FirebaseAuth MFBA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MFBA = FirebaseAuth.getInstance();

        nameInput = findViewById(R.id.editTextTextPersonName);
        emailInput = findViewById(R.id.editTextTextPersonEmail);
        passwordInput = findViewById(R.id.editTextTextPassword);
        passwordInputReType = findViewById(R.id.editTextTextPassword2);

        signup_intent = (Button) findViewById(R.id.signup_btn);
        signup_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup_activity = new Intent(getApplicationContext(), HomeAcitivity.class);
                startActivity(signup_activity);



                name = nameInput.getText().toString();
                email = emailInput.getText().toString();
                password = passwordInput.getText().toString();
                reTypePs = passwordInputReType.getText().toString();

                if(password.isEmpty()){
                        passwordInput.setError("Password field is empty");
                        passwordInput.requestFocus();
                }

                else if(email.isEmpty()){
                    emailInput.setError("Email field is empty");
                    emailInput.requestFocus();
                }

                else if(name.isEmpty()){
                    nameInput.setError("Name field is empty");
                    nameInput.requestFocus();
                }

                else if(reTypePs.isEmpty()){
                    passwordInputReType.setError("Password field is empty");
                    passwordInputReType.requestFocus();
                }

                else if(reTypePs != password){
                    passwordInputReType.setError("Passwords do not match up");
                    passwordInputReType.requestFocus();
                    passwordInput.requestFocus();
                }

                //Make combos of fields empty

               /* MFBA.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignupActivity.this,
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){

                }

                )*/



            }});

    }
}