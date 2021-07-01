package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcurso.modelos.Contenidos;
import com.example.appcurso.modelos.Pagina;

public class SegundoActivity extends AppCompatActivity {

    private String mNombre;

    private Contenidos mContenidos = new Contenidos();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mOpcion1;
    private Button mOpcion2;
    private Pagina mPaginaActiva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        Intent intent = getIntent();
        mNombre = intent.getStringExtra("Nombre");

        mImageView = (ImageView)findViewById(R.id.imageViewPrincipal);
        mTextView = (TextView)findViewById(R.id.textViewPrincipal);
        mOpcion1 = (Button) findViewById(R.id.buttonPrincipal1);
        mOpcion2 = (Button)findViewById(R.id.buttonPrincipal2);

        loadPage(0);
    }

    private void loadPage(int i) {
        mPaginaActiva = mContenidos.getpage(i);
        Drawable drawable = getResources().getDrawable(mPaginaActiva.getImageid());
        mImageView.setImageDrawable(drawable);

        String pageText = mPaginaActiva.getNombre();
        pageText = String.format(pageText, mNombre);
        mTextView.setText(pageText);

        if(mPaginaActiva.isFinal()){
            mOpcion1.setVisibility(View.INVISIBLE);
            mOpcion2.setText("INTENTARLO DE NUEVO");
            mOpcion2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }else{
            mOpcion1.setText(mPaginaActiva.getOpcion1().getText());
            mOpcion2.setText(mPaginaActiva.getOpcion2().getText());

            mOpcion1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mPaginaActiva.getOpcion1().getNextpage();
                    loadPage(nextPage);
                }
            });

            mOpcion2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mPaginaActiva.getOpcion2().getNextpage();
                    loadPage(nextPage);
                }
            });
        }



    }


}