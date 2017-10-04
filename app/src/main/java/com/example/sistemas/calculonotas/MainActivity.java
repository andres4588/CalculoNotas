package com.example.sistemas.calculonotas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_n1M;
    private EditText et_n2M;
    private EditText et_n3M;
    private TextView tv_defM;

    ///---------------------- Variables Ingles---------------------------/
    private EditText et_n1I;
    private EditText et_n2I;
    private EditText et_n3I;
    private TextView tv_defI;


    ///---------------------- Variables PMI---------------------------/
    private EditText et_n1P;
    private EditText et_n2P;
    private EditText et_n3P;
    private TextView tv_defP;


    ///---------------------- Variables Geometria---------------------------/
    private EditText et_n1G;
    private EditText et_n2G;
    private EditText et_n3G;
    private TextView tv_defG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //---------- inicializacion variables matematicas-----------//


        et_n1M = (EditText) findViewById(R.id.et_n1M);
        et_n2M = (EditText) findViewById(R.id.et_n2M);
        et_n3M = (EditText) findViewById(R.id.et_n3M);
        tv_defM = (TextView) findViewById(R.id.tv_defM);


        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et_n1M.setText(prefe.getString("cp1", "0"));
        et_n2M.setText(prefe.getString("cp2", "0"));
        et_n3M.setText(prefe.getString("cp3", "0"));
        tv_defM.setText(prefe.getString("r1", tv_defM.getText().toString()));





        ///---------------------- Metodo para area de mateticas---------------------------///

        et_n1M.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                double valor1=0;
                double valor2=0;
                double valor3=0;
                try {


                    String cadena1 = et_n1M.getText().toString();
                     valor1 = Double.parseDouble(cadena1);
                    if(valor1>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n1M.setText("0");

                    }
                    else {
                        double nuevovalor1 = valor1 * 0.3;


                        String cadena2 = et_n2M.getText().toString();
                        valor2 = Double.parseDouble(cadena2);
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3M.getText().toString();
                        valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);
                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp1", et_n1M.getText().toString());
                        notas.putString("cp2", et_n2M.getText().toString());
                        notas.putString("cp3", et_n3M.getText().toString());
                        notas.putString("r1", tv_defM.getText().toString());
                        notas.commit();

                        tv_defM.setText(resu);
                    }
                } catch (Exception e) {

                    if (et_n1M.getText().toString().equals("") || et_n2M.getText().toString().equals("") || et_n3M.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }


                }



            }


        });


        et_n2M.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    String cadena1 = et_n1M.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);


                        double nuevovalor1 = valor1 * 0.3;


                        String cadena2 = et_n2M.getText().toString();
                        double valor2 = Double.parseDouble(cadena2);
                    if(valor2>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n2M.setText("0");

                    }
                    else {
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3M.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);
                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp1", et_n1M.getText().toString());
                        notas.putString("cp2", et_n2M.getText().toString());
                        notas.putString("cp3", et_n3M.getText().toString());
                        notas.putString("r1", tv_defM.getText().toString());
                        notas.commit();


                        tv_defM.setText(resu);
                    }

                }
                catch (Exception e) {

                    if (et_n1M.getText().toString().equals("") || et_n2M.getText().toString().equals("") || et_n3M.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this, getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        et_n3M.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    String cadena1 = et_n1M.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);

                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2M.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    double nuevovalor2 = valor2 * 0.3;


                    String cadena3 = et_n3M.getText().toString();
                    double valor3 = Double.parseDouble(cadena3);
                    if (valor3 > 5) {
                        Toast notificacion = Toast.makeText(MainActivity.this, "la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n3M.setText("0");

                    }
                    else
                    {
                    double nuevovalor3 = valor3 * 0.4;


                    double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                    resultadof = Math.rint(resultadof * 100) / 100;
                    String resu = String.valueOf(resultadof);

                    SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor notas = preferencias.edit();
                    notas.putString("cp1", et_n1M.getText().toString());
                    notas.putString("cp2", et_n2M.getText().toString());
                    notas.putString("cp3", et_n3M.getText().toString());
                    notas.putString("r1", tv_defM.getText().toString());
                    notas.commit();


                    tv_defM.setText(resu);
                }
                }

                catch (Exception e) {

                    if (et_n1M.getText().toString().equals("") || et_n2M.getText().toString().equals("") || et_n3M.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });



        //---------- inicializacion variables ingles-----------//


        et_n1I = (EditText) findViewById(R.id.et_n1I);
        et_n2I = (EditText) findViewById(R.id.et_n2I);
        et_n3I = (EditText) findViewById(R.id.et_n3I);
        tv_defI = (TextView) findViewById(R.id.tv_defI);



        et_n1I.setText(prefe.getString("cp4", "0"));
        et_n2I.setText(prefe.getString("cp5", "0"));
        et_n3I.setText(prefe.getString("cp6", "0"));
        tv_defI.setText(prefe.getString("r2", tv_defI.getText().toString()));






        //--------------- metodo area ingles --------------------//
        et_n1I.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try
                {

                    String cadena1 = et_n1I.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    if(valor1>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n1I.setText("0");

                    }
                    else {
                        double nuevovalor1 = valor1 * 0.3;


                        String cadena2 = et_n2I.getText().toString();
                        double valor2 = Double.parseDouble(cadena2);
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3I.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp4", et_n1I.getText().toString());
                        notas.putString("cp5", et_n2I.getText().toString());
                        notas.putString("cp6", et_n3I.getText().toString());
                        notas.putString("r2", tv_defI.getText().toString());
                        notas.commit();

                        tv_defI.setText(resu);
                    }
                }


                catch (Exception e) {

                    if (et_n1I.getText().toString().equals("") || et_n2I.getText().toString().equals("") || et_n3I.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        et_n2I.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try
                {
                    String cadena1 = et_n1I.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2I.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    if(valor2>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n2I.setText("0");

                    }
                    else {

                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3I.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp4", et_n1I.getText().toString());
                        notas.putString("cp5", et_n2I.getText().toString());
                        notas.putString("cp6", et_n3I.getText().toString());
                        notas.putString("r2", tv_defI.getText().toString());
                        notas.commit();

                        tv_defI.setText(resu);
                    }
                }
                catch (Exception e) {

                    if (et_n1I.getText().toString().equals("") || et_n2I.getText().toString().equals("") || et_n3I.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        et_n3I.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try
                {
                    String cadena1 = et_n1I.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2I.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    double nuevovalor2 = valor2 * 0.3;



                    String cadena3 = et_n3I.getText().toString();
                    double valor3 = Double.parseDouble(cadena3);
                    if(valor3>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n3I.setText("0");

                    }
                    else {
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp4", et_n1I.getText().toString());
                        notas.putString("cp5", et_n2I.getText().toString());
                        notas.putString("cp6", et_n3I.getText().toString());
                        notas.putString("r2", tv_defI.getText().toString());
                        notas.commit();


                        tv_defI.setText(resu);
                    }
                }
                catch (Exception e) {

                    if (et_n1I.getText().toString().equals("") || et_n2I.getText().toString().equals("") || et_n3I.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });


        //---------- inicializacion variables pmi-----------//


        et_n1P = (EditText) findViewById(R.id.et_n1P);
        et_n2P = (EditText) findViewById(R.id.et_n2P);
        et_n3P = (EditText) findViewById(R.id.et_n3P);
        tv_defP = (TextView) findViewById(R.id.tv_defP);


        et_n1P.setText(prefe.getString("cp7", "0"));
        et_n2P.setText(prefe.getString("cp8", "0"));
        et_n3P.setText(prefe.getString("cp9", "0"));
        tv_defP.setText(prefe.getString("r3", tv_defP.getText().toString()));


        //--------------- metodo area pmi --------------------//
        et_n1P.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {

                    String cadena1 = et_n1P.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    if (valor1 > 5) {
                        Toast notificacion = Toast.makeText(MainActivity.this, "la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n1P.setText("0");

                    } else {
                        double nuevovalor1 = valor1 * 0.3;


                        String cadena2 = et_n2P.getText().toString();
                        double valor2 = Double.parseDouble(cadena2);
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3P.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp7", et_n1P.getText().toString());
                        notas.putString("cp8", et_n2P.getText().toString());
                        notas.putString("cp9", et_n3P.getText().toString());
                        notas.putString("r3", tv_defP.getText().toString());
                        notas.commit();

                        tv_defP.setText(resu);
                    }
                }

                catch (Exception e) {

                    if (et_n1P.getText().toString().equals("") || et_n2P.getText().toString().equals("") || et_n3P.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        et_n2P.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try
                {
                    String cadena1 = et_n1P.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2P.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    if(valor2>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n2P.setText("0");

                    }
                    else {
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3P.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);
                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp7", et_n1P.getText().toString());
                        notas.putString("cp8", et_n2P.getText().toString());
                        notas.putString("cp9", et_n3P.getText().toString());
                        notas.putString("r3", tv_defP.getText().toString());
                        notas.commit();

                        tv_defP.setText(resu);
                    }
                }
                catch (Exception e) {

                    if (et_n1P.getText().toString().equals("") || et_n2P.getText().toString().equals("") || et_n3P.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        et_n3P.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try
                {
                    String cadena1 = et_n1P.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2P.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    double nuevovalor2 = valor2 * 0.3;



                    String cadena3 = et_n3P.getText().toString();
                    double valor3 = Double.parseDouble(cadena3);
                    if(valor3>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n3P.setText("0");

                    }
                    else {
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);
                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp7", et_n1P.getText().toString());
                        notas.putString("cp8", et_n2P.getText().toString());
                        notas.putString("cp9", et_n3P.getText().toString());
                        notas.putString("r3", tv_defP.getText().toString());
                        notas.commit();


                        tv_defP.setText(resu);
                    }

                }
                catch (Exception e) {

                    if (et_n1P.getText().toString().equals("") || et_n2P.getText().toString().equals("") || et_n3P.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        //---------- inicializacion variables geometria-----------//


        et_n1G = (EditText) findViewById(R.id.et_n1G);
        et_n2G = (EditText) findViewById(R.id.et_n2G);
        et_n3G = (EditText) findViewById(R.id.et_n3G);
        tv_defG = (TextView) findViewById(R.id.tv_defG);



        et_n1G.setText(prefe.getString("cp10", "0"));
        et_n2G.setText(prefe.getString("cp11", "0"));
        et_n3G.setText(prefe.getString("cp12", "0"));
        tv_defG.setText(prefe.getString("r4", tv_defG.getText().toString()));



        ///---------------------- Metodo para area de geometria---------------------------///

        et_n1G.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try
                {



                    String cadena1 = et_n1G.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    if(valor1>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n1G.setText("0");

                    }
                    else {
                        double nuevovalor1 = valor1 * 0.3;


                        String cadena2 = et_n2G.getText().toString();
                        double valor2 = Double.parseDouble(cadena2);
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3G.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp10", et_n1G.getText().toString());
                        notas.putString("cp11", et_n2G.getText().toString());
                        notas.putString("cp12", et_n3G.getText().toString());
                        notas.putString("r4", tv_defG.getText().toString());
                        notas.commit();

                        tv_defG.setText(resu);
                    }

                }
                catch (Exception e) {

                    if (et_n1G.getText().toString().equals("") || et_n2G.getText().toString().equals("") || et_n3G.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });
        et_n2G.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void afterTextChanged(Editable editable) {
                try
                {
                    String cadena1 = et_n1G.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2G.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    if(valor2>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n2G.setText("0");

                    }
                    else {
                        double nuevovalor2 = valor2 * 0.3;


                        String cadena3 = et_n3G.getText().toString();
                        double valor3 = Double.parseDouble(cadena3);
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);
                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp10", et_n1G.getText().toString());
                        notas.putString("cp11", et_n2G.getText().toString());
                        notas.putString("cp12", et_n3G.getText().toString());
                        notas.putString("r4", tv_defG.getText().toString());
                        notas.commit();

                        tv_defG.setText(resu);
                    }
                }
                catch (Exception e) {

                    if (et_n1G.getText().toString().equals("") || et_n2G.getText().toString().equals("") || et_n3G.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });

        et_n3G.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {


                    String cadena1 = et_n1G.getText().toString();
                    double valor1 = Double.parseDouble(cadena1);
                    double nuevovalor1 = valor1 * 0.3;


                    String cadena2 = et_n2G.getText().toString();
                    double valor2 = Double.parseDouble(cadena2);
                    double nuevovalor2 = valor2 * 0.3;



                    String cadena3 = et_n3G.getText().toString();
                    double valor3 = Double.parseDouble(cadena3);
                    if(valor3>5)
                    {
                        Toast notificacion = Toast.makeText(MainActivity.this,"la nota no puede ser mayor a 5", Toast.LENGTH_LONG);
                        notificacion.show();
                        et_n3G.setText("0");

                    }
                    else {
                        double nuevovalor3 = valor3 * 0.4;


                        double resultadof = nuevovalor1 + nuevovalor2 + nuevovalor3;
                        resultadof = Math.rint(resultadof * 100) / 100;
                        String resu = String.valueOf(resultadof);

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor notas = preferencias.edit();
                        notas.putString("cp10", et_n1G.getText().toString());
                        notas.putString("cp11", et_n2G.getText().toString());
                        notas.putString("cp12", et_n3G.getText().toString());
                        notas.putString("r4", tv_defG.getText().toString());
                        notas.commit();


                        tv_defG.setText(resu);
                    }
                }

                catch (Exception e) {

                    if (et_n1G.getText().toString().equals("") || et_n2G.getText().toString().equals("") || et_n3G.getText().toString().equals("")) {
                        Toast notificacion = Toast.makeText(MainActivity.this,  getResources().getString(R.string.mensajellenarcampos), Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }
            }


        });


    }




    //METODO PARA CALCULAR NOTA FINAL SEMESTRE
    public void calcular(View view) {
        try {


            String resulatdo1 = tv_defM.getText().toString();
            String resulatdo2 = tv_defI.getText().toString();
            String resulatdo3 = tv_defP.getText().toString();
            String resulatdo4 = tv_defG.getText().toString();
            double valor1 = Double.parseDouble(resulatdo1);
            double valor2 = Double.parseDouble(resulatdo2);
            double valor3 = Double.parseDouble(resulatdo3);
            double valor4 = Double.parseDouble(resulatdo4);
            double suma = valor1 + valor2 + valor3 + valor4;
            double fin = suma / 4;
            fin = Math.rint(fin * 100) / 100;


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle( getResources().getString(R.string.mensajeDefinitiva));
            builder.setMessage(getResources().getString(R.string.mensajenota) + fin);

            builder.setNegativeButton(getResources().getString(R.string.cancel),null);
            Dialog dialog = builder.create();
            dialog.show();
        }
        catch (Exception e) {

            if (tv_defM.getText().toString().equals("") ||
                    tv_defI.getText().toString().equals("") ||
                    tv_defP.getText().toString().equals("") ||
                    tv_defG.getText().toString().equals("")) {
                Toast notificacion = Toast.makeText(MainActivity.this, getResources().getString(R.string.definitivacias), Toast.LENGTH_LONG);
                notificacion.show();
            }
        }





    }


    //  METODO LIMPIAR
    public void limpiar(View view) {

        tv_defM.setText("0");
        tv_defI.setText("0");
        tv_defP.setText("0");
        tv_defG.setText("0");

        et_n1M.setText("0");
        et_n2M.setText("0");
        et_n3M.setText("0");


        et_n1I.setText("0");
        et_n2I.setText("0");
        et_n3I.setText("0");



        et_n1P.setText("0");
        et_n2P.setText("0");
        et_n3P.setText("0");


        et_n1G.setText("0");
        et_n2G.setText("0");
        et_n3G.setText("0");


    }
    // ACERCA DE

    public void acercade(View view) {
        Intent i = new Intent(this, acercaDe.class );
        startActivity(i);
    }






}


