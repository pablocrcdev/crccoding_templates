package com.example.crccoding.webviewtemplate.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by CRCCODING on 18/10/2017.
 */
/* Clase para la comunicacion entre el navegador y las funciones de la aplicacion*/
public class WebAppInterface {
    //=============================VARIABLES GLOBALES=============================================//
    private Context gvContext;
    //============================================================================================//
    // El contructor se define con el parametro de contexto para refenrenciar siempre al activity
    // que este en primer plano y poder aplicar funciones sobre el mismo
    public WebAppInterface(Context pContext) {
        this.gvContext = pContext;
    }
    @JavascriptInterface
    public  void show (){
        Toast.makeText(gvContext, "prueba", Toast.LENGTH_SHORT).show();
    }
    //============================================================================================//
}
