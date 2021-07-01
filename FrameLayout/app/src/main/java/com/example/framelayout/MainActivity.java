package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView)findViewById(R.id.imageButton);
        boton = (Button)findViewById(R.id.button);


    }

    public void Ocultar(View v){
        boton.setVisibility(View.INVISIBLE);
        imagen.setVisibility(View.VISIBLE);
    }
    public void Mostrar(View v){
        imagen.setVisibility(View.INVISIBLE);
        boton.setVisibility(View.VISIBLE);
    }
}