package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContentActivity extends AppCompatActivity {
    public static final String nombreusu = "Prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    public void enviarNombre(View v){
        Intent intentEnviar = new Intent(this, DestinoActivity.class);
        EditText nombreUsuario = findViewById(R.id.IdNombre);
        String NombreUsuarioMensaje = nombreUsuario.getText().toString();
        intentEnviar.putExtra(nombreusu, NombreUsuarioMensaje);

    }
}