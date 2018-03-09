package com.example.crccoding.webviewtemplate.webview;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.crccoding.webviewtemplate.R;

/**
 * Created by CRCCODING on 18/10/2017.
 */
/* Clase para el manejo de funcionalidades del navegador desde la aplicacion que lo emula */
public class ManagerChromeClient extends WebChromeClient{
    //=============================VARIABLES GLOBALES=============================================//
    private ProgressBar gvProgressBar;
    private Context gvContext;
    //============================================================================================//
    // El contructor se define con el parametro de contexto para refenrenciar siempre al activity
    // que este en primer plano y poder aplicar funciones sobre el mismo
    public ManagerChromeClient(Context pcontext){
        gvContext = pcontext;
    }
    //============================================================================================//
    public void onProgressChanged(WebView view, int progress) {
        // Definimos la variable asociada al progress bar, esto aplicando el casting con el contexto
        // de la app que se este ejecutando y que referencia esta clase
        gvProgressBar = (ProgressBar) ((Activity)gvContext).findViewById(R.id.progressBar);
        // Validamos el progreso y mostramos si esta cargando
        if (progress < 100 && gvProgressBar.getVisibility() == ProgressBar.GONE) {
            gvProgressBar.setVisibility(ProgressBar.VISIBLE);
        }
        // Despues asignamos el valor de progreso a la barra de progreso
        gvProgressBar.setProgress(progress);
        // Si la carga se completo se oculta el item
        if (progress == 100) {
            gvProgressBar.setVisibility(ProgressBar.GONE);
        }
    }
}
