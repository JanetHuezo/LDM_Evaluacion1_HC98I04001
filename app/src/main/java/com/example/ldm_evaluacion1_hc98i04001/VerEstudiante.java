package com.example.ldm_evaluacion1_hc98i04001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VerEstudiante extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<TaskModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_estudiante);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recyclerView = findViewById(R.id.recyclerview);


        taskList = PrefConfig.readListFromPref(this);

        if (taskList == null)
        { Toast.makeText(VerEstudiante.this," No hay datos que mostrar" ,Toast.LENGTH_SHORT).show();
            finish();
        }else {


            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            adapter = new TaskAdapter(getApplicationContext(), taskList);
            recyclerView.setAdapter(adapter);

        }
    }

}
