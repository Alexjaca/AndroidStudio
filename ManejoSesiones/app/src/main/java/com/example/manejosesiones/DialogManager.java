package com.example.manejosesiones;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogManager {

    public void showAlertDialog(Context context, String title, String message, Boolean status){

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title); // ponemos titulo al cuadro del dialogo
        alertDialog.setMessage(message); // Pasamos el mensaje

        if(status != null){
            alertDialog.setIcon((status) ? R.drawable.login : R.drawable.error);

            // Boton ok
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }
    }
}
