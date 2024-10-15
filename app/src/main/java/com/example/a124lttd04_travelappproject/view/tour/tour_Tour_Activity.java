package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.tour.tour_Horizontal_Adapter;
import com.example.a124lttd04_travelappproject.model.tour.tour_City_Model;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class tour_Tour_Activity extends AppCompatActivity {

    private RecyclerView horizontalRecyclerView;
    private tour_Horizontal_Adapter horizontalAdapter;
    private List<tour_City_Model> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        horizontalRecyclerView = findViewById(R.id.horizontal_recyclerview);

        // Tạo danh sách các thành phố và hình ảnh
        cityList = new ArrayList<>();
        cityList.add(new tour_City_Model("Đà Nẵng", R.drawable.anh1));
        cityList.add(new tour_City_Model("Hà Nội", R.drawable.anh2));
        cityList.add(new tour_City_Model("Hồ Chí Minh", R.drawable.anh3));
        cityList.add(new tour_City_Model("Huế", R.drawable.anh4));

        // Thiết lập adapter và layout cho RecyclerView
        horizontalAdapter = new tour_Horizontal_Adapter(cityList, this);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecyclerView.setAdapter(horizontalAdapter);

        Spinner spinnerGia = findViewById(R.id.spinner_gia);
        Spinner spinnerThanhPho = findViewById(R.id.spinner_thanhpho);
        Spinner spinnerDanhMuc = findViewById(R.id.spinner_danhmuc);
        Spinner spinnerSoLuong = findViewById(R.id.spinner_soluong);

        setupSpinner(spinnerGia);
        setupSpinner(spinnerThanhPho);
        setupSpinner(spinnerDanhMuc);
        setupSpinner(spinnerSoLuong);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

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

        setupClickListeners();
    }

    private void setupClickListeners() {
        ImageView backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageActivity();
            }
        });
    }

    private void openHomePageActivity() {
        Intent intent = new Intent(tour_Tour_Activity.this, hotel_MainHome_Activity.class);
        startActivity(intent);
    }

    private void setupSpinner(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                } else {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}