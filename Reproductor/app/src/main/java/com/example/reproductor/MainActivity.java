package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button play_pause, btn_repetir;
    private MediaPlayer mp;
    private ImageView iv;
    private int repetir = 2, posicion = 0;
    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.buttonPlay);
        btn_repetir = (Button)findViewById(R.id.buttonRepetir);
        iv = (ImageView)findViewById(R.id.imageView);

        vectormp[0]= MediaPlayer.create(this, R.raw.race);
        vectormp[1]= MediaPlayer.create(this, R.raw.sound);
        vectormp[2]= MediaPlayer.create(this, R.raw.tea);

    }

    // Medoto para el PLay pause

    public void PlayPause(View v){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();

        }
    }

    // Metodo Boton Stop

    public void Stop(View v){

        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0]= MediaPlayer.create(this, R.raw.race);
            vectormp[1]= MediaPlayer.create(this, R.raw.sound);
            vectormp[2]= MediaPlayer.create(this, R.raw.tea);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    // Metodo Repetir pistas dd Audio

    public void Repetir(View v){

        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        }else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //Metodo para saltar la siguiente cancion
    public void Siguiente (View v){

        if(posicion < vectormp.length -1){

            if(vectormp[posicion].isPlaying()){
               vectormp[posicion].stop();
               posicion ++;
               vectormp[posicion].start();

               if(posicion == 0){
                   iv.setBackgroundResource(R.drawable.portada1);
               }else if(posicion == 1){
                   iv.setBackgroundResource(R.drawable.portada2);
               }else if(posicion == 2){
                   iv.setBackgroundResource(R.drawable.portada3);
               }

            }else{
                posicion++;

                if(posicion == 0){
                    iv.setBackgroundResource(R.drawable.portada1);
                }else if(posicion == 1){
                    iv.setBackgroundResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setBackgroundResource(R.drawable.portada3);
                }

            }

        }else{
            Toast.makeText(this, "No hay mas Canciones", Toast.LENGTH_SHORT).show();
        }
    }

    // Metido para cancion anterior

    public void Anterior(View v){

        if(posicion >= 1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]= MediaPlayer.create(this, R.raw.race);
                vectormp[1]= MediaPlayer.create(this, R.raw.sound);
                vectormp[2]= MediaPlayer.create(this, R.raw.tea);
                posicion --;

                if(posicion == 0){
                    iv.setBackgroundResource(R.drawable.portada1);
                }else if(posicion == 1){
                    iv.setBackgroundResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setBackgroundResource(R.drawable.portada3);
                }

                vectormp[posicion].start();

            }else{
                posicion --;

                if(posicion == 0){
                    iv.setBackgroundResource(R.drawable.portada1);
                }else if(posicion == 1){
                    iv.setBackgroundResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setBackgroundResource(R.drawable.portada3);
                }
            }

        }else{
            Toast.makeText(this, "No hay mas Canciones", Toast.LENGTH_SHORT).show();
        }

    }
}