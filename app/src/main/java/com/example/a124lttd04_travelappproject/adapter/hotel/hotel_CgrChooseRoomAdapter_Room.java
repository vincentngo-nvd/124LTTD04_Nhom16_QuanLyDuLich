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

import java.util.List;

import com.example.a124lttd04_travelappproject.model.hotel.hotel_CgrChooseRoom_Room_Model;

public class hotel_CgrChooseRoomAdapter_Room extends RecyclerView.Adapter<hotel_CgrChooseRoomAdapter_Room.chooseRoomViewHolder> {

    private Context context;
    private List<hotel_CgrChooseRoom_Room_Model> cgrChooseRoomList;

    public hotel_CgrChooseRoomAdapter_Room(Context context) {
        this.context = context;
    }

    public void  setData(List<hotel_CgrChooseRoom_Room_Model> list){
        this.cgrChooseRoomList = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public chooseRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item_datphong,parent,false);
        return new chooseRoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chooseRoomViewHolder holder, int position) {
        hotel_CgrChooseRoom_Room_Model cgr = cgrChooseRoomList.get(position);
        if (cgr == null){
            return;
        }
        holder.imgRoom.setImageResource(cgr.getImgRoom());
        holder.iconBed.setImageResource(cgr.getIconBed());
        holder.iconAir.setImageResource(cgr.getIconAir());
        holder.iconWifi.setImageResource(cgr.getIconWifi());
        holder.tvNameRoom.setText(cgr.getTvNameRoom());
        holder.tvPerson.setText(cgr.getTvPerson());
        holder.tvWifi.setText(cgr.getTvWifi());
        holder.tvAir.setText(cgr.getTvAir());
        holder.tvPriceRoom.setText(cgr.getTvPriceRoom());
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
        if ( cgrChooseRoomList != null){
            return  cgrChooseRoomList.size();
        }
        return 0;
    }

    public class chooseRoomViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgRoom,iconBed,iconWifi,iconAir;
        private TextView tvNameRoom,tvPerson,tvWifi,tvAir,tvPriceRoom;
        public chooseRoomViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRoom = itemView.findViewById(R.id.img_room);
            iconBed = itemView.findViewById(R.id.icon_bed);
            iconWifi = itemView.findViewById(R.id.icon_wifi);
            iconAir = itemView.findViewById(R.id.icon_air);
            tvNameRoom = itemView.findViewById(R.id.tv_nameRoom);
            tvPerson = itemView.findViewById(R.id.tv_bed);
            tvWifi = itemView.findViewById(R.id.tv_wifi);
            tvAir = itemView.findViewById(R.id.tv_air);
            tvPriceRoom = itemView.findViewById(R.id.tv_priceRoom);

        }
    }
}
