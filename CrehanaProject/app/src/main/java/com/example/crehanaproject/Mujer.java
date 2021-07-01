package com.example.crehanaproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mujer extends AppCompatActivity {

    private EditText peso, estatura, edad;
    private TextView mensaje1, mensaje2, mensaje3, cedula;
    private Double taza,metabolica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujer);

        peso = (EditText)findViewById(R.id.editTextPeso);
        estatura = (EditText)findViewById(R.id.editTextEstatura);
        edad = (EditText)findViewById(R.id.editTextEdad);
        mensaje1 = (TextView)findViewById(R.id.textViewCalorias);
        mensaje2 = (TextView)findViewById(R.id.textViewCalorias2);
        mensaje3 = (TextView)findViewById(R.id.textViewCalorias4);
        cedula = (TextView)findViewById(R.id.textViewcedmuj);

        String Cedula = getIntent().getStringExtra("Cedula");
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


    public void CalcularHombre(View v){
        String p = peso.getText().toString();
        String e = estatura.getText().toString();
        String ed = edad.getText().toString();

        if(!p.isEmpty() && !e.isEmpty() && !ed.isEmpty()){

            double pes = Double.parseDouble(p);
            double esta =  Double.parseDouble(e);
            double eda = Double.parseDouble(ed);
            taza =  655 + (9.6*pes)+(1.85*esta)-(4.676*eda);
            float taz = taza.floatValue();
            mensaje1.setText(taz + " Calorias");
            TazaMetabolicaMujer(pes, eda);

            if(taza >= 1200  && taza < 1375){
                mensaje2.setText("Estas muy Delgada debes consumir mas proteinas para subir de peso y evitar todo tipo de acividad fisica");
            }
            else if(taza >= 1375 && taza < 1550 ){
                mensaje2.setText("Te recomendamos Hacer Ejercicio de 1 a 3 veces por Semana");
            }
            else if(taza >= 1550 && taza < 1725 ){
                mensaje2.setText("Te recomendamos Hacer Ejercicio de 3 a 5 veces por Semana");
            }
            else if(taza >= 1725 && taza < 1900 ){
                mensaje2.setText("Te recomendamos Hacer Ejercicio de 6 a 7 veces por Semana");
            }
            else if(taza >= 1900 ){
                mensaje2.setText("Te recomendamos Hacer Ejercicio 2 Veces al dia de mucha fuerza y Agotamiento");
            }
        }else{
            Toast.makeText(this, "Debe Ingresar Todos los Datos", Toast.LENGTH_SHORT).show();
        }

    }

    public void TazaMetabolicaMujer(Double peso, Double edad){

        if(edad <= 3){
            metabolica = (61*peso)-51;
            mensaje3.setText("Taza Metabolica Basal = "+ metabolica);
        }else if(edad > 3 && edad <= 10) {
            metabolica = (22.5 * peso) + 499;
            mensaje3.setText("Taza Metabolica Basal = " + metabolica);
        }
        else if(edad > 10 && edad <= 18) {
            metabolica = (12.2 * peso) + 746;
            mensaje3.setText("Taza Metabolica Basal = " + metabolica);
        }
        else if(edad > 18 && edad <= 30) {
            metabolica = (14.7 * peso) + 496;
            mensaje3.setText("Taza Metabolica Basal = " + metabolica);
        }
        else if(edad > 30 && edad <= 60) {
            metabolica = (8.7 * peso) + 829;
            mensaje3.setText("Taza Metabolica Basal = " + metabolica);
        }
        else if(edad > 60) {
            metabolica = (10.5 * peso) + 596;
            mensaje3.setText("Taza Metabolica Basal = " + metabolica);
        }

    }
}