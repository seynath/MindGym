package com.example.mindgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//public class LoginActivity extends AppCompatActivity {
//
//    private EditText useredit, pswdedit;
//    private Button loginbutton;
//    private Button register;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        initView();
//
//        register = (Button) findViewById(R.id.reg);
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//            }
//        });
//
//    }

//    private void initView() {
//
//        useredit = findViewById(R.id.loginuser);
//        pswdedit = findViewById(R.id.loginpswd);
//        loginbutton = findViewById(R.id.loginbutton);
//
//        loginbutton.setOnClickListener(v -> {
//            if (useredit.getText().toString().isEmpty() || pswdedit.getText().toString().isEmpty()){
//                Toast.makeText(LoginActivity.this, "Please fill your username and password", Toast.LENGTH_SHORT).show();
//            } else if (useredit.getText().toString().equals("test") && pswdedit.getText().toString().equals("test")) {
//                startActivity(new Intent(LoginActivity.this, Home.class));
//            } else {
//                Toast.makeText(LoginActivity.this, "Your username and password is not correct", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//}

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button loginbutton;
    private Button register;
    private FirebaseAuth mAuth;



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.loginuser);
        editTextPassword = findViewById(R.id.loginpswd);
        loginbutton = findViewById(R.id.loginbutton);


        register = (Button) findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String email = String.valueOf(editTextEmail.getText());
//                String password = String.valueOf(editTextPassword.getText());
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    editTextEmail.setError("Please fill in the Email");
                    Toast.makeText(LoginActivity.this, "Please Fill in the Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    editTextPassword.setError("Please fill in the Password  ");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(LoginActivity.this, "Signin Completed", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), Home.class);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

    }
}