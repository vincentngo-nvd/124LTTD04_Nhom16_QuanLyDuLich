package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class tour_MaGiamGia extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_magiamgia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupClickListeners();
    }

    private void setupClickListeners() {

        TextView maGiamGia_DanhGiaSanPham = findViewById(R.id.magiamgia_danhgiasanpham);
        maGiamGia_DanhGiaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageActivity();
            }
        });
    }

    private void openHomePageActivity() {
        Intent intent = new Intent(tour_MaGiamGia.this, hotel_MainHome_Activity.class);
        startActivity(intent);
    }
}
