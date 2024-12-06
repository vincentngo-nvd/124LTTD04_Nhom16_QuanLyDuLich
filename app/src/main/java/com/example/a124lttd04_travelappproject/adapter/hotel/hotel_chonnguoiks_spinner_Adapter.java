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

import com.example.a124lttd04_travelappproject.model.hotel.hotel_diadiemks_Model;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_phongkhachsan_Model;

public class hotel_chonnguoiks_spinner_Adapter extends ArrayAdapter<hotel_phongkhachsan_Model> {
    public hotel_chonnguoiks_spinner_Adapter(@NonNull Context context, int resource, @NonNull List<hotel_phongkhachsan_Model> objects) {

        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_chonnguoi2,parent,false);
        TextView tvSelected = convertView.findViewById(R.id.spn_chonnguoi);
        hotel_phongkhachsan_Model category = this.getItem(position);
        if(category != null){
            tvSelected.setText(String.valueOf(category.getSoluongnguoi()));
        }
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_chonnguoi1,parent,false);
        TextView tvCategory = convertView.findViewById(R.id.tv_chonsonguoi);
        hotel_phongkhachsan_Model phongkhachsanModel = this.getItem(position);
        if(phongkhachsanModel != null){
            tvCategory.setText(String.valueOf(phongkhachsanModel.getSoluongnguoi()));
        }
        return convertView;

    }


}
