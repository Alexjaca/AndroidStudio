package com.example.appradioboton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText ed1, ed2;
    public TextView tv1;
    public RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.txt1);
        ed2 = (EditText)findViewById(R.id.txt2);
        tv1 = (TextView)findViewById(R.id.txt_resultado);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rb4 = (RadioButton)findViewById(R.id.rb4);
    }

    public void Calcular(View vista){

        String StringV1 = ed1.getText().toString();
        String StringV2 = ed2.getText().toString();

            int IntV1 = Integer.parseInt(StringV1);
            int IntV2 = Integer.parseInt(StringV2);

            if(rb1.isChecked() == true){
                int Suma = (IntV1 + IntV2);
                String resultado = String.valueOf(Suma);
                tv1.setText("El Valor de la Suma es = " + resultado);

            }else if(rb2.isChecked() == true){
                int Resta = IntV1 - IntV2;
                String resultado = String.valueOf(Resta);
                tv1.setText("El Valor de la Resta es = " + resultado);

            }else if(rb3.isChecked() == true){
                int Multiplicacion = IntV1 * IntV2;
                String resultado = String.valueOf(Multiplicacion);
                tv1.setText("El Valor de la Multiplicacion es = " + resultado);

            }else if(rb4.isChecked() == true){

                if(IntV2 != 0){
                    int Division = IntV1 / IntV2;
                    String resultado = String.valueOf(Division);
                    tv1.setText("El Valor de la Division es = " + resultado);
                }else{
                    Toast.makeText(this, "El Segundo Valor no Puede ser 0", Toast.LENGTH_LONG).show();
                }
            }
    }
}
