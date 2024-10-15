package com.example.a124lttd04_travelappproject.adapter.tour;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.tour.tour_ChuyenBay_Model;
import com.example.a124lttd04_travelappproject.view.tour.tour_CoTheBanSeThich_Activity;

import java.util.List;

public class tour_ChuyenBay_Adapter extends RecyclerView.Adapter <tour_ChuyenBay_Adapter.ChuyenBayViewHolder>{
    private List<tour_ChuyenBay_Model> mChuyenBayList;

    public tour_ChuyenBay_Adapter(List<tour_ChuyenBay_Model> mChuyenBayList) {
        this.mChuyenBayList = mChuyenBayList;
    }

    @NonNull
    @Override
    public ChuyenBayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new ChuyenBayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuyenBayViewHolder holder, int position) {
        tour_ChuyenBay_Model chuyenBay = mChuyenBayList.get(position);
        if (chuyenBay == null) {
            return;
        }
        holder.tvTenChuyenBay.setText(chuyenBay.getTenChuyenBay());
        holder.tvDiaDiem.setText(chuyenBay.getDiaDiem());
        holder.tvThoiGian.setText(chuyenBay.getThoiGian());
        holder.tvGia.setText(chuyenBay.getGia());

        holder.imgChuyenBay.setImageResource(chuyenBay.getHinhAnh());

        holder.itemView.setOnClickListener(v -> {
            // Handle click event here, such as starting a new activity
            Intent intent = new Intent((Context) mChuyenBayList, tour_CoTheBanSeThich_Activity.class); // Chuyển sang giao diện khác

            // Thêm FLAG_ACTIVITY_NEW_TASK để tránh lỗi khi khởi động từ Adapter
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Truyền dữ liệu nếu cần
            // intent.putExtra("category", category);

            ((Context) mChuyenBayList).startActivity(intent); // Bắt đầu Activity mới
        });
    }

    @Override
    public int getItemCount() {
        if (mChuyenBayList != null) {
            return mChuyenBayList.size();
        }
        return 0;
    }

    class ChuyenBayViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgChuyenBay;
        private TextView tvTenChuyenBay, tvDiaDiem, tvThoiGian, tvGia;

        public ChuyenBayViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenChuyenBay = itemView.findViewById(R.id.tenChuyenBay_tv);
            tvDiaDiem = itemView.findViewById(R.id.diaDiem_tv);
            tvThoiGian = itemView.findViewById(R.id.thoiGian_tv);
            tvGia = itemView.findViewById(R.id.gia_tv);
            imgChuyenBay = itemView.findViewById(R.id.imgChuyenBay);
        }
    }
}
