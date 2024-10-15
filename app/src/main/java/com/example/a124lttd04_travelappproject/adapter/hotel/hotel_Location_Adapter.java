package com.example.a124lttd04_travelappproject.adapter.hotel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a124lttd04_travelappproject.R;

import java.util.List;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_CgrLocation1_Home_Model;

public class hotel_Location_Adapter extends RecyclerView.Adapter<hotel_Location_Adapter.locationHolder> {

    private List<hotel_CgrLocation1_Home_Model> mlistLocation;

    public void setData(List<hotel_CgrLocation1_Home_Model> list){
        this.mlistLocation = list ;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public locationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_local,parent,false);
        return new locationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull locationHolder holder, int position) {
        hotel_CgrLocation1_Home_Model location = mlistLocation.get(position);
        if(location == null){
            return;
        }
        holder.imgLocation.setImageResource(location.getImgLocation());
        holder.txtLocation.setText(location.getNameLocation());
        holder.txtSum.setText(location.getSum());
    }

    @Override
    public int getItemCount() {
        if ( mlistLocation != null){
            return mlistLocation.size();
        }
        return 0;
    }

    public class locationHolder extends RecyclerView.ViewHolder{

        private ImageView imgLocation;
        private TextView txtLocation;
        private TextView txtSum;

        public locationHolder(@NonNull View itemView) {
            super(itemView);
            imgLocation = itemView.findViewById(R.id.img_location);
            txtLocation = itemView.findViewById(R.id.txt_location);
            txtSum  = itemView.findViewById(R.id.txt_sum);
        }
    }

    public static class model_CategoryPay {
        private String name;

        public model_CategoryPay(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
