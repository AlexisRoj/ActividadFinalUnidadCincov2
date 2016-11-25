package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.dialogo;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.R;

/**
 * Dialogos de la aplicacion
 * Created by Alexis on 24/11/2016.
 */

public class Dialogo {

    public static AlertDialog listaCheck(final Activity activity, final View view) {
        final String[] items = activity.getResources().getStringArray(R.array.nombreMenu);
        final boolean[] checkedItem = new boolean[items.length];
        String [] temp;


        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TemaDialogoRadioCheck);
        builder.setTitle("Seleccione las redes a compartir");

        builder.setMultiChoiceItems(items, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // if (isChecked) Snackbar.make(view, items[which], Snackbar.LENGTH_SHORT).show();

            }
        });

        builder.setPositiveButton("Compartir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                new AlertDialog.Builder(activity)
                        .setTitle("Compartir contenido")
                        .setMessage("Realmnente desea compartir el contenido?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(activity,items[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

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
