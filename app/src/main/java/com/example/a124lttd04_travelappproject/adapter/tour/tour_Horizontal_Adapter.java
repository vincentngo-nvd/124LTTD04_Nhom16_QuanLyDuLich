package com.example.a124lttd04_travelappproject.adapter.tour;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.tour.tour_City_Model;
import com.example.a124lttd04_travelappproject.view.tour.tour_CoTheBanSeThich_Activity;

import java.util.List;

public class tour_Horizontal_Adapter extends RecyclerView.Adapter<tour_Horizontal_Adapter.HorizontalViewHolder> {

    private List<tour_City_Model> mCityList;
    private Context mContext;

    public tour_Horizontal_Adapter(List<tour_City_Model> cityList, Context context) {
        this.mCityList = cityList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        tour_City_Model city = mCityList.get(position);
        if (city != null) {
            holder.tvCityName.setText(city.getName());

            // Set hình nền (ảnh) khác nhau cho từng item
            holder.itemView.setBackgroundResource(city.getImageResource());

            // Set click listener for each item
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent to start CoTheBanSeThich_Activity
                    Intent intent = new Intent(mContext, tour_CoTheBanSeThich_Activity.class);
                    intent.putExtra("city_name", city.getName());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public static class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView tvCityName;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCityName = itemView.findViewById(R.id.tvCityName);
        }
    }
}
