package com.example.frutiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Nivel4 extends AppCompatActivity {

    private TextView tv_nombre, tv_score;
    private ImageView iv_Auno, iv_Ados, iv_vidas, iv_signo;
    private EditText et_respuesta;
    private MediaPlayer mp, mp_great, mp_bad;

    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas= 3;
    String nombre_jugador, string_score, string_vidas;

    String numero[]= {"cero","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__nivel4);

        Toast.makeText(this,"Nivel 4 - Sumas y Restas", Toast.LENGTH_SHORT).show();

        tv_nombre = (TextView)findViewById(R.id.textView_nombre);
        tv_score = (TextView)findViewById(R.id.textView_score);
        iv_vidas = (ImageView)findViewById(R.id.imageView_vidas);
        iv_Auno = (ImageView)findViewById(R.id.imageView_Num);
        iv_Ados = (ImageView)findViewById(R.id.imageView_Num1);
        iv_signo = (ImageView)findViewById(R.id.imageView_signo);
        et_respuesta = (EditText)findViewById(R.id.editText_Resultado);

        nombre_jugador = getIntent().getStringExtra("jugador");
        tv_nombre.setText("Jugador: "+nombre_jugador);

        string_score = getIntent().getStringExtra("score");
        score = Integer.parseInt(string_score);
        tv_score.setText("Score: "+score);

        string_vidas = getIntent().getStringExtra("vidas");
        vidas = Integer.parseInt(string_vidas);
        if(vidas == 3){
            iv_vidas.setImageResource(R.drawable.tresvidas);
        }if(vidas == 2){
            iv_vidas.setImageResource(R.drawable.dosvidas);
        }if(vidas == 1){
            iv_vidas.setImageResource(R.drawable.unavida);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        mp = MediaPlayer.create(this, R.raw.goats);
        mp.start();
        mp.setLooping(true);

        mp_great = MediaPlayer.create(this, R.raw.wonderful);
        mp_bad = MediaPlayer.create(this, R.raw.bad);

        NumAleatorio();
    }

    public void Comprarar(View view){

        String respuesta = et_respuesta.getText().toString();

        if(!respuesta.equals("")){

            int resptesta_jugador = Integer.parseInt(respuesta);
            if(resultado == resptesta_jugador){
                mp_great.start();
                score++;
                tv_score.setText("Score: " + score);
                et_respuesta.setText("");
                BaseDeDatos();

            }else{

                mp_bad.start();
                vidas--;
                BaseDeDatos();
                switch (vidas){
                    case 3:
                        iv_vidas.setImageResource(R.drawable.tresvidas);
                        break;
                    case 2:
                        Toast.makeText(this, "Te quedan 2 Manzanas", Toast.LENGTH_SHORT).show();
                        iv_vidas.setImageResource(R.drawable.dosvidas);
                        break;
                    case 1:
                        Toast.makeText(this, "Te queda 1 Manzana1", Toast.LENGTH_SHORT).show();
                        iv_vidas.setImageResource(R.drawable.unavida);
                        break;
                    case 0:
                        Toast.makeText(this, "Te quedaste sin Manzanas", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(this, MainActivity.class);
                        startActivity(i);
                        finish();
                        mp.stop();
                        mp.release();
                        break;
                }
                et_respuesta.setText("");
            }

            NumAleatorio();

        }else{
            Toast.makeText(this, "Escribe tu Respuesta", Toast.LENGTH_SHORT).show();
        }


    }

    public void NumAleatorio(){
        if(score <= 39){

            numAleatorio_uno = (int) (Math.random() * 10);
            numAleatorio_dos = (int) (Math.random() * 10);

            if(numAleatorio_uno >= 0 && numAleatorio_uno <= 4){
                resultado = numAleatorio_uno + numAleatorio_dos;
                iv_signo.setImageResource(R.drawable.adicion);
            }else{
                resultado = numAleatorio_uno - numAleatorio_dos;
                iv_signo.setImageResource(R.drawable.resta);
            }


            if(resultado >= 0){

                for(int i = 0; i < numero.length; i++){
                    int id = getResources().getIdentifier(numero[i], "drawable", getPackageName());
                    if(numAleatorio_uno == i){
                        iv_Auno.setImageResource(id);
                    }if(numAleatorio_dos == i){
                        iv_Ados.setImageResource(id);
                    }
                }

            }else{
                NumAleatorio();
            }


        }else{
            Intent i = new Intent(this, MainActivity_Nivel5.class);

            string_score = String.valueOf(score);
            string_vidas = String.valueOf(vidas);
            i.putExtra("jugador", nombre_jugador);
            i.putExtra("score", string_score);
            i.putExtra("vidas", string_vidas);
            startActivity(i);
            finish();
            mp.stop();
            mp.release();

        }
    }

    public void BaseDeDatos(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        Cursor consulta = BD.rawQuery("select * from puntaje where score = (select max(score) from puntaje)", null);
        if(consulta.moveToFirst()){
            String temp_nombre = consulta.getString(0);
            String temp_score = consulta.getString(1);

            int bestScore = Integer.parseInt(temp_score);

            if(score > bestScore){
                ContentValues modificacion = new ContentValues();
                modificacion.put("nombre", nombre_jugador);
                modificacion.put("score", score);

                BD.update("puntaje", modificacion, "score=" + bestScore, null);
            }
            BD.close();
        }else{
            ContentValues insertar = new ContentValues();
            insertar.put("nombre", nombre_jugador);
            insertar.put("score", score);

            BD.insert("puntaje", null, insertar);
            BD.close();

        }
    }

    @Override
    public void onBackPressed(){

    }
}