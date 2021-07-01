package com.example.manejosesiones;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences pref; // Almacenamiento de preferencias
    SharedPreferences.Editor editor;  // Creamos el editor para realizar las operaciones
    Context _context;
    int PRIVATE_MODE = 0;  // Privacidad de las preferencias
    private static final String PREF_NAME = "Pixelpro";  // Shareredpred nombre del archivo
    private static final String IS_LOGGED = "Identificado";  // Claves
    public static final String KEY_NAME = "Nombre";  //  Nombre de usuario en final para poder acceder
    public static final String KEY_EMAIL = "Email";  // Email tambien en final para que sea accedido


    //Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String name, String email){
        editor.putBoolean(IS_LOGGED, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public HashMap<String, String> getUserPref(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        return user;
    }

    public void loginStatus(){
        if (!this.isLogged()){
            Intent intent = new Intent(_context, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(intent);
        }
    }

    public boolean isLogged(){
        return pref.getBoolean(IS_LOGGED, false);
    }

    public void logOut(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(_context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(intent);
    }


}
