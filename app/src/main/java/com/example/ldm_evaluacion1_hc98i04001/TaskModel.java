package com.example.ldm_evaluacion1_hc98i04001;

import java.io.Serializable;

public class TaskModel implements Serializable{
    private String v_nombre;
    private String  task_added_time;
    private String  v_materia;
    private Double v_parcia1;
    private Double v_parcia2;
    private Double v_parcia3;
    private Double promedio_mat;
    public TaskModel() {
    }

    public TaskModel(String nom, String  taskAddedTime, String materia, Double promediomat) {
        this.v_nombre = nom;
        this.task_added_time = taskAddedTime;
        this.v_materia = materia;
        this.promedio_mat = promediomat;
    }

    public String getTaskName() {
        return v_nombre;
    }

    public String getTaskAddedTime() {
        return task_added_time;
    }

    public String getMateria() {
        return v_materia;
    }

    public Double getPromedio() {
        return promedio_mat;
    }


}