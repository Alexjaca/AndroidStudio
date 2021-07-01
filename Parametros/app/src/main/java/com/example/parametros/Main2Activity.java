package com.example.parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView)findViewById(R.id.tvNombre);

        String dato = getIntent().getStringExtra("dato");
        tv1.setText("Bienvenido " + dato);
    }

    public void Regresar(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
