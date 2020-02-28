package com.example.gestiondenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MostrarAlumnos extends AppCompatActivity {

    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alumnos);

        Intent intent = getIntent();
        nombresArray = intent.getStringArrayExtra("nombresArray");
        nota1Array = intent.getIntArrayExtra("nota1Array");
        nota2Array = intent.getIntArrayExtra("nota2Array");
        nota3Array = intent.getIntArrayExtra("nota3Array");
        contador = intent.getIntExtra("contador", 0);

        RecyclerView recyclerView = findViewById(R.id.recyclerNotas);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, nombresArray, nota1Array, nota2Array, nota3Array, contador);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

    }
}
