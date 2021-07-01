package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2;
    private CheckBox cb1, cb2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.txt1);
        ed2 = (EditText)findViewById(R.id.txt2);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        tv1 = (TextView)findViewById(R.id.tv1);
    }

    public void Calcular (View v){

        String v1 = ed1.getText().toString();
        String v2 = ed2.getText().toString();

        int Valor1 = Integer.parseInt(v1);
        int Valor2 = Integer.parseInt(v2);

        String Resultado = "";
        if(cb1.isChecked() == true){
            int Suma = Valor1 + Valor2;
            Resultado = "La Suma es = " + Suma + " / ";
        }
        if(cb2.isChecked() == true){
            int Resta = Valor1 - Valor2;
            Resultado = Resultado + "La Resta es = " + Resta;
        }
        tv1.setText(Resultado);

    }
}
