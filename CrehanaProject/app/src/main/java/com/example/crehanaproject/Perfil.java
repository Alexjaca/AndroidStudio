package com.example.crehanaproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil extends AppCompatActivity {

    private TextView cedula, usuario, nombre, apellido, correo, tvEliminar, tvEditar, tvPassword, tvSexo;
    private ImageButton btnEditar, btnEliminar, btnConfirmar;
    private EditText txtNombre, txtApellido, txtCorreo, txtUsuario, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        cedula = (TextView)findViewById(R.id.textViewCedula);
        nombre = (TextView)findViewById(R.id.textViewNombre);
        usuario = (TextView)findViewById(R.id.textViewUsuario);
        apellido = (TextView)findViewById(R.id.textViewApellido);
        correo = (TextView)findViewById(R.id.textViewCorreo);
        tvEliminar = (TextView)findViewById(R.id.textViewEliminar);
        tvEditar = (TextView)findViewById(R.id.textViewEditar);
        tvPassword = (TextView)findViewById(R.id.textViewPass);
        btnEditar = (ImageButton)findViewById(R.id.imageButtonEditar);
        btnEliminar = (ImageButton)findViewById(R.id.imageButtonEliminar);
        btnConfirmar = (ImageButton)findViewById(R.id.imageButtonEdit);
        txtNombre = (EditText)findViewById(R.id.editTextName);
        txtApellido = (EditText)findViewById(R.id.editTextApe);
        txtCorreo = (EditText)findViewById(R.id.editTextCorr);
        txtUsuario = (EditText)findViewById(R.id.editTextUsua);
        txtPassword = (EditText)findViewById(R.id.editTextPass);
        //tvSexo = (TextView) findViewById(R.id.textViewSexo);


        String ci = getIntent().getStringExtra("Identificacion");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from atletas where cedula ='" + ci +"'", null);
        



        if(cursor.moveToFirst()){
            cedula.setText(cursor.getString(0));
            nombre.setText(cursor.getString(1));
            apellido.setText(cursor.getString(2));
            correo.setText(cursor.getString(3));
            usuario.setText(cursor.getString(4));
            //tvSexo.setText(cursor.getString(6));
        }else{
            Toast.makeText(this, "Error en la Base de Datos", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaEliminar(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mensaje de Confirmación");
        builder.setMessage("Seguro desea Eliminar este Atleta?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            EliminarAtleta();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();

    }

    public void ConsultaEditar(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mensaje de Confirmación");
        builder.setMessage("Seguro desea Editar los Datos de este Atleta?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Confirmar();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();

    }

    public void EliminarAtleta(){
        String c = cedula.getText().toString();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(!c.isEmpty()){
            int borrar = db.delete("atletas","cedula =" + c, null);
            db.close();

            if(borrar > 0){
                Toast.makeText(this, "Atleta Eliminado con exito", Toast.LENGTH_SHORT).show();

                nombre.setText("");
                apellido.setText("");
                correo.setText("");
                usuario.setText("");
                Intent i = new Intent(this, Login.class);
                startActivity(i);
            }else{
                Toast.makeText(this,"Error al Eliminar Atleta", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void ModificarAtleta(View v){

        String c = cedula.getText().toString();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from atletas where cedula ='" + c +"'", null);

        if(cursor.moveToFirst()){
            nombre.setVisibility(View.INVISIBLE);
            apellido.setVisibility(View.INVISIBLE);
            correo.setVisibility(View.INVISIBLE);
            usuario.setVisibility(View.INVISIBLE);
            tvEditar.setVisibility(View.INVISIBLE);
            tvEliminar.setVisibility(View.INVISIBLE);
            btnEliminar.setVisibility(View.INVISIBLE);
            btnEditar.setVisibility(View.INVISIBLE);
            btnConfirmar.setVisibility(View.VISIBLE);
            tvPassword.setVisibility(View.VISIBLE);
            txtPassword.setVisibility(View.VISIBLE);
            txtUsuario.setVisibility(View.VISIBLE);
            txtCorreo.setVisibility(View.VISIBLE);
            txtNombre.setVisibility(View.VISIBLE);
            txtApellido.setVisibility(View.VISIBLE);

            txtNombre.setText(cursor.getString(1));
            txtApellido.setText(cursor.getString(2));
            txtCorreo.setText(cursor.getString(3));
            txtUsuario.setText(cursor.getString(4));
            txtPassword.setText(cursor.getString(5));
        }else{
            Toast.makeText(this, "Error en la Base de Datos", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }


    public void Confirmar(){

        String c = cedula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String correo = txtCorreo.getText().toString();
        String pass = txtPassword.getText().toString();
        String usuario = txtUsuario.getText().toString();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from atletas where cedula ='" + c +"'", null);

        if(cursor.moveToFirst()){
            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("apellido", apellido);
            valores.put("correo", correo);
            valores.put("usuario", usuario);
            valores.put("clave", pass);

            int cantidad = db.update("atletas", valores,"cedula = " +c, null);
            db.close();

            if(cantidad == 1 ){
                Toast.makeText(this, "Datos del atleta Modificado con Exito", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Login.class);
                startActivity(i);
            }else{
                Toast.makeText(this, "Error al Querer Modificar Datos del  Atleta", Toast.LENGTH_SHORT).show();
            }

        }


    }


    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.ItemPerfil){
            Toast.makeText(this, "Estas en tu Perfil", Toast.LENGTH_SHORT).show();

        }else if( id == R.id.ItemSalir){
            Salir();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Salir(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mensaje de Confirmación");
        builder.setMessage("Seguro desea Salir?");
        Intent intent = new Intent(this, MainActivity.class);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }
}