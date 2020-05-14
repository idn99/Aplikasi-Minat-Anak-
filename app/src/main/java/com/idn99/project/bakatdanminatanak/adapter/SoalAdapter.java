package com.idn99.project.bakatdanminatanak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Jawaban;
import com.idn99.project.bakatdanminatanak.model.Pertanyaan;

import java.util.ArrayList;

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.SoalViewHolder>{

    private ArrayList<Pertanyaan> pertanyaans = new ArrayList<>();
    private Context ctx;
    private Jawaban jawaban;
    private Boolean isEmpty;

    public SoalAdapter(ArrayList<Pertanyaan> pertanyaans, Context ctx) {
        this.pertanyaans = pertanyaans;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public SoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.design_soal,parent, false);
        return new SoalViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull SoalViewHolder holder, int position) {
        holder.position = position;
        holder.tvSoal.setText(pertanyaans.get(position).getSoal());
    }

    @Override
    public int getItemCount() {
        return pertanyaans.size();
    }

    public Boolean getIsEmpty(){
        return isEmpty;
    }

    public Jawaban getJawaban() {
        return jawaban;
    }

    public class SoalViewHolder extends RecyclerView.ViewHolder {
        private int position;
        private TextView tvSoal;
        private RadioButton rdYes, rdNo;
        private RadioGroup rdGroup;

        SoalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSoal = itemView.findViewById(R.id.tv_soal);
            rdYes = itemView.findViewById(R.id.rd_yes);
            rdNo = itemView.findViewById(R.id.rd_no);
            rdGroup = itemView.findViewById(R.id.rd_group_soal);
//            rdGroup.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (rdGroup.getCheckedRadioButtonId()==R.id.rd_yes){
//                        jawaban = new Jawaban(1);
//                        isEmpty = false;
//                    }else if (rdGroup.getCheckedRadioButtonId()==R.id.rd_no){
//                        jawaban = new Jawaban(0);
//                        isEmpty = false;
//                    }else{
//                        isEmpty = true;
//                    }
//                }
//            });

            rdYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jawaban = new Jawaban(1);
                    isEmpty = false;
                }
            });

            rdNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jawaban = new Jawaban(0);
                    isEmpty = false;
                }
            });
        }
    }
}
