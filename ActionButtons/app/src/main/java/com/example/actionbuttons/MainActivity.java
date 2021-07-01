package com.example.actionbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para mostrar los botones accion

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuacciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.opcion1){
            Toast.makeText(this, "Opcion1", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.opcion2){
            Toast.makeText(this, "Opcion2", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ItemCompartir){
            Toast.makeText(this, "Compartir", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ItemBuscar){
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}