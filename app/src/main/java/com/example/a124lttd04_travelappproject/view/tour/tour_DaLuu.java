package com.example.a124lttd04_travelappproject.view.tour;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;

public class tour_DaLuu extends AppCompatActivity {
    private boolean isLoved = false; // Trạng thái yêu thích
    private LinearLayout itemsDaluuContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daluu);

        // Khai báo LinearLayout nơi sẽ hiển thị các item yêu thích
        itemsDaluuContainer = findViewById(R.id.items_daluu);

        // Ẩn itemsDaluuContainer khi bắt đầu
        itemsDaluuContainer.setVisibility(View.GONE);

        // Lấy thông tin sản phẩm yêu thích từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FavoriteItems", MODE_PRIVATE);
        String itemName = sharedPreferences.getString("item_name", null);
        String itemPrice = sharedPreferences.getString("item_price", null);
        int itemImage = sharedPreferences.getInt("item_image", -1);  // Giá trị mặc định nếu không có
        String itemXperienceDeal = sharedPreferences.getString("item_xperiencedeal", null);
        String itemTextGach = sharedPreferences.getString("item_textgach", null);

        // Kiểm tra xem có thông tin yêu thích hợp lệ không
        if (itemName != null && itemPrice != null && itemImage != -1) {
            // Inflate layout favorite_item.xml
            View favoriteItemView = getLayoutInflater().inflate(R.layout.favorite_item, null);

            // Cập nhật thông tin vào favorite_item
            TextView itemNameView = favoriteItemView.findViewById(R.id.favorite_item_name);
            TextView itemPriceView = favoriteItemView.findViewById(R.id.favorite_item_price);
            ImageView itemImageView = favoriteItemView.findViewById(R.id.favorite_item_image);
            TextView itemXperienceDealView = favoriteItemView.findViewById(R.id.xperiencedeal);
            TextView itemTextGachView = favoriteItemView.findViewById(R.id.textgach);

            // Gán giá trị vào các TextView
            itemNameView.setText(itemName);
            itemPriceView.setText(itemPrice);
            itemImageView.setImageResource(itemImage);
            itemXperienceDealView.setText(itemXperienceDeal);
            itemTextGachView.setText(itemTextGach);

            // Thêm item vào container
            itemsDaluuContainer.addView(favoriteItemView);

            // Hiển thị LinearLayout chứa các item yêu thích
            itemsDaluuContainer.setVisibility(View.VISIBLE);
        }
    }

    private void addFavoriteItem() {
        // Sử dụng LayoutInflater để thêm giao diện từ favorite_item.xml
        LayoutInflater inflater = LayoutInflater.from(this);
        View favoriteItem = inflater.inflate(R.layout.favorite_item, itemsDaluuContainer, false);

        // Thêm vào LinearLayout container
        itemsDaluuContainer.addView(favoriteItem);
    }
}
