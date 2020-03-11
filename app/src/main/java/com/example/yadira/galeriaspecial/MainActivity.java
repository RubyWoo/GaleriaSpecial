package com.example.yadira.galeriaspecial;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.botoncito);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                DialogFragmentGaleria galeria = new DialogFragmentGaleria();
                galeria.setStyle(DialogFragmentGaleria.STYLE_NO_FRAME,R.style.transparente);
                galeria.show(manager,"");
            }
        });

    }////////////////////////////////////////////////////////////////////////// END METHOD onCreate
}////////////////////////////////////////////////////////////////////////////// END MAIN CLASS
