package com.example.gestiondenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnadirAlumno extends AppCompatActivity {

    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_alumno);

        Intent recogerDatos = getIntent();

        nombresArray = recogerDatos.getStringArrayExtra("nombresArray");
        contador = recogerDatos.getIntExtra("contador", 0);
        nota1Array = recogerDatos.getIntArrayExtra("nota1Array");
        nota2Array = recogerDatos.getIntArrayExtra("nota2Array");
        nota3Array = recogerDatos.getIntArrayExtra("nota3Array");


        final Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nombreAlumno = findViewById(R.id.edtNombreAlumno);
                String nombreGuardar = nombreAlumno.getText().toString();

                int notaUnoGuardar=0;
                int notaDosGuardar=0;
                int notaTresGuardar=0;

                EditText nota1 = findViewById(R.id.edtNota1);
                notaUnoGuardar = Integer.parseInt(nota1.getText().toString());

                EditText nota2 = findViewById(R.id.edtNota2);
                notaDosGuardar = Integer.parseInt(nota2.getText().toString());

                EditText nota3 = findViewById(R.id.edtNota3);
                //if(!nota2.getText().toString().equals("")){
                notaTresGuardar = Integer.parseInt(nota3.getText().toString());
                //}

                Toast toast=Toast.makeText(getApplicationContext(),"Guardado con Exito",Toast.LENGTH_SHORT);
                toast.setMargin(1000,500);
                toast.show();


                nombresArray[contador] = nombreGuardar;
                nota1Array[contador] = notaUnoGuardar;
                nota2Array[contador] = notaDosGuardar;
                nota3Array[contador] = notaTresGuardar;

                contador++;

            }

        });
    }

        @Override
        public void onBackPressed(){

            Intent returnIntent = new Intent();
            returnIntent.putExtra("nombresArray", nombresArray);
            returnIntent.putExtra("nota1Array", nota1Array);
            returnIntent.putExtra("nota2Array", nota2Array);
            returnIntent.putExtra("nota3Array", nota3Array);
            returnIntent.putExtra("contador",contador);


            setResult(RESULT_OK, returnIntent);
            finish();

    }
}
