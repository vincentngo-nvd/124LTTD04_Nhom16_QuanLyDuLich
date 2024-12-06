package com.example.a124lttd04_travelappproject.adapter.hotel;

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
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainRoom_Activity;

import java.text.DecimalFormat;
import java.util.List;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_khachsan_Model;

public class hotel_khachsan_Adapter extends RecyclerView.Adapter<hotel_khachsan_Adapter.CategoryViewHolder> {

    private final List<hotel_khachsan_Model> mListKhachsan;
    private final Context context;

    public hotel_khachsan_Adapter(Context context, List<hotel_khachsan_Model> mListKhachsan) {
        this.context = context;
        this.mListKhachsan = mListKhachsan;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_dskhachsan, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        hotel_khachsan_Model ks = mListKhachsan.get(position);
        if (ks == null) {
            return;
        }

        // Set hình ảnh
        String imageName = ks.getHinhanh().replace(".png", "");
        int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        holder.imgHotel.setImageResource(resId);

        // Set tên khách sạn
        holder.tvName.setText(ks.getTenkhachsan());

        // Set giá khách sạn
        double gia = ks.getGia(); // Lấy giá trị kiểu FLOAT từ API
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String giaHienThi = decimalFormat.format(gia);
        holder.tvPrice.setText(giaHienThi);

        // Sự kiện click vào item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, hotel_MainRoom_Activity.class);
            intent.putExtra("tenKhachSan", ks.getTenkhachsan()); // Truyền tên khách sạn
            intent.putExtra("maKhachSan", ks.getMakhachsan());  // Truyền mã khách sạn
            intent.putExtra("hinhanh", ks.getHinhanh());        // Truyền đường dẫn hoặc tên ảnh
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (mListKhachsan != null) {
            return mListKhachsan.size();
        }
        return 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgHotel;
        private final TextView tvName;
        private final TextView tvPrice;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHotel = itemView.findViewById(R.id.img_chooseHotel);
            tvName = itemView.findViewById(R.id.tv_nameChooseHotel);
            tvPrice = itemView.findViewById(R.id.tv_priceChoose);
        }
    }
}
