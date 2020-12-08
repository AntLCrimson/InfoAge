package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

               /* MFBA.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignupActivity.this,
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
            }*/



                Intent signin_activity = new Intent(getApplicationContext(), HomeAcitivity.class);
                startActivity(signin_activity);
            }
        });
    }
}