package com.example.crehanaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText usu, pass;
    private Button ingresar, registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usu = (EditText)findViewById(R.id.editTextTextPersonName);
        pass = (EditText)findViewById(R.id.editTextTextPassword);
        ingresar = (Button)findViewById(R.id.buttonIngresar);
        registrar = (Button)findViewById(R.id.buttonRegistrarte);
    }

    public void Ingresar(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario = usu.getText().toString();
        String password = pass.getText().toString();

        if(!usuario.isEmpty() && !password.isEmpty()){
            Cursor cursor = db.rawQuery("select * from atletas where usuario = '"+usuario+"' and clave = '" +password+"'",null);

            if(cursor.moveToFirst()){

                Intent i = new Intent(this, MenuPrincipal.class);
                i.putExtra("Cedula", cursor.getString(0) );
                i.putExtra("Nombre", cursor.getString(1) );
                startActivity(i);
            }else{
                Toast.makeText(this, "Usuario o Password Incorrecto", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debe escribir Ambos campos para poder ingresar al sistema", Toast.LENGTH_SHORT).show();
        }

    }

    public void Registrar(View v){
        Intent i = new Intent (this, Registro.class);
        startActivity(i);
    }
}