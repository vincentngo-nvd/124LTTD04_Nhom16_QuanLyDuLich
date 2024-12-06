package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.CongServices.HttpRequest;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_GiaVeNoiDia_Adapter;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_GiaVeQuocTe_Adapter;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_HanhLy_Adapter;
import com.example.a124lttd04_travelappproject.model.flight.HanhLyModel;
import com.example.a124lttd04_travelappproject.model.flight.Response;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeNoiDia_Model;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class plane_ThemHanhLy_Activity extends AppCompatActivity {
    Button Exit;
    MaterialButton Save;
    String TAG="//++";

    HttpRequest httpRequest;
    List<HanhLyModel> HanhLylist;
    private RecyclerView recyclerView;
    private plane_HanhLy_Adapter HanhLyAdapter;

    private plane_HanhLy_Adapter HanhLyadapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpRequest=new HttpRequest();
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_themhanhly);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        // Đặt mục action_hotel là mặc định
        bottomNavigationView.setSelectedItemId(R.id.action_plane);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(plane_ThemHanhLy_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    Intent intent = new Intent(plane_ThemHanhLy_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(plane_ThemHanhLy_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(plane_ThemHanhLy_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Exit=findViewById(R.id.exit1);
        Save=findViewById(R.id.luu);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(plane_ThemHanhLy_Activity.this, plane_XacNhanGiaChuyenBay_Activity.class);
                startActivity(m);
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(plane_ThemHanhLy_Activity.this, plane_XacNhanGiaChuyenBay_Activity.class);
                startActivity(m);
            }
        });
        HanhLyadapter=new plane_HanhLy_Adapter();


        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.rcv_hanhly); // Đảm bảo ID này đúng
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager1);
        HanhLyadapter=new plane_HanhLy_Adapter();


        fetchHanhLyList();


    }
    private void fetchHanhLyList() {
        httpRequest.callAPI().getHanhLyList().enqueue(getListHanhLy);
    }
    Callback<Response<ArrayList<HanhLyModel>>> getListHanhLy = new Callback<Response<ArrayList<HanhLyModel>>>() {
        @Override
        public void onResponse(Call<Response<ArrayList<HanhLyModel>>> call, retrofit2.Response<Response<ArrayList<HanhLyModel>>> response) {
            if (response.isSuccessful() && response.body() != null) {
                if (response.body().getStatus() == 200) {
                    HanhLylist = new ArrayList<>();
                    HanhLylist = response.body().getData();
                    HanhLyadapter.setData(HanhLylist);
                    recyclerView.setAdapter(HanhLyadapter);
                    for (HanhLyModel item : HanhLylist) {
                        Log.i(TAG, "//==" + item.toString());
                    }
                } else {
                    Log.i(TAG, "Status not 200: " + response.body().getStatus());
                }
            } else {
                Log.i(TAG, "Response not successful or body is null");
            }
        }

        @Override
        public void onFailure(Call<Response<ArrayList<HanhLyModel>>> call, Throwable t) {
            Log.i(TAG, "/Error==" + t.getMessage());
        }
    };
}
