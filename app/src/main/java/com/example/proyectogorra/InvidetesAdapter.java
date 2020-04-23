package com.example.proyectogorra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class InvidentesAdapter extends RecyclerView.Adapter<InvidentesAdapter.InvidenteViewHolder> {

    ArrayList<String> listInv;

    public InvidentesAdapter(ArrayList<String> listInv) {
        this.listInv = listInv;
    }

    public InvidentesAdapter(ListaActivity listaActivity, List<Invidentes> listainvidentes) {
    }

    @Override
    public InvidenteViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new InvidenteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvidenteViewHolder holder, int position) {
        holder.asignardatos(listInv.get(position));
    }

    @Override
    public int getItemCount() {
        return listInv.size();
    }

    public class InvidenteViewHolder extends RecyclerView.ViewHolder {
        TextView invidente;
        public InvidenteViewHolder(@NonNull View itemView) {
            super(itemView);
            invidente = itemView.findViewById(R.id.invidente);
        }

        public void asignardatos(String inv) {
            invidente.setText(inv);
        }
    }
}