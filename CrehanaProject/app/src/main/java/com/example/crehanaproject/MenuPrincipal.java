package com.example.crehanaproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {

    private TextView mensaje, cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        mensaje = (TextView)findViewById(R.id.textViewSaludo);
        cedula = (TextView)findViewById(R.id.ced);


        String Nombre = getIntent().getStringExtra("Nombre");
        String Cedula = getIntent().getStringExtra("Cedula");
        mensaje.setText("Hola como estas " + Nombre + " Bienvenid@");
        cedula.setText(Cedula);
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.ItemPerfil){
            Intent intent = new Intent(this, Perfil.class);
            intent.putExtra("Identificacion", cedula.getText());
            startActivity(intent);

        }else if( id == R.id.ItemSalir){
            Salir();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Salir(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mensaje de Confirmación");
        builder.setMessage("Seguro desea Salir?");
        Intent intent = new Intent(this, MainActivity.class);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    public void Mujer(View v){
        Intent i = new Intent(this, Mujer.class);
        i.putExtra("Cedula", cedula.getText());
        startActivity(i);
    }

    public void Hombre(View v){
        Intent i = new Intent(this, Hombre.class);
        i.putExtra("Cedula", cedula.getText());
        startActivity(i);
    }
}