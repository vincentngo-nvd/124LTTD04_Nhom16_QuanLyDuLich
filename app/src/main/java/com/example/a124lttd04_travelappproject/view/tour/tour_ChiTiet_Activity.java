package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;

public class tour_ChiTiet_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_chitiet);

        // Bắt sự kiện click vào từng layout
        setupClickListeners();
    }

    // Phương thức để set sự kiện click cho các layout
    private void setupClickListeners() {
        LinearLayout firstProduct = findViewById(R.id.first_product_chitiet);
        LinearLayout secondProduct = findViewById(R.id.second_product_chitiet);
        LinearLayout thirdProduct = findViewById(R.id.third_product_chitiet);

        // Set sự kiện cho mỗi layout
        firstProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        secondProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        final ScrollView scrollView = findViewById(R.id.scrollView);

        // Set sự kiện cho layout thứ 3 để scroll đến layout đầu tiên
        thirdProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuộn mượt đến vị trí của layout đầu tiên
                scrollView.smoothScrollTo(0, firstProduct.getTop());
            }
        });

        ImageView backButton = findViewById(R.id.back_button);

        // Set the click listener for the ImageView
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to DatVe_DatCho_Activity
                openDatChoActivity();
            }
        });
    }

    // Phương thức để mở giao diện activity_tour_chitiet.xml
    private void openDatChoActivity() {
        Intent intent = new Intent(tour_ChiTiet_Activity.this, tour_CoTheBanSeThich_Activity.class);
        startActivity(intent);
    }

    // Phương thức để mở giao diện activity_tour_chitiet.xml
    private void openDetailActivity() {
        Intent intent = new Intent(tour_ChiTiet_Activity.this, tour_DatVe_Activity.class);
        startActivity(intent);
    }
}
