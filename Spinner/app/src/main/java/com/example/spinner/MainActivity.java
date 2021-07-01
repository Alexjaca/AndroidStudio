package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2;
    private TextView tv1;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.txt1);
        ed2 = (EditText)findViewById(R.id.txt2);
        tv1 = (TextView)findViewById(R.id.tv1);
        sp1 = (Spinner)findViewById(R.id.sp);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>( this, R.layout.spinner_item_alex, opciones);
        sp1.setAdapter(adapter);
    }

    //Metodo del boton

    public void Calcular(View v){

        String v1 = ed1.getText().toString();
        String v2 = ed2.getText().toString();

        int valor1 = Integer.parseInt(v1);
        int valor2 = Integer.parseInt(v2);

        String seleccion = sp1.getSelectedItem().toString();

        if (seleccion.equals("Sumar")){
            int calculo = valor1 + valor2;
            tv1.setText("El Resultado de la Suma es = " +calculo);
        }
        if (seleccion.equals("Restar")){
            int calculo = valor1 - valor2;
            tv1.setText("El Resultado de la Resta es = " +calculo);
        }
        if (seleccion.equals("Multiplicar")){
            int calculo = valor1 * valor2;
            tv1.setText("El Resultado de la Multiplicacion es = " +calculo);
        }
        if (seleccion.equals("Dividir")){
            int calculo = valor1 / valor2;
            tv1.setText("El Resultado de la Division es = " +calculo);
        }
    }
}
