package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class gpa extends AppCompatActivity {
    LinearLayout v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        v=findViewById(R.id.value);
    }

    public void calc(View view) {
        //v.setVisibility(View.VISIBLE);
    }
}