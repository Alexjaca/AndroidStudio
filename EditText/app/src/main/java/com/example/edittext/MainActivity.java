package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.txtNombre);
        tv2 = (TextView)findViewById(R.id.txtPass);
    }

    public void Registrar (View v){

        String stv1 = tv1.getText().toString();
        String stv2 = tv2.getText().toString();

        if(stv1.equals("")){
            Toast.makeText(this, "Debe Ingresar el Nombre", Toast.LENGTH_LONG).show();
        }else if(stv2.length() == 0){
            Toast.makeText(this, "Debe Ingresar una Contraseña", Toast.LENGTH_SHORT).show();;
        }else{
            Toast.makeText(this , "Usuario Registrado Correctamente", Toast.LENGTH_LONG).show();;
        }


    }
}
