package com.example.manejosesiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    DialogManager cuadrodialogo = new DialogManager();
    SessionManager session;
    Button btnLogout;
    TextView lblName, lblEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        lblName = (TextView)findViewById(R.id.textViewName);
        lblEmail = (TextView)findViewById(R.id.textViewEmail);
        btnLogout = (Button)findViewById(R.id.buttonLogout);

        Toast.makeText(getApplicationContext(), "Estado del Login: " + session.isLogged(), Toast.LENGTH_SHORT).show();

        session.loginStatus();

        HashMap<String, String> user = session.getUserPref();

        String name = user.get(SessionManager.KEY_NAME);
        String email = user.get(SessionManager.KEY_EMAIL);

        lblName.setText(Html.fromHtml("Nombre <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email <b>" + email + "</b>"));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logOut();
            }
        });
    }
}