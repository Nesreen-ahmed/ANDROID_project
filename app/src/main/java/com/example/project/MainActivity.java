package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    WebView v;
    String notificat_id= "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v= findViewById(R.id.webviwe);
    }

    public void gpa(View view) {
        Fragment f = new froggpa();
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.webviwe,f).commit();
    }
}