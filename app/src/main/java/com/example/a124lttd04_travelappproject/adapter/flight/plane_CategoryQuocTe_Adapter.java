package com.example.a124lttd04_travelappproject.adapter.flight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a124lttd04_travelappproject.R;

import java.util.List;

import com.example.a124lttd04_travelappproject.model.flight.plane_CategoryQuocte_Model;

public class plane_CategoryQuocTe_Adapter extends RecyclerView.Adapter<plane_CategoryQuocTe_Adapter.CategoryViewHolder>{
    private Context mContext;
    private List<plane_CategoryQuocte_Model> mListcategory;

    public plane_CategoryQuocTe_Adapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        plane_CategoryQuocte_Model category=mListcategory.get(position);
        if(category==null){
            return;
        }
        holder.tvNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);
        holder.rcvGiave.setLayoutManager(linearLayoutManager);

        plane_GiaVeQuocTe_Adapter GiaveAdapter=new plane_GiaVeQuocTe_Adapter();
        GiaveAdapter.setData(category.getGiave());
        holder.rcvGiave.setAdapter(GiaveAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListcategory!=null){
            return mListcategory.size();
        }
        return 0;
    }

    public void setData(List<plane_CategoryQuocte_Model> list){
        this.mListcategory=list;
        notifyDataSetChanged();
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
