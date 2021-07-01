package com.example.mysegundaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoPrincipal;
    private String MensajePeincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoPrincipal = findViewById(R.id.textoPrincipal);
        textoPrincipal.setText(MensajePeincipal);
        Log.i("David", "Todo Funciono");
    }
}