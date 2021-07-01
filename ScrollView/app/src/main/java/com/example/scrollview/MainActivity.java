package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // POner Icono en el Accion BAr
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Seleccion(View v){
        switch (v.getId()){
            case R.id.fresas:
                Toast.makeText(this, "Estas son Fresas", Toast.LENGTH_LONG).show();
                break;

            case R.id.franbuesas:
                Toast.makeText(this, "Estas son Frambuesas", Toast.LENGTH_LONG).show();
                break;

            case R.id.uvas:
                Toast.makeText(this, "Estas son Uvas", Toast.LENGTH_LONG).show();
                break;

            case R.id.zarzamoras:
                Toast.makeText(this, "Estas son Zarzamoras", Toast.LENGTH_LONG).show();
                break;

            case R.id.bananas:
                Toast.makeText(this, "Estas son Bananas", Toast.LENGTH_LONG).show();
                break;

            case R.id.cerezas:
                Toast.makeText(this, "Estas son Cerezas", Toast.LENGTH_LONG).show();
                break;

            case R.id.kiwis:
                Toast.makeText(this, "Estas son Kiwis", Toast.LENGTH_LONG).show();
                break;

            case R.id.mangos:
                Toast.makeText(this, "Estas son Mangos", Toast.LENGTH_LONG).show();
                break;

            case R.id.manzanas:
                Toast.makeText(this, "Estas son Manzanas", Toast.LENGTH_LONG).show();
                break;

            case R.id.melon:
                Toast.makeText(this, "Estas son Melones", Toast.LENGTH_LONG).show();
                break;

            case R.id.naranjas:
                Toast.makeText(this, "Estas son Naranjas", Toast.LENGTH_LONG).show();
                break;

            case R.id.pera:
                Toast.makeText(this, "Estas son Peras", Toast.LENGTH_LONG).show();
                break;

            case R.id.pina:
                Toast.makeText(this, "Estas son Piñas", Toast.LENGTH_LONG).show();
                break;

            case R.id.sandia:
                Toast.makeText(this, "Estas son Sandias", Toast.LENGTH_LONG).show();
                break;

        }
    }
}