package com.example.practicachecbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtViewResult;
    private EditText Num1, Num2;
    private CheckBox ChSumar, ChRestar;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.editTextNum1);
        Num2 = findViewById(R.id.editTextNum2);
        ChSumar = findViewById(R.id.checkBoxSumar);
        ChRestar = findViewById(R.id.checkBoxRestar);
        btnCalc = findViewById(R.id.buttonCalcular);
        txtViewResult = findViewById(R.id.textViewResultado);

    }

    public void Operacion(View view){
        String resultado = "";
        String n1 = Num1.getText().toString();
        String n2 = Num2.getText().toString();

        if(n1.equals("") || n2.equals("")){
            Toast.makeText(this, "DEBE INGRESAR AMBOS NUMEROS " , Toast.LENGTH_LONG).show();
        }else {

            int Numero1 = Integer.parseInt(n1);
            int Numero2 = Integer.parseInt(n2);

            if (ChSumar.isChecked() == true) {

                int Suma = Numero1 + Numero2;
                resultado = " El Resultado de la Suma es = " + Suma + " , ";

            } if (ChRestar.isChecked() == true) {

                int resta = Numero1 - Numero2;
                resultado ="" + resultado + " El Resultado de la Resta es = " + resta + "";
                //txtViewResult.setText("El Resultado de la Resta es = " + resta + "");
            } else if (ChSumar.isChecked() == false && ChRestar.isChecked() == false) {
                Toast.makeText(this, "DEBE ESCOGER UNA OPCCION O AMBAS OPCIONES ", Toast.LENGTH_LONG).show();
            }

        }
        txtViewResult.setText(resultado);
    }



}