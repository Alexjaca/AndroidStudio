package com.example.ernesto.tablelayout;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSuma, btnResta, btnMultiplicar, btnDividir, btnResultado, btnBorrar, btnPunto;
    protected TextView Num;
    private String Numero;
    private boolean decimal = false;
    private boolean Sum = false;
    private boolean Res = false;
    private boolean Div = false;
    private boolean Mult = false;
    Double[] numero = new Double[20];
    Double dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num = findViewById(R.id.textViewNumeros);
        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn0 = findViewById(R.id.button0);
        btn0.setOnClickListener(this);
        btnSuma = findViewById(R.id.buttonSuma);
        btnSuma.setOnClickListener(this);
        btnResta = findViewById(R.id.buttonResta);
        btnResta.setOnClickListener(this);
        btnMultiplicar = findViewById(R.id.buttonDividir);
        btnMultiplicar.setOnClickListener(this);
        btnDividir = findViewById(R.id.buttonMultiplicar);
        btnDividir.setOnClickListener(this);
        btnResultado = findViewById(R.id.buttonResultado);
        btnResultado.setOnClickListener(this);
        btnBorrar = findViewById(R.id.buttonLimpiar);
        btnBorrar.setOnClickListener(this);
        btnPunto = findViewById(R.id.buttonPunto);
        btnPunto.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        TextView pantalla = findViewById(R.id.textViewNumeros);
        int selector = v.getId();
        String x = pantalla.getText().toString();
        try{
            switch (selector){
                case R.id.button0:
                    pantalla.setText(x +"0");
                    break;

                case R.id.button1:
                    pantalla.setText(x +"1");
                    break;

                case R.id.button2:
                    pantalla.setText(x +"2");
                    break;

                case R.id.button3:
                    pantalla.setText(x +"3");
                    break;

                case R.id.button4:
                    pantalla.setText(x +"4");
                    break;

                case R.id.button5:
                    pantalla.setText(x +"5");
                    break;

                case R.id.button6:
                    pantalla.setText(x +"6");
                    break;

                case R.id.button7:
                    pantalla.setText(x +"7");
                    break;

                case R.id.button8:
                    pantalla.setText(x +"8");
                    break;

                case R.id.button9:
                    pantalla.setText(x +"9");
                    break;

                case R.id.buttonSuma:
                    Sum = true;
                    numero[0] = Double.parseDouble(x);
                    pantalla.setText("");
                    decimal = false;
                    break;

                case R.id.buttonResta:
                    Res = true;
                    numero[0] = Double.parseDouble(x);
                    pantalla.setText("");
                    decimal = false;
                    break;

                case R.id.buttonDividir:
                    Div = true;
                    numero[0] = Double.parseDouble(x);
                    pantalla.setText("");
                    decimal =false;
                    break;

                case R.id.buttonMultiplicar:
                    Mult = true;
                    numero[0] = Double.parseDouble(x);
                    pantalla.setText("");
                    decimal = false;
                    break;

                case R.id.buttonPunto:
                    if(decimal == false){
                        pantalla.setText(x+".");
                        decimal = true;
                    }else{
                        return;
                    }
                    break;

                case R.id.buttonLimpiar:
                    pantalla.setText("");
                    decimal = false;
                    break;

                case R.id.buttonResultado:
                    numero[1] = Double.parseDouble(x);
                    if(Sum == true){
                        dato = numero[0] + numero[1];
                        pantalla.setText(String.valueOf(dato));
                    }else if(Res == true){
                        dato = numero[0] - numero[1];
                        pantalla.setText(String.valueOf(dato));
                    }else if(Mult == true){
                        dato = numero[0] * numero[1];
                        pantalla.setText(String.valueOf(dato));
                    }else if (Div == true){
                        dato = numero[0] / numero[1];
                        pantalla.setText(String.valueOf(dato));
                    }
                    decimal= false;
                    Sum = false;
                    Div = false;
                    Mult = false;
                    Res = false;
                    break;
            }
        }catch (Exception e){
            pantalla.setText("ERROR");
        }

    }

}
