package com.example.sistemas.calculonotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;

public class acercaDe extends AppCompatActivity {
    private AdapterViewFlipper IVF;

    int images[]={R.drawable.imagen1,R.drawable.imagen2};
    String names[]={"imagen1", "imagen2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        IVF=(AdapterViewFlipper) findViewById(R.id.IVF);
        CustomAdapter custom= new CustomAdapter(getApplicationContext(),names,images);
        IVF.setAdapter(custom);
        IVF.setFlipInterval(2000);
        IVF.setAutoStart(true);








    }
    public void salir(View v) {
        finish();
    }
}
