package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_chonnguoiks_spinner_Adapter;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_phongkhachsan_Adapter;
import com.example.a124lttd04_travelappproject.api.ApiServer;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_phongkhachsan_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hotel_MainRoom_Activity extends AppCompatActivity {

    private hotel_chonnguoiks_spinner_Adapter categoryAdapter;
    private Spinner spinner;
    private RecyclerView recyclerView;
    private hotel_phongkhachsan_Adapter chooseRoomAdapter;
    private ImageView imageView;
    private Button button;
    private List<hotel_phongkhachsan_Model> mlistPhong;

    private String tenKhachSan;
    private int maKhachSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_room);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_chooseRoom), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        tenKhachSan = intent.getStringExtra("tenKhachSan");
        maKhachSan = intent.getIntExtra("maKhachSan", -1);
        String imageName = intent.getStringExtra("hinhanh"); // Nhận đường dẫn ảnh
        if (imageName != null) {
            // Lấy tài nguyên ảnh từ drawable
            int resId = getResources().getIdentifier(imageName.replace(".png", ""), "drawable", getPackageName());
            if (resId != 0) {
                ImageView imgKhachSan = findViewById(R.id.img_khachsan);
                imgKhachSan.setImageResource(resId);
            } else {
                // Nếu ảnh không tồn tại
                Toast.makeText(this, "Không tìm thấy ảnh!", Toast.LENGTH_SHORT).show();
            }
        }

        // Hiển thị thông tin khách sạn
        TextView tvTenKhachSan = findViewById(R.id.tv_tenkhachsan);
        tvTenKhachSan.setText(tenKhachSan);



        // Spinner
        spinner = findViewById(R.id.spn_selectedPerson);

        // Button: Lọc theo số lượng người
        button = findViewById(R.id.btn_thaydoi);
        button.setOnClickListener(v -> {
            hotel_phongkhachsan_Model selectedModel = (hotel_phongkhachsan_Model) spinner.getSelectedItem();
            if (selectedModel != null) {
                int selectedPeopleCount = selectedModel.getSoluongnguoi();
                List<hotel_phongkhachsan_Model> filteredRooms = new ArrayList<>();
                for (hotel_phongkhachsan_Model phong : mlistPhong) {
                    if (phong.getSoluongnguoi() == selectedPeopleCount) {
                        filteredRooms.add(phong);
                    }
                }
                hotel_phongkhachsan_Adapter filteredAdapter = new hotel_phongkhachsan_Adapter(
                        hotel_MainRoom_Activity.this,
                        filteredRooms
                );
                recyclerView.setAdapter(filteredAdapter);
            }
        });

        // RecyclerView
        recyclerView = findViewById(R.id.rcv_chooseRoom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mlistPhong = new ArrayList<>();
        callApiGetPhong();

        // Image: Quay lại trang trước
        imageView = findViewById(R.id.img_back_room);
        imageView.setOnClickListener(view -> {
            Intent backIntent = new Intent(hotel_MainRoom_Activity.this, hotel_MainHotel_Activity.class);
            startActivity(backIntent);
        });

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_hotel);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(hotel_MainRoom_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_hotel) {
                    // Nếu là mục Hotel (hoặc hiện tại là Hotel), không cần chuyển activity
                    return true;
                }

                else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(hotel_MainRoom_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(hotel_MainRoom_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

    private void callApiGetPhong() {
        ApiServer.apiServer.getListphong().enqueue(new Callback<List<hotel_phongkhachsan_Model>>() {
            @Override
            public void onResponse(Call<List<hotel_phongkhachsan_Model>> call, Response<List<hotel_phongkhachsan_Model>> response) {
                if (response.body() != null) {
                    List<hotel_phongkhachsan_Model> allRooms = response.body();

                    // Lọc danh sách phòng theo mã khách sạn
                    for (hotel_phongkhachsan_Model room : allRooms) {
                        if (room.getMakhachsan() == maKhachSan) {
                            mlistPhong.add(room);
                        }
                    }

                    // Lọc danh sách số lượng người duy nhất
                    List<hotel_phongkhachsan_Model> uniquePeopleCountModels = new ArrayList<>();
                    Set<Integer> uniquePeopleCountSet = new HashSet<>();
                    for (hotel_phongkhachsan_Model phong : mlistPhong) {
                        if (uniquePeopleCountSet.add(phong.getSoluongnguoi())) {
                            uniquePeopleCountModels.add(phong);
                        }
                    }

                    // Gán danh sách vào Spinner
                    categoryAdapter = new hotel_chonnguoiks_spinner_Adapter(
                            hotel_MainRoom_Activity.this,
                            R.layout.hotel_item_chonnguoi2,
                            uniquePeopleCountModels
                    );
                    spinner.setAdapter(categoryAdapter);

                    // Hiển thị toàn bộ phòng lên RecyclerView
                    chooseRoomAdapter = new hotel_phongkhachsan_Adapter(
                            hotel_MainRoom_Activity.this,
                            mlistPhong
                    );
                    recyclerView.setAdapter(chooseRoomAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<hotel_phongkhachsan_Model>> call, Throwable t) {
                Log.e("API_ERROR", "API Call Failed", t);
                Toast.makeText(hotel_MainRoom_Activity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
