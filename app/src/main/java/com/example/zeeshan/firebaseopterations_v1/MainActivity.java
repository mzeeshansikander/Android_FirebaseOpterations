package com.example.zeeshan.firebaseopterations_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        final EditText et_email = findViewById(R.id.et_email);
        final EditText et_password = findViewById(R.id.et_password);
        et_email.setText("zeeshan@live.com");
        et_password.setText("123456");
        Button login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                doLogin(email,password);


            }
        });

    }
    public void doLogin(final String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Sign in Error", Toast.LENGTH_LONG).show();

                }else{
                    startActivity(new Intent(MainActivity.this,Crud_Activity.class));

                }

            }
        });



    }
}
