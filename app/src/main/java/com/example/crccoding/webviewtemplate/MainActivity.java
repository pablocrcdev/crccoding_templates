package com.example.crccoding.webviewtemplate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.crccoding.webviewtemplate.webview.ControladorError;
import com.example.crccoding.webviewtemplate.webview.ManagerChromeClient;
import com.example.crccoding.webviewtemplate.webview.ManagerWebClient;
import com.example.crccoding.webviewtemplate.webview.WebAppInterface;

public class MainActivity extends AppCompatActivity {

    // Variables globales
    //********************************************************************************************//
    private WebView gvWebView;
    private ProgressBar gvProgressBar;
    private final static String gvURL = "URL_DESTINO_SERVIDOR_GIT";
    private final static String ERROR_RED = "RED";
    private final static String ERROR_WEB = "WEB";
    //********************************************************************************************//
    // Metodos de validacion
    //********************************************************************************************//
    // Validacion del estado del acceso a la web
    protected boolean validarEstadoRed(){
        ConnectivityManager vConnectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo vNetworkInfo = vConnectivityManager.getActiveNetworkInfo();
        if(vNetworkInfo != null && vNetworkInfo.isConnectedOrConnecting())
            return true;  // Si encuentra que hay conexion
        else
            return false; // De no encontrar conexion arroja falso
    }
    //********************************************************************************************//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Se valida el estado de la red si esta tiene acceso a internet
        if(validarEstadoRed()) {
            // Inicializacion de elemento Progress Bar
            gvProgressBar = (ProgressBar) findViewById(R.id.progressBar);
            // Declaracion del elemento xml en la clase para configuraciones
            gvWebView = (WebView) findViewById(R.id.WebView);
            // Seteo de Cliente Web, para manejo de navegador interno
            gvWebView.setWebViewClient(new ManagerWebClient(this));
            // Habilitacion de Javascript en el webview
            gvWebView.getSettings().setJavaScriptEnabled(true);
            // Interfaz Javascript que ejecuta java en webview
            gvWebView.addJavascriptInterface(new WebAppInterface(this),"Android");
            // Carga de URL en el elemento Webview
            gvWebView.loadUrl(gvURL);
            // Seteo Default de Cliente de Google para el webview (Otras funcionalidades)
            gvWebView.setWebChromeClient(new ManagerChromeClient(this));
        } else {
            // Se llama el activity de error
            Intent intent = new Intent(this, ErrorActivity.class);
            intent.putExtra("error",ERROR_RED);
            startActivity(intent);
            //new ControladorError(this).showNetworkDialog();
        }
    }
}
