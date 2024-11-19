package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;

public class tour_DanhGiaSanPham extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danhgiasanpham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupClickListeners();
    }

    private void setupClickListeners() {
        TextView danhGiaSanPham_DanhGia = findViewById(R.id.danhgiasanpham_danhgia);

        danhGiaSanPham_DanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDaDatGanDayPageActivity();
                showToastMessage();
            }
        });
    }

    private void openDaDatGanDayPageActivity() {
        Intent intent = new Intent(tour_DanhGiaSanPham.this, tour_DaDatGanDay.class);
        startActivity(intent);
    }

    private void showToastMessage() {
        Toast.makeText(tour_DanhGiaSanPham.this, "Bạn đã đánh giá thành công!", Toast.LENGTH_SHORT).show();
    }
}
