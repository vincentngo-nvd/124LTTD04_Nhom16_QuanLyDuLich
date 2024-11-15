package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeNoiDia_Model;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeQuocTe_Model;
import com.example.a124lttd04_travelappproject.model.flight.plane_Category_Model;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_Category_Adapter;
import com.example.a124lttd04_travelappproject.model.flight.plane_CategoryQuocte_Model;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_CategoryQuocTe_Adapter;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class plane_VeMayBay_Activity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private RecyclerView rcvCategory1;
    private plane_Category_Adapter categoryAdapter;
    private plane_CategoryQuocTe_Adapter categoryAdapter1;
    Button btnn1;
    Button btnn2;
    Button btnhn;
    Button btntphcm;
    Button btndn;
    Button btnDNAhn;
    Button btnDNAhcm;
    Button btnDNAdn;
    Button noidi;
    Button noiden;
    Button tk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_ve_may_bay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        // Đặt mục action_hotel là mặc định
        bottomNavigationView.setSelectedItemId(R.id.action_plane);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, tour_Tour_Activity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        rcvCategory=findViewById(R.id.rcv_category);
        categoryAdapter = new plane_Category_Adapter(this);

        tk=findViewById(R.id.timkiem);
        btnn1=findViewById(R.id.btn1);
        btnn2=findViewById(R.id.btn2);
        btnhn=findViewById(R.id.btnHN);
        btntphcm=findViewById(R.id.btnTPHCM);
        btndn=findViewById(R.id.btnDN);
        btnDNAhn=findViewById(R.id.btndnahn);
        btnDNAhcm=findViewById(R.id.btndnahcm);
        btnDNAdn=findViewById(R.id.btndnadn);
        noidi=findViewById(R.id.noidi);
        noiden=findViewById(R.id.noiden);

        tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_VeMayBay_Activity.this, plane_TimKiemChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        noiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plane_BottomSheetEndLocation_Activity bottomSheet = new plane_BottomSheetEndLocation_Activity();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
        noidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plane_BottomSheetStartLocation_Activity bottomSheet = new plane_BottomSheetStartLocation_Activity();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
        btnDNAhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDNAhn.setTextColor(getResources().getColor(R.color.white));
                btnDNAhn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnDNAhcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btnDNAdn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAdn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btnDNAhcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDNAhcm.setTextColor(getResources().getColor(R.color.white));
                btnDNAhcm.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnDNAhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btnDNAdn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAdn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btnDNAdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDNAdn.setTextColor(getResources().getColor(R.color.white));
                btnDNAdn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnDNAhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btnDNAhcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btnhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnhn.setTextColor(getResources().getColor(R.color.white));
                btnhn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btntphcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btntphcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btndn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btndn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btntphcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntphcm.setTextColor(getResources().getColor(R.color.white));
                btntphcm.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btndn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btndn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btndn.setTextColor(getResources().getColor(R.color.white));
                btndn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btntphcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btntphcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });

        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnn1.setTextColor(getResources().getColor(R.color.xanh));
                btnn1.setTypeface(null, Typeface.BOLD);
                btnn2.setTextColor(getResources().getColor(R.color.xám));
                btnn2.setTypeface(null, Typeface.NORMAL);
            }
        });
        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnn2.setTextColor(getResources().getColor(R.color.xanh));
                btnn2.setTypeface(null, Typeface.BOLD);
                btnn1.setTextColor(getResources().getColor(R.color.xám));
                btnn1.setTypeface(null, Typeface.NORMAL);
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);




        rcvCategory1=findViewById(R.id.rcv_category1);
        categoryAdapter1 = new plane_CategoryQuocTe_Adapter(this);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory1.setLayoutManager(linearLayoutManager1);

        categoryAdapter1.setData(getListCategory1());
        rcvCategory1.setAdapter(categoryAdapter1);

        setupClickListeners();
    }

    private void setupClickListeners() {
        ImageButton backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePageActivity();
            }
        });
    }

    private void openHomePageActivity() {
        Intent intent = new Intent(plane_VeMayBay_Activity.this, hotel_MainHome_Activity.class);
        startActivity(intent);
    }

    private List<plane_Category_Model> getListCategory(){
        List<plane_Category_Model> listCategory=new ArrayList<>();

        List<plane_GiaVeNoiDia_Model> listGiave=new ArrayList<>();
        listGiave.add(new plane_GiaVeNoiDia_Model(R.drawable.view1,"Hà Nội - TP HCM","20 Tháng 10 2024","đ1.230.000"));
        listGiave.add(new plane_GiaVeNoiDia_Model(R.drawable.view2,"Hà Nội - Đà Nẵng","19 Tháng 10 2024","đ1.015.000"));
        listGiave.add(new plane_GiaVeNoiDia_Model(R.drawable.view3,"Hà Nội - Buôn MT","20 Tháng 10 2024","đ1.329.000"));
        listGiave.add(new plane_GiaVeNoiDia_Model(R.drawable.view1,"Hà Nội - TP HCM","20 Tháng 10 2024","đ1.230.000"));

        listCategory.add(new plane_Category_Model("",listGiave));

        return listCategory;
    }

    private List<plane_CategoryQuocte_Model> getListCategory1(){
        List<plane_CategoryQuocte_Model> listCategory=new ArrayList<>();

        List<plane_GiaVeQuocTe_Model> listGiave=new ArrayList<>();
        listGiave.add(new plane_GiaVeQuocTe_Model(R.drawable.view4,"Hà Nội - ĐNA","20 Tháng 10 2024","đ1.230.000"));
        listGiave.add(new plane_GiaVeQuocTe_Model(R.drawable.view5,"Hà Nội - ĐNA","19 Tháng 10 2024","đ1.015.000"));
        listGiave.add(new plane_GiaVeQuocTe_Model(R.drawable.view6,"Hà Nội - ĐNA","20 Tháng 10 2024","đ1.329.000"));
        listGiave.add(new plane_GiaVeQuocTe_Model(R.drawable.view4,"Hà Nội - ĐNA","20 Tháng 10 2024","đ1.230.000"));

        listCategory.add(new plane_CategoryQuocte_Model("",listGiave));

        return listCategory;
    }

}