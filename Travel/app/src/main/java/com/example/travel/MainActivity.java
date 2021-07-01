package com.example.travel;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    String paris = "Paris";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnParis = findViewById(R.id.button);
        btnParis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has Seleccionado Paris", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(intent);
                }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.ajustes:
                Toast.makeText(this, "HAs pulsado Ajustes" ,Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
            case R.id.ayuda:
                Toast.makeText(this, "Has pulsado Ayuda", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.extra:
                Toast.makeText(this, "Has pulsado Extra", Toast.LENGTH_SHORT).show();
                return true;

        }

    }
}