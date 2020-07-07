package com.idn99.project.bakatdanminatanak.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.activity.History;
import com.idn99.project.bakatdanminatanak.activity.Result;
import com.idn99.project.bakatdanminatanak.model.ModelHasil;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    ArrayList<ModelHasil> hasil = new ArrayList<>();
    Context context;

    public HistoryListAdapter(ArrayList<ModelHasil> hasil, Context context) {
        this.hasil = hasil;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.list_history_design,parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tvNama.setText(hasil.get(position).getNama_anak());
        holder.tvGenderAge.setText(hasil.get(position).getGender_anak()+" | "+hasil.get(position).getUmur_anak()+" Tahun");
        holder.tvBakKar.setText(hasil.get(position).getNama_kar()+" | "+hasil.get(position).getNama_bakat());
        holder.imageKar.setBackgroundColor(Color.parseColor(hasil.get(position).getWarnaKarakter()));

        Resources res = context.getResources();
        int resID = res.getIdentifier( hasil.get(position).getGambar_bakat() , "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resID );
        holder.imgUser.setImageDrawable(drawable);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idAnak = hasil.get(position).getId_anak();
                Intent intent = new Intent(context, Result.class);
                intent.putExtra("id_anak", idAnak);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hasil.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvGenderAge, tvBakKar;
        ImageView imageKar, imgUser;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_history_nama);
            tvGenderAge = itemView.findViewById(R.id.tv_history_jk_age);
            tvBakKar = itemView.findViewById(R.id.tv_history_bkt_kar);
            imageKar = itemView.findViewById(R.id.img_history_kar);
            imgUser = itemView.findViewById(R.id.img_history_user);
            layout = itemView.findViewById(R.id.history_layout);
        }
    }
}
