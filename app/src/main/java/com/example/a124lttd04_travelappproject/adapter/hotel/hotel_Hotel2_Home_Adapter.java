package com.example.a124lttd04_travelappproject.adapter.hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a124lttd04_travelappproject.R;

import java.util.List;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_CategoryHotel1_Home_Model;

public class hotel_Hotel2_Home_Adapter extends RecyclerView.Adapter<hotel_Hotel2_Home_Adapter.categoryViewHoder> {

    private Context context;
    private List<hotel_CategoryHotel1_Home_Model> mlistcategory;

    public hotel_Hotel2_Home_Adapter(Context context) {
        this.context = context;
    }
    public void setData(List<hotel_CategoryHotel1_Home_Model>  list){
        this.mlistcategory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public categoryViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_category,parent,false);

        return new categoryViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHoder holder, int position) {
        hotel_CategoryHotel1_Home_Model ctr = mlistcategory.get(position);
        if (ctr == null){
            return;
        }
        holder.textView.setText(ctr.getNameCategory());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);

        hotel_Hotel1_Home_Adapter adapter = new hotel_Hotel1_Home_Adapter();
        adapter.setData(ctr.getCardviews());


        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if (mlistcategory != null){
            return mlistcategory.size();
        }
        return 0;
    }

    public class categoryViewHoder extends RecyclerView.ViewHolder{

        private TextView textView;
        private RecyclerView recyclerView;

        public categoryViewHoder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_namecategory);
            recyclerView = itemView.findViewById(R.id.rcv_category);
        }

    }

}
