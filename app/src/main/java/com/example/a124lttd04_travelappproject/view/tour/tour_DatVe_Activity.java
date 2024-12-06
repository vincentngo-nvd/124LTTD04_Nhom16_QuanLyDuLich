package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;

public class tour_DatVe_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_datve);

        // Bắt sự kiện click vào từng layout
        setupClickListeners();
    }

    // Phương thức để set sự kiện click cho các layout
    private void setupClickListeners() {
        LinearLayout firstProduct = findViewById(R.id.first_product_datve);

        LinearLayout secondProduct = findViewById(R.id.first_product_clickdatngaykhichuachonve);

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
                openChonSoLuongVeActivity();
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
        Intent intent = new Intent(tour_DatVe_Activity.this, tour_ChiTiet_Activity.class);
        startActivity(intent);
    }

    // Phương thức để mở giao diện activity_tour_chitiet.xml
    private void openDetailActivity() {
        Intent intent = new Intent(tour_DatVe_Activity.this, tour_DatVe_ClickDatNgayKhiChuaChonVe_Activity.class);
        startActivity(intent);
    }

    private void openChonSoLuongVeActivity() {
        Intent intent = new Intent(tour_DatVe_Activity.this, tour_DatVe_ChonSoLuongVe_Activity.class);
        startActivity(intent);
    }
}
