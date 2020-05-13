package com.idn99.project.bakatdanminatanak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Anggota;

import java.util.ArrayList;

public class AboutListAdapter extends RecyclerView.Adapter<AboutListAdapter.AboutViewHolder> {

    ArrayList<Anggota> anggotas;

    public AboutListAdapter(ArrayList<Anggota> anggotas) {
        this.anggotas = anggotas;
    }

    @NonNull
    @Override
    public AboutListAdapter.AboutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.design_list_anggota,parent, false);
        return new AboutViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutListAdapter.AboutViewHolder holder, int position) {
        holder.imgAng.setImageResource(anggotas.get(position).getFotoAnggota());
        holder.namaAng.setText(anggotas.get(position).getNamaAnggota());
        holder.nimAng.setText(anggotas.get(position).getNimAnggota());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return anggotas.size();
    }

    public class AboutViewHolder extends RecyclerView.ViewHolder{

        ImageView imgAng;
        TextView namaAng , nimAng;
        int position;

        public AboutViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAng = itemView.findViewById(R.id.foto_anggota);
            namaAng = itemView.findViewById(R.id.nama_anggota);
            nimAng = itemView.findViewById(R.id.nim_anggota);
        }
    }
}
