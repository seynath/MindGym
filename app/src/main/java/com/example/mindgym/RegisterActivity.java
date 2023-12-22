package com.example.mindgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonReg;
    private EditText  editTextEmail, editTextPassword;
    private FirebaseAuth mAuth;
    private TextView textViewLogin;

    private ImageView imageView;

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
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        buttonReg = (Button) findViewById(R.id.buttonReg);
        imageView = (ImageView) findViewById(R.id.backreg);

        editTextEmail = (EditText) findViewById(R.id.email2);
        editTextPassword = (EditText) findViewById(R.id.pswd2);
        textViewLogin = (TextView) findViewById(R.id.Textlogin);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        buttonReg.setOnClickListener(v -> {
//                String username = String.valueOf(editTextUsername.getText());
//                String email = String.valueOf(editTextEmail.getText());
//                String password = String.valueOf(editTextPassword.getText());

            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();


            if(TextUtils.isEmpty(email)){
                editTextEmail.setError("Please fill in the Email");
                return;
            }
            if(TextUtils.isEmpty(password)){
                editTextPassword.setError("Please fill in the Passwords  ");
                return;
            }

//                if( username.equals("") || email.equals("") || password.equals("") ){
//                    editTextUsername.setError("Please fill in the blank");
//                    editTextEmail.setError("Please fill in the blank");
//                    editTextPassword.setError("Please fill in the blank");
//                } else {
//                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(  new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                Toast.makeText(RegisterActivity.this, "Account Created",
                                        Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


        });
    }
}