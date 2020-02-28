package com.example.gestiondenotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    Context context;
    float notaFinal;
    int contador;

    public RecyclerViewAdapter(Context con, String [] arrayNombres, int[] notaN1, int[] notaN2, int[] notaN3, int cont) {
        nombresArray = arrayNombres;
        nota1Array = notaN1;
        nota2Array = notaN2;
        nota3Array = notaN3;
        contador = cont;
        context = con;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_alumnos_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.etiquetaNom.setText(nombresArray[position]);
        holder.etiquetaNota1.setText(Integer.toString(nota1Array[position]));
        holder.etiquetaNota2.setText(Integer.toString(nota2Array[position]));
        holder.etiquetaNota3.setText(Integer.toString(nota3Array[position]));

        notaFinal = (nota1Array[position] + nota2Array[position] + nota3Array[position])/3;
        holder.etiquetaNotaFinal.setText(Float.toString(notaFinal));


    }

    @Override
    public int getItemCount() {
        return contador;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView etiquetaNom;
        TextView etiquetaNota1;
        TextView etiquetaNota2;
        TextView etiquetaNota3;
        TextView etiquetaNotaFinal;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            etiquetaNom = itemView.findViewById(R.id.nameStudent);
            layout = itemView.findViewById(R.id.layout);
            
            etiquetaNota1 = itemView.findViewById(R.id.txtnote1);

            etiquetaNota2 = itemView.findViewById(R.id.txtnote2);

            etiquetaNota3 = itemView.findViewById(R.id.txtnote3);

            etiquetaNotaFinal = itemView.findViewById(R.id.txtFinal);
        }

    }

}
