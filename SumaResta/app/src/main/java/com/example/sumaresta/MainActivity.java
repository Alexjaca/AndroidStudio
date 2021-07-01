package com.example.sumaresta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Num1, Num2;
    private RadioButton ChSumar, ChRestar, ChMultiplicar, ChDividir;
    private Button btnCalc;
    private TextView txtViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.editTextNum1);
        Num2 = findViewById(R.id.editTextNum2);
        txtViewResult = findViewById(R.id.textViewResultado);
        ChSumar = findViewById(R.id.radioButtonSumar);
        ChRestar = findViewById(R.id.radioButtonRestar);
        ChMultiplicar = findViewById(R.id.radioButtonMultiplicar);
        ChDividir = findViewById(R.id.radioButtonDividir);
    }

    public void Calcular(View view){
        String Numer1 = Num1.getText().toString();
        String Numer2 = Num2.getText().toString();

        int Numero1 = Integer.parseInt(Numer1);
        int Numero2 = Integer.parseInt(Numer2);

        if(Numer1.equals("") || Numer2.equals("")){

            Toast.makeText(this, "Uno de los Campos esta vacio", Toast.LENGTH_LONG).show();
        }
        else {

            if (ChSumar.isChecked() == true) {
                int Suma = Numero1 + Numero2;
                txtViewResult.setText(Suma + "");
            } else if (ChRestar.isChecked() == true) {
                int Resta = Numero1 - Numero2;
                String Resultado = String.valueOf(Resta);
                txtViewResult.setText(Resultado);
            } else if (ChMultiplicar.isChecked() == true) {
                int Multi = Numero1 * Numero2;
                txtViewResult.setText(Multi + "");
            } else if (ChDividir.isChecked() == true) {
                if (Numero2 != 0) {
                    int Divi = Numero1 / Numero2;
                    txtViewResult.setText(Divi + "");
                } else {
                    Toast.makeText(this, "El Segundo Numero debe ser mayor que 0", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Debe Seleccionar una Opcion para hacer la Operacion", Toast.LENGTH_LONG).show();
            }
        }

    }
}