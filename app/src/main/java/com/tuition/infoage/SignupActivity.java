package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    Button signup_intent;
    CheckBox acceptBtn;
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
        acceptBtn = findViewById(R.id.checkBoxSignUp);

        signup_intent = (Button) findViewById(R.id.signup_btn);
        signup_intent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent signup_activity = new Intent(getApplicationContext(), HomeAcitivity.class);
                //startActivity(signup_activity);



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

                else if(!acceptBtn.isChecked()){
                    acceptBtn.setError("Terms and conditions aren't agreed");
                    acceptBtn.requestFocus();
                }

                else if(!(email.isEmpty() && password.isEmpty()) && (name.isEmpty() && reTypePs.isEmpty() && (!acceptBtn.isChecked()))){
                MFBA.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignupActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    Toast.makeText(SignupActivity.this, "Sign up unsuccessful, try again", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                }
                            }
                        }
                );}
                else{
                    Toast.makeText(SignupActivity.this, "An Error Occurred", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}