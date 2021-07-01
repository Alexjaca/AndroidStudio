package com.example.crehanaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnimagen;
    private Button btnprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnimagen = (ImageButton)findViewById(R.id.imageButtonPrincipal);
        btnprincipal = (Button)findViewById(R.id.buttonPrincipal);

    }

    public void Comenzar(View v){

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }

    public void Saludo(View v){
        Toast.makeText(this, "Desde EntrenaMix te invitamos a mantenerte en forma", Toast.LENGTH_LONG).show();
    }
}