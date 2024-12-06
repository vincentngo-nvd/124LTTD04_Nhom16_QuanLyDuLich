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
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainInf_Activity;

import java.text.DecimalFormat;
import java.util.List;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_phongkhachsan_Model;

public class hotel_phongkhachsan_Adapter extends RecyclerView.Adapter<hotel_phongkhachsan_Adapter.chooseRoomViewHolder> {

    private Context context;
    private List<hotel_phongkhachsan_Model> mListPhong;

    public hotel_phongkhachsan_Adapter(Context context, List<hotel_phongkhachsan_Model> mListPhong) {
        this.context = context;
        this.mListPhong = mListPhong;
    }

    @NonNull
    @Override
    public chooseRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_datphong,parent,false);
        return new chooseRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chooseRoomViewHolder holder, int position) {
        hotel_phongkhachsan_Model listPhong = mListPhong.get(position);
        if (listPhong == null){
            return;
        }
        String imageName = listPhong.getHinhanh().replace(".png", "");
        int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        holder.imgRoom.setImageResource(resId);
        holder.tvNameRoom.setText(listPhong.getTenphong());
        holder.tvPerson.setText(String.valueOf(listPhong.getSoluongnguoi()+" người"));
        double gia = listPhong.getGiaphong(); // Lấy giá trị kiểu FLOAT từ API
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String giaHienThi = decimalFormat.format(gia);
        holder.tvPriceRoom.setText(giaHienThi + " VND");
        holder.itemView.setOnClickListener(v -> {
            // Handle click event here, such as starting a new activity
            Intent intent = new Intent(context, hotel_MainInf_Activity.class); // Chuyển sang giao diện khác

            // Thêm FLAG_ACTIVITY_NEW_TASK để tránh lỗi khi khởi động từ Adapter
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Truyền dữ liệu nếu cần
            // intent.putExtra("category", category);

            context.startActivity(intent); // Bắt đầu Activity mới
        });
    }

    @Override
    public int getItemCount() {
        if ( mListPhong != null){
            return  mListPhong.size();
        }
        return 0;
    }

    public class chooseRoomViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgRoom;
        private TextView tvNameRoom,tvPerson,tvPriceRoom;
        public chooseRoomViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRoom = itemView.findViewById(R.id.img_room);
            tvNameRoom = itemView.findViewById(R.id.tv_nameRoom);
            tvPerson = itemView.findViewById(R.id.tv_songuoi);
            tvPriceRoom = itemView.findViewById(R.id.tv_priceRoom);

        }
    }
}
