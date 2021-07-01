package com.example.miapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText t1, t2, t3;
    private TextView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (EditText)findViewById(R.id.txt_1);
        t2 = (EditText)findViewById(R.id.txt_2);
        t3 = (EditText)findViewById(R.id.txt_3);
        v1 = (TextView)findViewById(R.id.txt_resultado);
    }

    // este es el metodo que saca el promedio

    public void Promedio(View v){
        String parcial1 = t1.getText().toString();
        String parcial2 = t2.getText().toString();
        String parcial3 = t3.getText().toString();

        int p1 = Integer.parseInt(parcial1);
        int p2 = Integer.parseInt(parcial2);
        int p3 = Integer.parseInt(parcial3);

        int promedio = (p1 + p2 + p3) / 3;

        String resultado = String.valueOf(promedio);

        if (promedio < 5 ){

            v1.setText("Estas Reprobado tu nota final fue = " + promedio);
        }else if(promedio <= 10 ){
            v1.setText("Felicidades Aprobaste tu nota final fue = " + promedio);
        }else{
            v1.setText("Las Notas Ingresadas No deben ser mayor a 10");
        }

    }
}
