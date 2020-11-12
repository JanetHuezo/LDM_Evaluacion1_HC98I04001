
package com.example.ldm_evaluacion1_hc98i04001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.lang.Byte.SIZE;

public class AgregarNE extends AppCompatActivity {
    private List<TaskModel> taskList;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_n_e);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final EditText nombre = findViewById(R.id.txtNom);
        final EditText codigo = findViewById(R.id.txtCod);
        final EditText mat = findViewById(R.id.txtMateria);
        final EditText parcial1 = findViewById(R.id.txtP1);
        final EditText parcial2 = findViewById(R.id.txtP2);
        final EditText parcial3 = findViewById(R.id.txtP3);

        Button agregar = findViewById(R.id.btnGuardar);
        taskList = PrefConfig.readListFromPref(this);

        if (taskList == null)
            taskList = new ArrayList<>();

        adapter = new TaskAdapter(getApplicationContext(), taskList);



        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vnombre = nombre.getText().toString().trim();
                String vcod = codigo.getText().toString().trim();
                String vmat = mat.getText().toString().trim();
                String vpar1 = parcial1.getText().toString().trim();
                String vpar2 = parcial2.getText().toString().trim();
                String vpar3 = parcial3.getText().toString().trim();
                boolean valido = true;
                if (vnombre.equals("") && vcod.equals("") && vmat.equals("") && vpar1.equals("") && vpar2.equals("") && vpar3.equals("")) {
                    nombre.setError("campo requerido");
                    codigo.setError("campo requerido");
                    mat.setError("campo requerido");
                    parcial1.setError("campo requerido");
                    parcial2.setError("campo requerido");
                    parcial3.setError("campo requerido");
                    valido = false;
                }
                if (valido) {
                    Toast.makeText(AgregarNE.this, " Nombre agredado con éxito", Toast.LENGTH_SHORT).show();
                    TaskModel taskModel = new TaskModel(nombre.getText().toString(), codigo.getText().toString(), mat.getText().toString(), getPromedio());
                    taskList.add(taskModel);

                    PrefConfig.writeListInPref(getApplicationContext(), taskList);
                    Collections.reverse(taskList);
                    adapter.setTaskModelList(taskList);
                    finish();

                }
            }
        });

    }
    private Double getPromedio() {
        final EditText parcial1 = findViewById(R.id.txtP1);
        final EditText parcial2 = findViewById(R.id.txtP2);
        final EditText parcial3 = findViewById(R.id.txtP3);
        double nota1= Double.parseDouble(parcial1.getText().toString());
        double nota2= Double.parseDouble(parcial2.getText().toString());
        double nota3= Double.parseDouble(parcial3.getText().toString());
        double cal_promd= ((nota1*0.30)+(nota2*0.30)+(nota3*0.40));
        return cal_promd;
    }



}
