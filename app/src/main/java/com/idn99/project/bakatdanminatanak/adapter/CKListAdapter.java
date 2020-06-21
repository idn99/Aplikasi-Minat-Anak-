package com.idn99.project.bakatdanminatanak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.ModelCiriKarakter;

import java.util.ArrayList;

public class CKListAdapter extends RecyclerView.Adapter<CKListAdapter.ViewHolder> {

    ArrayList<ModelCiriKarakter> ciriKarakters = new ArrayList<>();
    Context context;

    public CKListAdapter(ArrayList<ModelCiriKarakter> ciriKarakters, Context context) {
        this.ciriKarakters = ciriKarakters;
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
        holder.tvCiriKarakter.setText(ciriKarakters.get(position).getSoal_ck());
    }

    @Override
    public int getItemCount() {
        return ciriKarakters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCiriKarakter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCiriKarakter = itemView.findViewById(R.id.tv_nama_pengenalan);
        }
    }
}
