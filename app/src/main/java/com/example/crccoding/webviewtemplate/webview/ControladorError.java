package com.example.crccoding.webviewtemplate.webview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.crccoding.webviewtemplate.MainActivity;
import com.example.crccoding.webviewtemplate.R;

/**
 * Created by CRCCODING on 18/10/2017.
 */

public class ControladorError {
    //==========================VARIABLES GLOBALES================================================//
    private Context gvContext;
    //============================================================================================//
    public  ControladorError(Context pcontexto){
        this.gvContext = pcontexto;
    }
    //============================================================================================//
    public void showNetworkDialog(){
        final Dialog vDialog = new Dialog(gvContext);
        vDialog.setContentView(R.layout.network_error);
        Button vBtn_OK = (Button) vDialog.findViewById(R.id.btn_dialog_net);
        vBtn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vDialog.dismiss();
            }
        });
        vDialog.show();
        vDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Intent vintent = new Intent (gvContext, MainActivity.class);
                gvContext.startActivity(vintent);
            }
        });
    }
    //============================================================================================//
    public void showErrorDialog(){
        final Dialog vDialog = new Dialog(gvContext);
        vDialog.setContentView(R.layout.webview_error);
        Button vBtn_OK = (Button) vDialog.findViewById(R.id.btn_dialog_err);
        vBtn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vDialog.dismiss();
            }
        });
        vDialog.show();
        vDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Intent vintent = new Intent(gvContext, MainActivity.class);
                gvContext.startActivity(vintent);
            }
        });
    }
}
