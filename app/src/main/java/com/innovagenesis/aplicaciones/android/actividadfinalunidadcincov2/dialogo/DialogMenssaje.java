package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.dialogo;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.R;

/**
 *
 * Created by Alexis on 24/11/2016.
 */

public class DialogMenssaje {

    public AlertDialog newShareDialog(final Activity activity){
        final String[] items = {"Facebook", "Twitter", "Instagram", "Google Plus", "Whatsapp", "Messenger", "SMS"};
        final boolean[] checkedItems = {false, false, false, false, false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.DialogStyle);
        builder.setTitle("Selecciona dónde quieres compartir esta aplicación:");

        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        builder.setPositiveButton("Compartir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "Compartiste esta aplicación a través de: ";
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {
                        seleccion += "\n" + items[i];
                    }
                }
                dialog.cancel();
                newConfirmationDialog(seleccion, activity).show();
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

    public AlertDialog newConfirmationDialog(final String seleccion, final Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.DialogStyle);
        builder.setTitle("Confirmación");
        builder.setMessage("¿Compartir esta aplicación a través de los medios seleccionados?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(activity, seleccion, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }
}
