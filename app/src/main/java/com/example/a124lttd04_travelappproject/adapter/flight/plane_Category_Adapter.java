package com.example.a124lttd04_travelappproject.adapter.flight;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.plane_Category_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_TimKiemChuyenBay_Activity;

import java.util.List;

public class plane_Category_Adapter extends RecyclerView.Adapter<plane_Category_Adapter.CategoryViewHolder>{

    private Context mContext;
    private List<plane_Category_Model> mListcategory;

    public plane_Category_Adapter(Context mContext) {
        this.mContext = mContext;
    }


    public void setData(List<plane_Category_Model> list){
        this.mListcategory=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        plane_Category_Model category=mListcategory.get(position);
        if(category==null){
            return;
        }
        holder.tvNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);
        holder.rcvGiave.setLayoutManager(linearLayoutManager);

        plane_GiaVeNoiDia_Adapter GiaveAdapter=new plane_GiaVeNoiDia_Adapter();
        GiaveAdapter.setData(category.getGiave());
        holder.rcvGiave.setAdapter(GiaveAdapter);



        holder.itemView.setOnClickListener(v -> {
            // Handle click event here, such as starting a new activity
            Intent intent = new Intent(mContext, plane_TimKiemChuyenBay_Activity.class); // Chuyển sang giao diện khác

            // Thêm FLAG_ACTIVITY_NEW_TASK để tránh lỗi khi khởi động từ Adapter
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Truyền dữ liệu nếu cần
            // intent.putExtra("category", category);

            mContext.startActivity(intent); // Bắt đầu Activity mới
        });
    }

    @Override
    public int getItemCount() {
        if(mListcategory!=null){
            return mListcategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameCategory;
        private RecyclerView rcvGiave;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCategory = itemView.findViewById(R.id.tv_name_cotegory);
            rcvGiave=itemView.findViewById(R.id.rcv_giave);
        }
    }
}
