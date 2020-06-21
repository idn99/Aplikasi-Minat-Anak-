package com.idn99.project.bakatdanminatanak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.ModelCiriBakat;

import java.util.ArrayList;

public class CBListAdapter extends RecyclerView.Adapter<CBListAdapter.ViewHolder> {

    ArrayList<ModelCiriBakat> ciriBakats = new ArrayList<>();
    Context context;

    public CBListAdapter(ArrayList<ModelCiriBakat> ciriBakats, Context context) {
        this.ciriBakats = ciriBakats;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_pengenalan3,parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCiriBakat.setText(ciriBakats.get(position).getSoal_cb());
    }

    @Override
    public int getItemCount() {
        return ciriBakats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCiriBakat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCiriBakat = itemView.findViewById(R.id.tv_nama_pengenalan);
        }
    }
}
