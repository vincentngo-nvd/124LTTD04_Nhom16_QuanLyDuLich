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

import com.example.a124lttd04_travelappproject.model.hotel.hotel_CategoryHotel2_Home_Model;

public class hotel_Hotel1_Home_Adapter extends  RecyclerView.Adapter<hotel_Hotel1_Home_Adapter.AdapterHolder> {



    private List<hotel_CategoryHotel2_Home_Model> mList;


    public  void setData(List<hotel_CategoryHotel2_Home_Model> list){
        this.mList=list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_hotel,parent,false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        hotel_CategoryHotel2_Home_Model cardview = mList.get(position);
        if(cardview == null){
            return;
        }
        holder.imgHotel.setImageResource(cardview.getResoureImage());
        holder.imgStar.setImageResource(cardview.getIconStar());
        holder.nameHotel.setText(cardview.getNameHotel());
        holder.priceHotel.setText(cardview.getPrice());
    }

    @Override
    public int getItemCount() {
        if (mList != null){
            return mList.size();
        }
        return 0;
    }

    public  class AdapterHolder extends RecyclerView.ViewHolder{

        private ImageView imgHotel;
        private ImageView imgStar;
        private TextView nameHotel;
        private TextView priceHotel;


        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            imgHotel = itemView.findViewById(R.id.img_hotel);
            imgStar = itemView.findViewById(R.id.five_star);
            nameHotel = itemView.findViewById(R.id.txt_hotel);
            priceHotel = itemView.findViewById(R.id.price);
        }
    }
}
