package com.example.crehanaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText nomb, ape, correo, usuario, pass, pass2, ced;
    private RadioButton RadioMasculino, RadioFemenino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nomb = (EditText)findViewById(R.id.editTextNombres);
        ape = (EditText)findViewById(R.id.editTextApellidos);
        correo = (EditText)findViewById(R.id.editTextEmail);
        usuario = (EditText)findViewById(R.id.editTextUsuario);
        pass = (EditText)findViewById(R.id.editTextClave);
        pass2 = (EditText)findViewById(R.id.editTextClave2);
        ced = (EditText)findViewById(R.id.editTextCedula);


    }

    public void Registra(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombres = nomb.getText().toString();
        String apellidos = ape.getText().toString();
        String email = correo.getText().toString();
        String usu = usuario.getText().toString();
        String password = pass.getText().toString();
        String password2 = pass2.getText().toString();
        String cedula = ced.getText().toString();


            if (!nombres.isEmpty() && !apellidos.isEmpty() && !email.isEmpty() && !usu.isEmpty() && !password.isEmpty() && !cedula.isEmpty() && !password2.isEmpty()) {

                if(password.equals(password2)){

                    Cursor cursor = bd.rawQuery("select * from atletas where cedula =" + cedula, null);

                    if (cursor.moveToFirst()) {
                        Toast.makeText(this, "Usuario ya se encuenta registrado", Toast.LENGTH_LONG).show();
                    } else {

                        ContentValues registro = new ContentValues();
                        registro.put("cedula", cedula);
                        registro.put("nombre", nombres);
                        registro.put("apellido", apellidos);
                        registro.put("correo", email);
                        registro.put("usuario", usu);
                        registro.put("clave", password);

                        bd.insert("atletas", null, registro);
                        bd.close();

                        nomb.setText("");
                        ced.setText("");
                        ape.setText("");
                        correo.setText("");
                        usuario.setText("");
                        pass.setText("");
                        pass2.setText("");
                        ced.setText("");

                        Toast.makeText(this, "Felicitaciones " + nombres + " Te has registrado con Exito", Toast.LENGTH_LONG).show();
                        Intent in = new Intent(this, Login.class);
                        startActivity(in);
                    }

                }else{

                    Toast.makeText(this, "Los Password no coinciden", Toast.LENGTH_SHORT).show();

                }

            }
            else {
                Toast.makeText(this, "Debes llenar todos los Campos para poder Registrarte", Toast.LENGTH_LONG).show();
            }
    }


    public void Loguear(View v){
        Intent i =  new Intent(this, Login.class);
        startActivity(i);
    }
}