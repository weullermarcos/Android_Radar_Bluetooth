package com.example.weuller.radarandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText edtSenha, edtEmail;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        mAuth = FirebaseAuth.getInstance();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtEmail.getText().toString() == null || edtSenha.getText().toString() == null)
                    return;

                mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtSenha.getText().toString()).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(! task.isSuccessful()){

                            Toast.makeText(LoginActivity.this, "Usuário ou senha inválida", Toast.LENGTH_SHORT).show();
                        }else{

                            FirebaseUser user = task.getResult().getUser();

                            if(user != null){

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                });

            }
        });

    }
}
