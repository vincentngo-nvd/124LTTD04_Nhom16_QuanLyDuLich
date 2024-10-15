package com.example.a124lttd04_travelappproject.adapter.hotel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainRoom_Activity;

import java.util.List;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_ChooseHotel_Hotel_Model;

public class hotel_ChooseHotel_Hotel_Adapter extends RecyclerView.Adapter<hotel_ChooseHotel_Hotel_Adapter.CategoryViewHolder> {

    private Context context;
    private List<hotel_ChooseHotel_Hotel_Model> mCategory;

    public hotel_ChooseHotel_Hotel_Adapter(Context context) {
        this.context = context;
    }
    public void setData(List<hotel_ChooseHotel_Hotel_Model> list){
        this.mCategory = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_chooseroom,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        hotel_ChooseHotel_Hotel_Model category = mCategory.get(position);
        if(category== null){
            return;
        }
        holder.imgHotel.setImageResource(category.getImgHotel());
        holder.imgFiveStar.setImageResource(category.getImgFiveStar());
        holder.tvName.setText(category.getTvName());
        holder.tvLocation.setText(category.getTvLocation());
        holder.tvPrice.setText(category.getTvPrice());

        holder.itemView.setOnClickListener(v -> {
            // Handle click event here, such as starting a new activity
            Intent intent = new Intent(context, hotel_MainRoom_Activity.class); // Chuyển sang giao diện khác

            // Thêm FLAG_ACTIVITY_NEW_TASK để tránh lỗi khi khởi động từ Adapter
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Truyền dữ liệu nếu cần
            // intent.putExtra("category", category);

            context.startActivity(intent); // Bắt đầu Activity mới
        });

        // Nếu muốn thêm sự kiện khi bấm vào nút "Chọn"
//        holder.btnChoose.setOnClickListener(v -> {
//            Toast.makeText(context, "Bạn đã chọn khách sạn: " + category.getTvName(), Toast.LENGTH_SHORT).show();
//        });
    }

    @Override
    public int getItemCount() {
        if (mCategory != null){
            return mCategory.size();
        }
        return 0;
    }

    public  class CategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgHotel;
        private ImageView imgFiveStar;
        private TextView tvName;
        private TextView tvLocation;
        private TextView tvPrice;
        private Button btnChoose;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHotel = itemView.findViewById(R.id.img_chooseHotel);
            imgFiveStar = itemView.findViewById(R.id.img_fiveStarChoose);
            tvName = itemView.findViewById(R.id.tv_nameChooseHotel);
            tvLocation = itemView.findViewById(R.id.tv_locationChoose);
            tvPrice = itemView.findViewById(R.id.tv_priceChoose);

        }
    }

}
