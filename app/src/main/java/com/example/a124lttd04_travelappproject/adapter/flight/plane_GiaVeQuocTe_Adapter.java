package com.example.a124lttd04_travelappproject.adapter.flight;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeQuocTe_Model;

import java.util.List;

public class plane_GiaVeQuocTe_Adapter extends RecyclerView.Adapter<plane_GiaVeQuocTe_Adapter.GiaVeViewHolder>{
    private List<plane_GiaVeQuocTe_Model> Giave;
    public void setData(List<plane_GiaVeQuocTe_Model> list){
        this.Giave=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GiaVeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_giavenoidia,parent,false);
        return new GiaVeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiaVeViewHolder holder, int position) {
        plane_GiaVeQuocTe_Model giave= Giave.get(position);
        if(giave==null){
            return;
        }
        holder.imgGiave.setImageResource(giave.getID());
        holder.tvTitle.setText(giave.getTitle());
        holder.tvDate.setText(giave.getNgay());
        holder.tvGia.setText(giave.getGia());
    }

    @Override
    public int getItemCount() {
        if(Giave!=null){
            return Giave.size();
        }
        return 0;
    }
    public class GiaVeViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgGiave;
        public TextView tvTitle;
        public TextView tvDate;
        public TextView tvGia;
        public GiaVeViewHolder(@NonNull View itemView) {
            super(itemView);

            imgGiave=itemView.findViewById(R.id.anh);
            tvTitle=itemView.findViewById(R.id.title);
            tvDate=itemView.findViewById(R.id.date);
            tvGia=itemView.findViewById(R.id.gia);
        }
    }
}
