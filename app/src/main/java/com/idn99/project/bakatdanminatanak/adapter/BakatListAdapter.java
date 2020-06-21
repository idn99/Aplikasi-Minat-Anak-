package com.idn99.project.bakatdanminatanak.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.activity.KeteranganBakat;
import com.idn99.project.bakatdanminatanak.activity.KeteranganKarakter;
import com.idn99.project.bakatdanminatanak.model.ModelBakat;

import java.util.ArrayList;

public class BakatListAdapter extends RecyclerView.Adapter<BakatListAdapter.ViewHolder> {

    ArrayList<ModelBakat> bakats = new ArrayList<>();
    Context context;

    public BakatListAdapter(ArrayList<ModelBakat> bakats, Context context) {
        this.bakats = bakats;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_pengenalan_2,parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvNamabakat.setText(bakats.get(position).getNama_bakat());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, bakats.get(position).getNama_bakat(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, KeteranganBakat.class);
                intent.putExtra("id", bakats.get(position).getId_bakat());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bakats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamabakat;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamabakat = itemView.findViewById(R.id.tv_nama_pengenalan);
            layout = itemView.findViewById(R.id.layout_pengenalan);
        }
    }
}
