package com.idn99.project.bakatdanminatanak.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.activity.KeteranganKarakter;
import com.idn99.project.bakatdanminatanak.model.ModelKarakter;

import java.util.ArrayList;

public class KarakterListAdapter extends RecyclerView.Adapter<KarakterListAdapter.ViewHolder> {

    ArrayList<ModelKarakter> modelKarakters = new ArrayList<>();
    Context context;

    public KarakterListAdapter(ArrayList<ModelKarakter> modelKarakters, Context context) {
        this.modelKarakters = modelKarakters;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_pengenalan_design,parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvNama.setText(modelKarakters.get(position).getNama_karakter());
        holder.imgList.setBackgroundColor(Color.parseColor(modelKarakters.get(position).getWarna_karakter()));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, modelKarakters.get(position).getKet_karakter(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, KeteranganKarakter.class);
                intent.putExtra("id", modelKarakters.get(position).getId_karakter());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelKarakters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView tvNama;
        ImageView imgList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_pengenalan);
            layout = itemView.findViewById(R.id.layout_pengenalan);
            imgList = itemView.findViewById(R.id.img_list);
        }
    }
}
