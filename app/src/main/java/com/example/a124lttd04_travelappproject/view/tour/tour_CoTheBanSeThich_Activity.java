package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class tour_CoTheBanSeThich_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cothebansethich);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Sự kiện khi chọn các mục của BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_home) {
                    return true;
                } else if (id == R.id.action_hotel) {
                    return true;
                } else if (id == R.id.action_plane) {
                    return true;
                } else if (id == R.id.action_setting) {
                    return true;
                }
                return false;
            }
        });

        // Bắt sự kiện click vào từng layout
        setupClickListeners();
    }

    // Phương thức để set sự kiện click cho các layout
    private void setupClickListeners() {
        LinearLayout firstProduct = findViewById(R.id.first_product_cothebansethich);
        LinearLayout secondProduct = findViewById(R.id.second_product_cothebansethich);
        LinearLayout thirdProduct = findViewById(R.id.third_product_cothebansethich);
        LinearLayout fourthProduct = findViewById(R.id.fourth_product_cothebansethich);
        LinearLayout fifthProduct = findViewById(R.id.fifth_product_cothebansethich);
        LinearLayout sixthProduct = findViewById(R.id.sixth_product_cothebansethich);

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

        thirdProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        fourthProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        fifthProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });

        sixthProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
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
        Intent intent = new Intent(tour_CoTheBanSeThich_Activity.this, tour_Tour_Activity.class);
        startActivity(intent);
    }

    // Phương thức để mở giao diện activity_tour_chitiet.xml
    private void openDetailActivity() {
        Intent intent = new Intent(tour_CoTheBanSeThich_Activity.this, tour_ChiTiet_Activity.class);
        startActivity(intent);
    }
}
