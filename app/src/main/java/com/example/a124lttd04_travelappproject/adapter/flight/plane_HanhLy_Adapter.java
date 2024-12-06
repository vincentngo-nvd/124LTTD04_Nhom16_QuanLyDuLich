package com.example.a124lttd04_travelappproject.adapter.flight;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.HanhLyModel;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeNoiDia_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_TimKiemChuyenBay_Activity;
import com.example.a124lttd04_travelappproject.view.flight.plane_XacNhanGiaChuyenBay_Activity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class plane_HanhLy_Adapter extends RecyclerView.Adapter<plane_HanhLy_Adapter.HanhLyViewHolder> {

    private List<HanhLyModel> HanhLy;
    public void setData(List<HanhLyModel> list) {
        this.HanhLy = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HanhLyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_listhanhly, parent, false);
        return new HanhLyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HanhLyViewHolder holder, int position) {
        HanhLyModel hanhly = HanhLy.get(position);
        if (hanhly == null) {
            return;
        }
        double gia = hanhly.getGiatien();
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String giaHienThi = decimalFormat.format(gia) + " VND"; // Thêm đơn vị VND

        holder.khoiluong.setText(String.valueOf(hanhly.getKhoiluong())+" KG"); // Đặt chuỗi định dạng vào TextView
        holder.giatien.setText(giaHienThi);

        // Thiết lập listener cho itemView
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext(); // Lấy context từ view
            Intent intent = new Intent(context, plane_XacNhanGiaChuyenBay_Activity.class); // Thay YourTargetActivity bằng Activity mà bạn muốn chuyển tới
            intent.putExtra("khoiluong", String.valueOf(hanhly.getKhoiluong())+" KG"); // Truyền giá trị khoiluong
            intent.putExtra("Tongtien", giaHienThi);
            context.startActivity(intent); // Khởi động Activity mới
        });
    }

    @Override
    public int getItemCount() {
        return HanhLy != null ? HanhLy.size() : 0;
    }


    public class HanhLyViewHolder extends RecyclerView.ViewHolder {
        public TextView  khoiluong;
        public TextView  giatien;

        public HanhLyViewHolder(@NonNull View itemView) {
            super(itemView);
            khoiluong = itemView.findViewById(R.id.khoiluong);
            giatien = itemView.findViewById(R.id.tongtien);
        }
    }
}