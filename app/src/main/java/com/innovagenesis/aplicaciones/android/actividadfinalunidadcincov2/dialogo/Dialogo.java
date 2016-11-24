package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.dialogo;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.R;

/**
 * Dialogos de la aplicacion
 * Created by Alexis on 24/11/2016.
 */

public class Dialogo {

    public static AlertDialog listaCheck(Activity activity, final View view){
        final String[] items = activity.getResources().getStringArray(R.array.nombreMenu);
        final boolean [] checkedItem = new boolean[items.length];
        //final boolean[] checkedItem = {false, false, false, true};

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TemaDialogoRadioCheck);

       /* builder.setMultiChoiceItems(items, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) Snackbar.make(view, items[which], Snackbar.LENGTH_SHORT).show();
            }
        });*/

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "";
                for (int i=0; i<checkedItem.length; i++){
                    if (checkedItem[i])
                        seleccion += " "+items[i];
                }
                dialog.cancel();
                Snackbar.make(view, "Selección: "+seleccion, Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }
}
