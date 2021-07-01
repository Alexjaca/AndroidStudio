package com.example.manejosesiones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser, txtPxw;
    Button btnLogin;
    SessionManager session;
    DialogManager cuadroDialogo = new DialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtUser = (EditText) findViewById(R.id.editTextNameUser);
        txtPxw = (EditText) findViewById(R.id.editTextPassUser);

        Toast.makeText(getApplicationContext(), "Estado de Identificacion" + session.isLogged(), Toast.LENGTH_LONG).show();
        btnLogin = (Button)findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = txtUser.getText().toString();
                String paswword = txtPxw.getText().toString();

                if(username.trim().length() > 0 && paswword.trim().length() > 0){

                    if(username.equals("alex") && paswword.equals("alex1985")){

                        session.createLoginSession("Alex", "alexjava@gmail.com");

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();;
                    }
                    else{

                        cuadroDialogo.showAlertDialog(LoginActivity.this, "Fallo", "Nombre o Pass Invalido", false);
                    }

                }
                else{
                    cuadroDialogo.showAlertDialog(LoginActivity.this, "Fallo", "Debe Ingresar los Datos", false);
                }
            }
        });

    }
}