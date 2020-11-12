package com.example.ldm_evaluacion1_hc98i04001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button btnNE  = findViewById(R.id.btn_AgregarN);
        Button btnLE = findViewById(R.id.btn_Lista);
        Button btnMD = findViewById(R.id.btn_MisDatos);

        btnNE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AgregarNombre = new Intent(MainActivity.this,AgregarNE.class);
                startActivity(AgregarNombre);
            }
        });
       btnLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ListaEstudiante = new Intent(MainActivity.this,VerEstudiante.class);
                startActivity(ListaEstudiante);
            }
       });
        btnMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Datos = new Intent(MainActivity.this,MisDatos.class);
                startActivity(Datos);
            }
        });
    }
}