package com.example.crehanaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    private EditText mt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        mt = (EditText)findViewById(R.id.editTextTextMultiLine);
        btn = (Button)findViewById(R.id.buttonPrueba);


    }

    public void ListaPrueba(View v){
        ListView lv;
        ArrayList<String> lista;
        ArrayAdapter adaptador;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String query = "select * from atletas";
        Cursor cursor = bd.rawQuery(query, null);

        if(cursor != null){
            cursor.moveToFirst();
            do{
                mt.setText("\n");
                String cedula = cursor.getString(cursor.getColumnIndex("cedula"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String apellido = cursor.getString(cursor.getColumnIndex("apellido"));
                String correo = cursor.getString(cursor.getColumnIndex("correo"));
                String usuario = cursor.getString(cursor.getColumnIndex("usuario"));
                String pass = cursor.getString(cursor.getColumnIndex("clave"));
                //String sexo = cursor.getString(cursor.getColumnIndex("sexo"));

                mt.setText(cedula +" "+ nombre+" "+ apellido+" "+ correo+" "+ usuario+" "+ pass + "\n");

            }while (cursor.moveToNext());



        }


    }


}