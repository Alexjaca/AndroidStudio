package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = (EditText)findViewById(R.id.txt_codigo);
        et_descripcion = (EditText)findViewById(R.id.txt_descripcion);
        et_precio = (EditText)findViewById(R.id.txt_precio);
    }

    //Méotdo para dar de alta los productos
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    /// consultar productos

    public void Buscar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select * from articulos where codigo =" + codigo, null);

            if (fila.moveToFirst()){
                et_descripcion.setText(fila.getString(1));
                et_precio.setText(fila.getString(2));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this, "No extiste el Articulo", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }


        }else{
            Toast.makeText(this, "Debe Ingresar un codigo para Modificarlo", Toast.LENGTH_SHORT).show();
        }

    }

    // Metodo para eliminar productos

    public void Eliminar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Codigo = et_codigo.getText().toString();

        if(!Codigo.isEmpty()){

            int Cantidad = BaseDeDatos.delete("articulos", "codigo=" + Codigo,null );
            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(Cantidad >0){
                Toast.makeText(this, "Articulo Borrado Exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El Articulo no Existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debe Ingresar un Codigo Para Poder Eliminiar", Toast.LENGTH_SHORT).show();;
        }

    }

    // Metodo para modificar producto

    public void Modificar (View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() ){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = BaseDeDatos.update("articulos", registro, "codigo =" + codigo, null);
            BaseDeDatos.close();

            if(cantidad == 1){
                Toast.makeText(this, "Articulo Modificado Exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Articulo no Existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "los Campos no deben estar Vacios", Toast.LENGTH_SHORT).show();;
        }

    }
}
