package com.example.crccoding.webviewtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.crccoding.webviewtemplate.webview.ControladorError;

public class ErrorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        Intent intent = getIntent();
        switch (intent.getStringExtra("error")){
            case "WEB":
                new ControladorError(this).showErrorDialog();
                break;
            case "RED":
                new ControladorError(this).showNetworkDialog();
                break;
            default:
                new ControladorError(this).showErrorDialog();
                break;
        }
    }
}
