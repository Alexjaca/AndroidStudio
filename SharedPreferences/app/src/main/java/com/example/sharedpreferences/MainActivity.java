package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.txtEmail);

        SharedPreferences pref = getSharedPreferences( "datos", Context.MODE_PRIVATE);
        ed1.setText(pref.getString("mail", ""));
    }

    public void Guardar(View v){

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferencias.edit();
        edit.putString("mail", ed1.getText().toString());
        edit.commit();
        finish();


    }
}
