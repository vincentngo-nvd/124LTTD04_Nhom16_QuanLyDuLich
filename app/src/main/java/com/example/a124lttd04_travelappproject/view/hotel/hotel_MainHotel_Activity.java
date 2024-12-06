package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.api.ApiServer;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_diadiemks_Model;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_diadiemks_spinner_Adapter;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_khachsan_Adapter;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_khachsan_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Cart_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hotel_MainHotel_Activity extends AppCompatActivity {

    private Spinner spinner, spinner2, spinner3;
    private hotel_diadiemks_spinner_Adapter categoryAdapter;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private List<hotel_khachsan_Model> mlistKhachsan;
    private Button btn_diadiem;
    private int selectedMaDiaDiem = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_hotel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_hotel);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    // Chuyển đến HotelMainHomeActivity
                    Intent homeIntent = new Intent(hotel_MainHotel_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(homeIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_hotel) {
                    // Chuyển đến HotelMainHotelActivity
                    Intent hotelIntent = new Intent(hotel_MainHotel_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(hotelIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_plane) {
                    // Chuyển đến PlaneVeMayBayActivity
                    Intent planeIntent = new Intent(hotel_MainHotel_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(planeIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    // Chuyển đến SettingActivity
                    Intent settingIntent = new Intent(hotel_MainHotel_Activity.this, Taikhoan.class);
                    startActivity(settingIntent);
                    return true;
                }
                return false;
            }
        });
        // spinner địa điểm khách sạn
        spinner = findViewById(R.id.spn_category);
        callApiGetDiadiem();

        //recycle view
        recyclerView = findViewById(R.id.rcv_choose);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        mlistKhachsan = new ArrayList<>();
        callApiGetKhachSan();

        // Tìm kiếm khách sạn theo địa điểm
        btn_diadiem = findViewById(R.id.btn_diadiem);
        btn_diadiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedMaDiaDiem != -1) {
                    callApiGetKhachSanByDiaDiem(selectedMaDiaDiem); // Gọi API với mã địa điểm
                } else {
                    Toast.makeText(hotel_MainHotel_Activity.this, "Vui lòng chọn địa điểm trước!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        imageView = findViewById(R.id.img_back_hotel);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainHotel_Activity.this, hotel_MainHome_Activity.class);
                startActivity(intent);
            }
        });

        ImageButton cartButton = findViewById(R.id.cart_button);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCartPageActivity();
            }
        });
    }

    private void openCartPageActivity() {
        Intent intent = new Intent(hotel_MainHotel_Activity.this, tour_Cart_Activity.class);
        startActivity(intent);
    }
    private void callApiGetDiadiem() {
        ApiServer.apiServer.getListdiadiem().enqueue(new Callback<List<hotel_diadiemks_Model>>() {
            @Override
            public void onResponse(Call<List<hotel_diadiemks_Model>> call, Response<List<hotel_diadiemks_Model>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<hotel_diadiemks_Model> listDiadiem = response.body();
                    categoryAdapter = new hotel_diadiemks_spinner_Adapter(hotel_MainHotel_Activity.this, R.layout.hotel_item_diadiem1, listDiadiem);
                    spinner.setAdapter(categoryAdapter);
                    // Thiết lập sự kiện chọn item
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            hotel_diadiemks_Model selected = categoryAdapter.getItem(position);
                            if (selected != null) {
                                selectedMaDiaDiem = selected.getMadiadiemks(); // Lấy mã địa điểm (kiểu int)
                                Toast.makeText(hotel_MainHotel_Activity.this, "Địa điểm: " + selected.getTendiadiem(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                } else {
                    Log.e("API_ERROR", "Response failed or empty");
                    Toast.makeText(hotel_MainHotel_Activity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<hotel_diadiemks_Model>> call, Throwable t) {
                Log.e("API_ERROR", "API Call Failed", t);
                Toast.makeText(hotel_MainHotel_Activity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private  void callApiGetKhachSan(){
        ApiServer.apiServer.getListKhachsan().enqueue(new Callback<List<hotel_khachsan_Model>>() {
            @Override
            public void onResponse(Call<List<hotel_khachsan_Model>> call, Response<List<hotel_khachsan_Model>> response) {
                mlistKhachsan = response.body();
                hotel_khachsan_Adapter khachsanAdapter = new hotel_khachsan_Adapter(hotel_MainHotel_Activity.this ,mlistKhachsan);
                recyclerView.setAdapter(khachsanAdapter);
            }
            @Override
            public void onFailure(Call<List<hotel_khachsan_Model>> call, Throwable t) {
                Log.e("API_ERROR", "API Call Failed", t);
                Toast.makeText(hotel_MainHotel_Activity.this, "API call failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callApiGetKhachSanByDiaDiem(int maDiaDiem) {
        ApiServer.apiServer.getListKhachsan().enqueue(new Callback<List<hotel_khachsan_Model>>() {
            @Override
            public void onResponse(Call<List<hotel_khachsan_Model>> call, Response<List<hotel_khachsan_Model>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<hotel_khachsan_Model> filteredList = new ArrayList<>();
                    for (hotel_khachsan_Model hotel : response.body()) {
                        if (hotel.getMadiadiemks() == maDiaDiem) { // So sánh mã địa điểm (int)
                            filteredList.add(hotel);
                        }
                    }
                    if (filteredList.isEmpty()) {
                        Toast.makeText(hotel_MainHotel_Activity.this, "Không có khách sạn nào cho địa điểm này!", Toast.LENGTH_SHORT).show();
                    } else {
                        hotel_khachsan_Adapter khachsanAdapter = new hotel_khachsan_Adapter(hotel_MainHotel_Activity.this, filteredList);
                        recyclerView.setAdapter(khachsanAdapter);
                    }
                } else {
                    Toast.makeText(hotel_MainHotel_Activity.this, "Không tìm thấy khách sạn phù hợp!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<hotel_khachsan_Model>> call, Throwable t) {
                Toast.makeText(hotel_MainHotel_Activity.this, "Lỗi API: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}