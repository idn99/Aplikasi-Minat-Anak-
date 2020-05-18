package com.idn99.project.bakatdanminatanak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Anak;

import java.util.ArrayList;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.HistoryViewHolder> {

    ArrayList<Anak> anak = new ArrayList<>();

    public AdapterHistory(ArrayList<Anak> anak) {
        this.anak = anak;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.design_hsitory,parent, false);
        return new HistoryViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {

        holder.tvNama.setText(anak.get(position).getNama());
        holder.position = position;

    }

    @Override
    public int getItemCount() {
        return anak.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama;
        private LinearLayout layoutHistory;
        private int position;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama_history);
            layoutHistory = itemView.findViewById(R.id.layout_history);
        }
    }
}
