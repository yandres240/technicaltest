package com.appgate.technicaltest.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.appgate.technicaltest.R;
import com.appgate.technicaltest.data.AppContext;

public class AlertMessages {
    //Context context = AppContext.getAppContext();
    public void alertView(Context context, String message ) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle( "Alerta!" )
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }
}
