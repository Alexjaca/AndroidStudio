package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.widget.TextView;

public class DestinoActivity extends AppCompatActivity {
    //String loco = "prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        Intent intentFinal = getIntent();
        String NombreUsuarioFinal = intentFinal.getStringExtra(ContentActivity.nombreusu);

        TextView MensajeFin = findViewById(R.id.TxtMsjFinal);
        MensajeFin.setText(NombreUsuarioFinal);

    }

}