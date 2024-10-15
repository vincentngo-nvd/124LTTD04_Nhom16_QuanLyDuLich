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

import com.example.a124lttd04_travelappproject.model.hotel.hotel_CgrLocation2_Home_Model;

public class hotel_CgrLocation_Adapter extends RecyclerView.Adapter<hotel_CgrLocation_Adapter.cgrLocationViewHolder> {

    private Context context;
    private List<hotel_CgrLocation2_Home_Model> cgrLocations;

    public hotel_CgrLocation_Adapter(Context context) {
        this.context = context;
    }
    public void  setDataLocation(List<hotel_CgrLocation2_Home_Model> list){
        this.cgrLocations = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public cgrLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_categorylocation,parent,false);

        return new cgrLocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cgrLocationViewHolder holder, int position) {

        hotel_CgrLocation2_Home_Model cgrlocation = cgrLocations.get(position);
        if (cgrlocation == null){
            return;
        }
        holder.textView.setText(cgrlocation.getTextView());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);

        hotel_Location_Adapter lcAdapter = new hotel_Location_Adapter();
        lcAdapter.setData(cgrlocation.getLocations());


        holder.recyclerView.setAdapter(lcAdapter);

    }

    @Override
    public int getItemCount() {
        if (cgrLocations != null){
            return  cgrLocations.size();
        }
        return 0;
    }

    public class cgrLocationViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private RecyclerView recyclerView;

        public cgrLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_nameCategoryLocation);
            recyclerView = itemView.findViewById(R.id.rcv_categoryLocation);
        }
    }
}
