package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
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
    ScrollView show;
    EditText prevhours,prevgpas;
    Button b;
    Float total;
    double gpa,y=0;
    String type;
    double grades[]=new double[10];
    int hours[]=new int[10],x=0;
    int tHours;
    final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v= findViewById(R.id.webviwe);
        show=findViewById(R.id.gpashow);
    }

    public void gpa(View view) {
        show.setVisibility(View.VISIBLE);
        v.setVisibility(View.INVISIBLE);
        prevhours=findViewById(R.id.prevhours);
        prevgpas=findViewById(R.id.prevdeg);
        b=findViewById(R.id.calculate);
        b.setOnClickListener(this);
        grades();
        hours();
    }
    private void hours() {
        Spinner hour1=findViewById(R.id.b2);
        Spinner hour2=findViewById(R.id.b5);
        Spinner hour3=findViewById(R.id.b8);
        Spinner hour4=findViewById(R.id.b11);
        Spinner hour5=findViewById(R.id.b14);
        Spinner hour6=findViewById(R.id.b17);
        Spinner hour7=findViewById(R.id.b20);
        Spinner hour8=findViewById(R.id.b23);
        Spinner hour9=findViewById(R.id.b26);
        Spinner hour10=findViewById(R.id.b29);
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
    }

    private void grades()
    {
        Spinner grade1=findViewById(R.id.b1);
        Spinner grade2=findViewById(R.id.b4);
        Spinner grade3=findViewById(R.id.b7);
        Spinner grade4=findViewById(R.id.b10);
        Spinner grade5=findViewById(R.id.b13);
        Spinner grade6=findViewById(R.id.b16);
        Spinner grade7=findViewById(R.id.b19);
        Spinner grade8=findViewById(R.id.b22);
        Spinner grade9=findViewById(R.id.b25);
        Spinner grade10=findViewById(R.id.b28);
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
    }
    @Override
    public void onClick(View view) {
        gpa=0;tHours=0;
        if(!prevhours.getText().toString().isEmpty())
            x=Integer.parseInt(String.valueOf(prevhours.getText()));
        if(!prevgpas.getText().toString().isEmpty())
            y=Double.parseDouble(String.valueOf(prevgpas.getText()));
        if(view.getId()==b.getId())
        {
            calck();
            show();
        }
    }

    private void calck() {
        for(int i=0;i<grades.length;i++)
        {
            gpa+=grades[i]*hours[i];
            tHours+=hours[i];
        }
        gpa=gpa/tHours;
        total= (float) ((gpa*tHours+x*y)/(tHours+x));
        if(total>=3.67)
            type="Excellent";
        else if(total>=3)
            type="Very Good";
        else if(total>=2.33)
            type="Good";
        else if(total>=2)
            type="Moderate";
        else
            type="Fail";
    }

    public void show()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Your Semester is : "+gpa+"\n\nYour Comutative is : "+df.format(total)).setTitle(type).setPositiveButton("OK", null);
        AlertDialog dialog=builder.create();
        dialog.getWindow().getAttributes().windowAnimations=R.style.MyDialogAnimation;
        dialog.show();
    }

}