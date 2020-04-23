package com.example.proyectogorra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterGorra extends RecyclerView.Adapter<AdapterGorra.ViewHolderGorra> {
    ArrayList<String> listdatos;

    public AdapterGorra(ArrayList<String> listdatos) {
        this.listdatos = listdatos;
    }

    @NonNull
    @Override
    public ViewHolderGorra onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2,null,false);
        return new ViewHolderGorra(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGorra holder, int position) {
        holder.asignarDatos(listdatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listdatos.size();
    }

    public class ViewHolderGorra extends RecyclerView.ViewHolder {
        TextView dato;
        public ViewHolderGorra(@NonNull View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
