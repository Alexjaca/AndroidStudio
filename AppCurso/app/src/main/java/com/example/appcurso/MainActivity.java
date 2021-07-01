package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textoNombre;
    private Button botonNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNombre = findViewById(R.id.editTextPrincipal);
        botonNombre = findViewById(R.id.buttonPrincipal);

        botonNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombre = textoNombre.getText().toString();
                StartStory(Nombre);
            }
        });
    }

    private void StartStory(String nombre) {
        Intent intent = new Intent(this,SegundoActivity.class);
        intent.putExtra("Nombre", nombre);
        startActivity(intent);
    }
}