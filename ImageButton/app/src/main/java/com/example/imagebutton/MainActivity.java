package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MensajeGek (View v){
        Toast.makeText(this, "La Gekepedia de Ernesto", Toast.LENGTH_SHORT).show();
    }
    public void MensajeMano (View v){
        Toast.makeText(this, "Esto es una Mano", Toast.LENGTH_SHORT).show();
    }
}
