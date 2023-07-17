package com.example.proiectAMPDM.Test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;




public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "In cod, pentrt initializarea unei componente vizuale definita in fisierul XML, sefoloseste metoda:",
                            "In timpul ciclului de viata al unei activitati, prima metoda asociata este:",
                            "Pentru detectarea miscarii dispozitivului mobil pe cele 3 axe se utilizeaza senzorul de tip:",
                            "Orice activitate trebuie declarata si in fisierul:",
                            "Se considera o activitate care include fragmentul A. Acesta este inlocuit cu fragmentulB printr-o tranzactie. Care este comportamentul la apasarea tastei Back:",
                            "Pt afisarea unui mesaj de informare pt o durata determinata se utilizeaza clasa:",
                            "Tratarea evenimentului Click pentru un obiect de tip View se realizeaza prin:",
                            "GridView este un:",
                            "Clasa FragmentTransaction este responsabila cu:",
                            "Interfata grafica:"
                         };
    String answers[] = {"findViewById()","onCreate()","Accelerometru","AndroidManifest.xml","Se revine la fragmentul A daca a fost apelata metoda addToBackStack() inainte de comiterea tranzactiei","Toast","Implementarea interfetei View.OnClickListener","Control utilizat pt afisarea tabelara a continutului","Operatii cu fragmentare (adaugare, stergere, inlocuire)","Se implementeaza atat prin cod cat si prin fisiere XML"};
    String opt[] = {
                    "getViewById() ","findViewById()","findViewByName()","findControlById()",
                    "onInit() ","onStart()","onResume()","onCreate()",
                    "Accelerometru","Magnetometru (busola)","GPS (Global Positioning System)","Proximitate ",
                    "Xml asociat din directorul res/menu","Xml asociat din directorul res/drawable","AndroidManifest.xml","Java asociat din directorul gen",
                    "Se revine la fragmentul A daca a fost apelata metoda addToBackStack() inainte de comiterea tranzactiei","Se revine tot timpul la fragmentul A","Se revine tot timpul la activitatea anterioara","Se revine la fragmentul A daca a fost apelata metoda startActivity() inainte de comiterea tranzactiei",
                    "Toast","ProgressDialog","AlertDialog","Dialog",
                    "Implementarea interfetei View.View.OnTouchListener ","Implementarea interfetei View,View.OnKeyListener","Includerea in fisierul XML a atributului android:onClick si implementarea metodei declarate in fisierul sursa asociat","Implementarea interfetei View.OnClickListener",
                    "Container dedicat pt afisarea imaginilor","Container utilizat pt afisarea tabelara a continutului","Control utilizat pt afisarea tabelara a continutului","Nu exista aceasta clasa",
                    "Interactiunea cu fragmentele in cadrul activitatilor","Operatii cu fragmentare (adaugare, stergere, inlocuire)","Gestionarea fragmentelor din cadrul activitatilor","Definirea fragmentelor (clasa de baza pt fragmente)",
                     "Se implementeaza doar prin fisiere XML ","Se implementeaza doar prin cod","Se implementeaza doar cu editorul vizual dedicat","Se implementeaza atat prin cod cat si prin fisiere XML"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Salut, " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Trebuie sa selectezi un raspuns", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Raspuns Corect", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Raspuns Gresit", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}