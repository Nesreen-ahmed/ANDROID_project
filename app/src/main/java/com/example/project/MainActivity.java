package com.example.project;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import android.webkit.WebView;
import android.widget.*;

public class MainActivity extends Activity implements View.OnClickListener {
    WebView v;
    ScrollView show,home;
    EditText prevhours,prevgpas;
    Button b;
    float total=0;
    float gpa=0,y=0;
    double grades[]=new double[12];
    int hours[]=new int[12],x=0;
    int tHours,ad=2;
    Spinner hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8,hour9,hour10,hour11,hour12;
    Spinner grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10,grade11,grade12;
    final DecimalFormat df = new DecimalFormat("0.0000");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v= findViewById(R.id.webview);
        show=findViewById(R.id.gpashow);
        home=findViewById(R.id.home);
        startNOTIFICATION();
        hour1=findViewById(R.id.b2);
        hour2=findViewById(R.id.b5);
        hour3=findViewById(R.id.b8);
        hour4=findViewById(R.id.b11);
        hour5=findViewById(R.id.b14);
        hour6=findViewById(R.id.b17);
        hour7=findViewById(R.id.b20);
        hour8=findViewById(R.id.b23);
        hour9=findViewById(R.id.b26);
        hour10=findViewById(R.id.b29);
        hour11=findViewById(R.id.b31);
        hour12=findViewById(R.id.b33);
        grade1=findViewById(R.id.b1);
        grade2=findViewById(R.id.b4);
        grade3=findViewById(R.id.b7);
        grade4=findViewById(R.id.b10);
        grade5=findViewById(R.id.b13);
        grade6=findViewById(R.id.b16);
        grade7=findViewById(R.id.b19);
        grade8=findViewById(R.id.b22);
        grade9=findViewById(R.id.b25);
        grade10=findViewById(R.id.b28);
        grade11=findViewById(R.id.b30);
        grade12=findViewById(R.id.b32);
    }

    @Override
    public void onBackPressed() {
        if(show.getVisibility()==View.VISIBLE && v.canGoBack())
        {
            v.setVisibility(View.VISIBLE);
            v.goBack();
            show.setVisibility(View.GONE);
        }
        else if(v.canGoBack()){
            v.goBack();
            if(v.getOriginalUrl().equals(""))
            {
                show.setVisibility(View.VISIBLE);
            }
        }
        else
            super.onBackPressed();
    }

    public void changeview(View view){
        if(view.getId()==R.id.complain)
        {
            show.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);
            v.loadUrl("https://forms.office.com/r/HfejjtfynN");
            v.setWebViewClient(new WebViewClient());
        }
        else if(view.getId()==R.id.events)
        {
            show.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);
            v.loadUrl("https://science.asu.edu.eg/ar/events");
            v.setWebViewClient(new WebViewClient());
        }
        else if(view.getId()==R.id.news)
        {
            show.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);
            v.loadUrl("https://science.asu.edu.eg/ar/news");
            v.setWebViewClient(new WebViewClient());
        }
        else if(view.getId()==R.id.facebook)
        {
            show.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);
            v.loadUrl("https://www.facebook.com/672109416181270/");
            v.setWebViewClient(new WebViewClient());
        }
        else if(view.getId()==R.id.baneer)
        {
            show.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);
            v.loadUrl("https://science.asu.edu.eg/ar/page/47/private-ads");
            v.setWebViewClient(new WebViewClient());
        }
        else if(view.getId()==R.id.adver)
        {
            show.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);
            v.loadUrl("https://science.asu.edu.eg/ar/announcements");
            v.setWebViewClient(new WebViewClient());
        }
        else if(view.getId()==R.id.gpa)
        {
            show.setVisibility(View.VISIBLE);
            v.setVisibility(View.INVISIBLE);
            v.loadUrl("");
            grades();
            hours();
            b=findViewById(R.id.calculate);
            b.setOnClickListener(this);
        }
    }

    private void hours() {
        List<Integer> hoursarr=new ArrayList<Integer>();
        hoursarr.add(0);
        hoursarr.add(1);
        hoursarr.add(2);
        hoursarr.add(3);
        hoursarr.add(4);
        hoursarr.add(5);
        hoursarr.add(6);
        ArrayAdapter<Integer>adapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,hoursarr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hour1.setAdapter(adapter);
        hour1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[0]=0;break;
                    case 1:hours[0]=1;break;
                    case 2:hours[0]=2;break;
                    case 3:hours[0]=3;break;
                    case 4:hours[0]=4;break;
                    case 5:hours[0]=5;break;
                    case 6:hours[0]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[0]=0;hours[0]=0;
            }
        });
        hour2.setAdapter(adapter);
        hour2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[1]=0;break;
                    case 1:hours[1]=1;break;
                    case 2:hours[1]=2;break;
                    case 3:hours[1]=3;break;
                    case 4:hours[1]=4;break;
                    case 5:hours[1]=5;break;
                    case 6:hours[1]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[1]=0;hours[1]=0;
            }
        });
        hour3.setAdapter(adapter);
        hour3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[2]=0;break;
                    case 1:hours[2]=1;break;
                    case 2:hours[2]=2;break;
                    case 3:hours[2]=3;break;
                    case 4:hours[2]=4;break;
                    case 5:hours[2]=5;break;
                    case 6:hours[2]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[2]=0;hours[2]=0;
            }
        });
        hour4.setAdapter(adapter);
        hour4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[3]=0;break;
                    case 1:hours[3]=1;break;
                    case 2:hours[3]=2;break;
                    case 3:hours[3]=3;break;
                    case 4:hours[3]=4;break;
                    case 5:hours[3]=5;break;
                    case 6:hours[3]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[3]=0;hours[3]=0;
            }
        });
        hour5.setAdapter(adapter);
        hour5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[4]=0;break;
                    case 1:hours[4]=1;break;
                    case 2:hours[4]=2;break;
                    case 3:hours[4]=3;break;
                    case 4:hours[4]=4;break;
                    case 5:hours[4]=5;break;
                    case 6:hours[4]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[4]=0;hours[4]=0;
            }
        });
        hour6.setAdapter(adapter);
        hour6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[5]=0;break;
                    case 1:hours[5]=1;break;
                    case 2:hours[5]=2;break;
                    case 3:hours[5]=3;break;
                    case 4:hours[5]=4;break;
                    case 5:hours[5]=5;break;
                    case 6:hours[5]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[5]=0;hours[5]=0;
            }
        });
        hour7.setAdapter(adapter);
        hour7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[6]=0;break;
                    case 1:hours[6]=1;break;
                    case 2:hours[6]=2;break;
                    case 3:hours[6]=3;break;
                    case 4:hours[6]=4;break;
                    case 5:hours[6]=5;break;
                    case 6:hours[6]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[6]=0;hours[6]=0;
            }
        });
        hour8.setAdapter(adapter);
        hour8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[7]=0;break;
                    case 1:hours[7]=1;break;
                    case 2:hours[7]=2;break;
                    case 3:hours[7]=3;break;
                    case 4:hours[7]=4;break;
                    case 5:hours[7]=5;break;
                    case 6:hours[7]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[7]=0;hours[7]=0;
            }
        });
        hour9.setAdapter(adapter);
        hour9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[8]=0;break;
                    case 1:hours[8]=1;break;
                    case 2:hours[8]=2;break;
                    case 3:hours[8]=3;break;
                    case 4:hours[8]=4;break;
                    case 5:hours[8]=5;break;
                    case 6:hours[8]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[8]=0;hours[8]=0;
            }
        });
        hour10.setAdapter(adapter);
        hour10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[9]=0;break;
                    case 1:hours[9]=1;break;
                    case 2:hours[9]=2;break;
                    case 3:hours[9]=3;break;
                    case 4:hours[9]=4;break;
                    case 5:hours[9]=5;break;
                    case 6:hours[9]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[9]=0;hours[9]=0;
            }
        });
        hour11.setAdapter(adapter);
        hour11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[10]=0;break;
                    case 1:hours[10]=1;break;
                    case 2:hours[10]=2;break;
                    case 3:hours[10]=3;break;
                    case 4:hours[10]=4;break;
                    case 5:hours[10]=5;break;
                    case 6:hours[10]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[10]=0;hours[10]=0;
            }
        });
        hour12.setAdapter(adapter);
        hour12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:hours[11]=0;break;
                    case 1:hours[11]=1;break;
                    case 2:hours[11]=2;break;
                    case 3:hours[11]=3;break;
                    case 4:hours[11]=4;break;
                    case 5:hours[11]=5;break;
                    case 6:hours[11]=6;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[11]=0;hours[11]=0;
            }
        });
    }

    private void grades() {
        List <String> gradesarr=new ArrayList<String>();
        gradesarr.add("GR");
        gradesarr.add("A");
        gradesarr.add("A-");
        gradesarr.add("B+");
        gradesarr.add("B");
        gradesarr.add("C+");
        gradesarr.add("C");
        gradesarr.add("D");
        gradesarr.add("F");
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,gradesarr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grade1.setAdapter(adapter);
        grade1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[0]=0.0;break;
                    case 1:grades[0]=4.0;break;
                    case 2:grades[0]=3.67;break;
                    case 3:grades[0]=3.33;break;
                    case 4:grades[0]=3.0;break;
                    case 5:grades[0]=2.67;break;
                    case 6:grades[0]=2.33;break;
                    case 7:grades[0]=2.0;break;
                    case 8:grades[0]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[0]=0;hours[0]=0;
            }
        });
        grade2.setAdapter(adapter);
        grade2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[1]=0.0;break;
                    case 1:grades[1]=4.0;break;
                    case 2:grades[1]=3.67;break;
                    case 3:grades[1]=3.33;break;
                    case 4:grades[1]=3.0;break;
                    case 5:grades[1]=2.67;break;
                    case 6:grades[1]=2.33;break;
                    case 7:grades[1]=2.0;break;
                    case 8:grades[1]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[1]=0;hours[1]=0;
            }
        });
        grade3.setAdapter(adapter);
        grade3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[2]=0.0;break;
                    case 1:grades[2]=4.0;break;
                    case 2:grades[2]=3.67;break;
                    case 3:grades[2]=3.33;break;
                    case 4:grades[2]=3.0;break;
                    case 5:grades[2]=2.67;break;
                    case 6:grades[2]=2.33;break;
                    case 7:grades[2]=2.0;break;
                    case 8:grades[2]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[2]=0;hours[2]=0;
            }
        });
        grade4.setAdapter(adapter);
        grade4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[3]=0.0;break;
                    case 1:grades[3]=4.0;break;
                    case 2:grades[3]=3.67;break;
                    case 3:grades[3]=3.33;break;
                    case 4:grades[3]=3.0;break;
                    case 5:grades[3]=2.67;break;
                    case 6:grades[3]=2.33;break;
                    case 7:grades[3]=2.0;break;
                    case 8:grades[3]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[3]=0;hours[3]=0;
            }
        });
        grade5.setAdapter(adapter);
        grade5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[4]=0.0;break;
                    case 1:grades[4]=4.0;break;
                    case 2:grades[4]=3.67;break;
                    case 3:grades[4]=3.33;break;
                    case 4:grades[4]=3.0;break;
                    case 5:grades[4]=2.67;break;
                    case 6:grades[4]=2.33;break;
                    case 7:grades[4]=2.0;break;
                    case 8:grades[4]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[4]=0;hours[4]=0;
            }
        });
        grade6.setAdapter(adapter);
        grade6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[5]=0.0;break;
                    case 1:grades[5]=4.0;break;
                    case 2:grades[5]=3.67;break;
                    case 3:grades[5]=3.33;break;
                    case 4:grades[5]=3.0;break;
                    case 5:grades[5]=2.67;break;
                    case 6:grades[5]=2.33;break;
                    case 7:grades[5]=2.0;break;
                    case 8:grades[5]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[5]=0;hours[5]=0;
            }
        });
        grade7.setAdapter(adapter);
        grade7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[6]=0.0;break;
                    case 1:grades[6]=4.0;break;
                    case 2:grades[6]=3.67;break;
                    case 3:grades[6]=3.33;break;
                    case 4:grades[6]=3.0;break;
                    case 5:grades[6]=2.67;break;
                    case 6:grades[6]=2.33;break;
                    case 7:grades[6]=2.0;break;
                    case 8:grades[6]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[6]=0;hours[6]=0;
            }
        });
        grade8.setAdapter(adapter);
        grade8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[7]=0.0;break;
                    case 1:grades[7]=4.0;break;
                    case 2:grades[7]=3.67;break;
                    case 3:grades[7]=3.33;break;
                    case 4:grades[7]=3.0;break;
                    case 5:grades[7]=2.67;break;
                    case 6:grades[7]=2.33;break;
                    case 7:grades[7]=2.0;break;
                    case 8:grades[7]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[7]=0;hours[7]=0;
            }
        });
        grade9.setAdapter(adapter);
        grade9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[8]=0.0;break;
                    case 1:grades[8]=4.0;break;
                    case 2:grades[8]=3.67;break;
                    case 3:grades[8]=3.33;break;
                    case 4:grades[8]=3.0;break;
                    case 5:grades[8]=2.67;break;
                    case 6:grades[8]=2.33;break;
                    case 7:grades[8]=2.0;break;
                    case 8:grades[8]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[8]=0;hours[8]=0;
            }
        });
        grade10.setAdapter(adapter);
        grade10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[9]=0.0;break;
                    case 1:grades[9]=4.0;break;
                    case 2:grades[9]=3.67;break;
                    case 3:grades[9]=3.33;break;
                    case 4:grades[9]=3.0;break;
                    case 5:grades[9]=2.67;break;
                    case 6:grades[9]=2.33;break;
                    case 7:grades[9]=2.0;break;
                    case 8:grades[9]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[9]=0;hours[9]=0;
            }
        });
        grade11.setAdapter(adapter);
        grade11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[10]=0.0;break;
                    case 1:grades[10]=4.0;break;
                    case 2:grades[10]=3.67;break;
                    case 3:grades[10]=3.33;break;
                    case 4:grades[10]=3.0;break;
                    case 5:grades[10]=2.67;break;
                    case 6:grades[10]=2.33;break;
                    case 7:grades[10]=2.0;break;
                    case 8:grades[10]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[10]=0;hours[10]=0;
            }
        });
        grade12.setAdapter(adapter);
        grade12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:grades[11]=0.0;break;
                    case 1:grades[11]=4.0;break;
                    case 2:grades[11]=3.67;break;
                    case 3:grades[11]=3.33;break;
                    case 4:grades[11]=3.0;break;
                    case 5:grades[11]=2.67;break;
                    case 6:grades[11]=2.33;break;
                    case 7:grades[11]=2.0;break;
                    case 8:grades[11]=0.0;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                grades[11]=0;hours[11]=0;
            }
        });
    }

    @Override
    public void onClick(View view) {
        gpa=0;tHours=0;x=0;y=0;
        prevhours=findViewById(R.id.prevhours);
        prevgpas=findViewById(R.id.prevdeg);
        if(!prevhours.getText().toString().isEmpty())
            x=Integer.parseInt(String.valueOf(prevhours.getText()));
        if(!prevgpas.getText().toString().isEmpty())
            y=Float.parseFloat(String.valueOf(prevgpas.getText()));
        if(view.getId()==b.getId())
        {
            calck();
        }
    }

    private void calck() {
        for(int i=0;i<grades.length;i++)
        {
            gpa+=grades[i]*hours[i];
            tHours+=hours[i];
        }
        if(tHours==0&&x==0)
            total=(float) 0;
        else if(x==0) {
            gpa = gpa / tHours;
            total=gpa;
        }
        else if(tHours==0){gpa=0;total=(float)y;}
        else if(tHours!=0&&x!=0) {
            gpa = gpa / tHours;
            total = (gpa * tHours + x * y) / (tHours + x);
        }
        if(total>=3.67)
            showExcellent();
        else if(total>=3)
            showVery_Good();
        else if(total>2.3299)
            showGood();
        else if(total>=2)
            showModerate();
        else
            showFail();
    }

    public void showExcellent() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(R.layout.excellent);
        AlertDialog dialog=builder.create();
        dialog.getWindow().getAttributes().windowAnimations=R.style.MyDialogAnimation;
        dialog.show();
        ImageView im=dialog.findViewById(R.id.close);
        Button b=dialog.findViewById(R.id.ok);
        TextView tv1=dialog.findViewById(R.id.tv1);
        tv1.setText("Your Semester is : "+df.format(gpa));
        TextView tv2=dialog.findViewById(R.id.tv2);
        tv2.setText("Your Comulative is : "+df.format(total));
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public void showVery_Good() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(R.layout.very_good);
        AlertDialog dialog=builder.create();
        dialog.getWindow().getAttributes().windowAnimations=R.style.MyDialogAnimation;
        dialog.show();
        ImageView im=dialog.findViewById(R.id.close);
        Button b=dialog.findViewById(R.id.ok);
        TextView tv1=dialog.findViewById(R.id.tv1);
        tv1.setText("Your Semester is : "+df.format(gpa));
        TextView tv2=dialog.findViewById(R.id.tv2);
        tv2.setText("Your Comulative is : "+df.format(total));
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public void showGood() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(R.layout.good);
        AlertDialog dialog=builder.create();
        dialog.getWindow().getAttributes().windowAnimations=R.style.MyDialogAnimation;
        dialog.show();
        ImageView im=dialog.findViewById(R.id.close);
        Button b=dialog.findViewById(R.id.ok);
        TextView tv1=dialog.findViewById(R.id.tv1);
        tv1.setText("Your Semester is : "+df.format(gpa));
        TextView tv2=dialog.findViewById(R.id.tv2);
        tv2.setText("Your Comulative is : "+df.format(total));
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public void showModerate() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(R.layout.moderate);
        AlertDialog dialog=builder.create();
        dialog.getWindow().getAttributes().windowAnimations=R.style.MyDialogAnimation;
        dialog.show();
        ImageView im=dialog.findViewById(R.id.close);
        Button b=dialog.findViewById(R.id.ok);
        TextView tv1=dialog.findViewById(R.id.tv1);
        tv1.setText("Your Semester is : "+df.format(gpa));
        TextView tv2=dialog.findViewById(R.id.tv2);
        tv2.setText("Your Comulative is : "+df.format(total));
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public void showFail() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(R.layout.fail);
        AlertDialog dialog=builder.create();
        dialog.getWindow().getAttributes().windowAnimations=R.style.MyDialogAnimation;
        dialog.show();
        ImageView im=dialog.findViewById(R.id.close);
        Button b=dialog.findViewById(R.id.ok);
        TextView tv1=dialog.findViewById(R.id.tv1);
        tv1.setText("Your Semester is : "+df.format(gpa));
        TextView tv2=dialog.findViewById(R.id.tv2);
        tv2.setText("Your Comulative is : "+df.format(total));
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void startNOTIFICATION()
    {

        Intent intent=new Intent(this,StartNotification.class);
        intent.setAction("com.example.notification.STARTNOTIFICATION");
        PendingIntent pendingIntent= PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_MUTABLE);

        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,0,900000,pendingIntent);

        //finish();
    }

    public void add(View view) {
        if(ad>=0&&ad<=11) {
            ad++;
            switch (ad) {
                case 1:
                    findViewById(R.id.v1).setVisibility(View.VISIBLE);
                    break;
                case 2:
                    findViewById(R.id.v2).setVisibility(View.VISIBLE);
                    break;
                case 3:
                    findViewById(R.id.v3).setVisibility(View.VISIBLE);
                    break;
                case 4:
                    findViewById(R.id.v4).setVisibility(View.VISIBLE);
                    break;
                case 5:
                    findViewById(R.id.v5).setVisibility(View.VISIBLE);
                    break;
                case 6:
                    findViewById(R.id.v6).setVisibility(View.VISIBLE);
                    break;
                case 7:
                    findViewById(R.id.v7).setVisibility(View.VISIBLE);
                    break;
                case 8:
                    findViewById(R.id.v8).setVisibility(View.VISIBLE);
                    break;
                case 9:
                    findViewById(R.id.v9).setVisibility(View.VISIBLE);
                    break;
                case 10:
                    findViewById(R.id.v10).setVisibility(View.VISIBLE);
                    break;
                case 11:
                    findViewById(R.id.v11).setVisibility(View.VISIBLE);
                    break;
                case 12:
                    findViewById(R.id.v12).setVisibility(View.VISIBLE);
                    break;
            }
        }
        else Toast.makeText(getApplicationContext(),"Max Number is 12 ",Toast.LENGTH_SHORT).show();
    }

    public void remove(View view) {
        if(ad>=3&&ad<=12){
            switch (ad){
                case 3:findViewById(R.id.v3).setVisibility(View.GONE);hour3.setSelection(0);grade3.setSelection(0);hours[2]=0;break;
                case 4:findViewById(R.id.v4).setVisibility(View.GONE);hour4.setSelection(0);grade4.setSelection(0);hours[3]=0;break;
                case 5:findViewById(R.id.v5).setVisibility(View.GONE);hour5.setSelection(0);grade5.setSelection(0);hours[4]=0;break;
                case 6:findViewById(R.id.v6).setVisibility(View.GONE);hour6.setSelection(0);grade6.setSelection(0);hours[5]=0;break;
                case 7:findViewById(R.id.v7).setVisibility(View.GONE);hour7.setSelection(0);grade7.setSelection(0);hours[6]=0;break;
                case 8:findViewById(R.id.v8).setVisibility(View.GONE);hour8.setSelection(0);grade8.setSelection(0);hours[7]=0;break;
                case 9:findViewById(R.id.v9).setVisibility(View.GONE);hour9.setSelection(0);grade9.setSelection(0);hours[8]=0;break;
                case 10:findViewById(R.id.v10).setVisibility(View.GONE);hour10.setSelection(0);grade10.setSelection(0);hours[9]=0;break;
                case 11:findViewById(R.id.v11).setVisibility(View.GONE);hour11.setSelection(0);grade11.setSelection(0);hours[10]=0;break;
                case 12:findViewById(R.id.v12).setVisibility(View.GONE);hour12.setSelection(0);grade12.setSelection(0);hours[11]=0;break;
            }
            ad--;
        }
        else Toast.makeText(getApplicationContext(),"Minimum Number is 2 ",Toast.LENGTH_SHORT).show();
    }
}