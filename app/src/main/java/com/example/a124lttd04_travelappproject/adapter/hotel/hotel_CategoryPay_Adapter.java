package com.example.a124lttd04_travelappproject.adapter.hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.a124lttd04_travelappproject.R;

import java.util.List;

public class hotel_CategoryPay_Adapter extends ArrayAdapter<hotel_Location_Adapter.model_CategoryPay> {


    public hotel_CategoryPay_Adapter(@NonNull Context context, int resource, @NonNull List<hotel_Location_Adapter.model_CategoryPay> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_selected_pay2,parent,false);
        TextView tvSelected = convertView.findViewById(R.id.tv_selectedRoomPay);
        hotel_Location_Adapter.model_CategoryPay category = this.getItem(position);
        if(category != null){
            tvSelected.setText(category.getName());
        }
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_selected_pay1,parent,false);
        TextView tvCategory = convertView.findViewById(R.id.tv_searchRoomPay);
        hotel_Location_Adapter.model_CategoryPay category = this.getItem(position);
        if(category != null){
            tvCategory.setText(category.getName());
        }
        return convertView;

    }


}
