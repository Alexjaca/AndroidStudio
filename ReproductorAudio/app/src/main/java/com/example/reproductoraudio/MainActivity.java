package com.example.reproductoraudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play;
    SoundPool sp;
    int sonido_de_reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.buttonSound);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);

        sonido_de_reproduccion = sp.load(this, R.raw.sound_short, 1);

    }

    public void AudioSoundPool(View v){
        sp.play(sonido_de_reproduccion, 1,1,1,0, 0);
    }

    public void AudioMediaPLayer(View v){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.sound_long);
        mp.start();

    }
}