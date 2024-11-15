package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
import com.example.a124lttd04_travelappproject.model.hotel.hotel_CategoryHotel1_Home_Model;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_Hotel2_Home_Adapter;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_CgrLocation1_Home_Model;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_CgrLocation_Adapter;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_CategoryHotel2_Home_Model;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_CgrLocation2_Home_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_DatVe_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_DatVe_ClickDatNgayKhiChuaChonVe_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;

public class hotel_MainHome_Activity extends AppCompatActivity {

    private RecyclerView rcv;
    private RecyclerView rcv_location;
    private hotel_Hotel2_Home_Adapter cgrAdapter;
    private hotel_CgrLocation_Adapter cgrlocationAdapter;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rcv_location = findViewById(R.id.rcv_location);
        rcv = findViewById(R.id.rcv_hotel);

        cgrAdapter = new hotel_Hotel2_Home_Adapter(this);
        cgrlocationAdapter = new hotel_CgrLocation_Adapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        rcv.setLayoutManager(linearLayoutManager);

        LinearLayoutManager locationLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
       rcv_location.setLayoutManager(locationLayoutManager);


       cgrlocationAdapter.setDataLocation(getListLocation());
        rcv_location.setAdapter(cgrlocationAdapter);


        cgrAdapter.setData(getListCategory());
        rcv.setAdapter(cgrAdapter);


        // Chuyen sang layout Khach San
        imageView = findViewById(R.id.hotel);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainHome_Activity.this, hotel_MainHotel_Activity.class);
                startActivity(intent);
            }
        });

        setupClickListeners();
    }

    private List<hotel_CategoryHotel1_Home_Model> getListCategory(){
        List<hotel_CategoryHotel1_Home_Model> list = new ArrayList<>();

        List<hotel_CategoryHotel2_Home_Model> cardviewList = new ArrayList<>();

        list.add(new hotel_CategoryHotel1_Home_Model("Khách sạn 5 sao hàng đầu",cardviewList));

        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.a3,"PITACHIDO hotel SAPA","1.050.000₫",R.drawable.five_stars));
        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.hotel_2,"Sunrise Airport Hotel","1.050.000₫",R.drawable.five_stars));
        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.hotel_3,"San Marino Boutique ","1.050.000₫",R.drawable.five_stars));

        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.a3,"PITACHIDO hotel SAPA","1.050.000₫",R.drawable.five_stars));
        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.a3,"Mường Thanh","1.050.000₫",R.drawable.five_stars));
        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.a3,"Mường Thanh","1.050.000₫",R.drawable.five_stars));


        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.a3,"PITACHIDO hotel SAPA","1.050.000₫",R.drawable.five_stars));
        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.hotel_2,"Sunrise Airport Hotel","1.050.000₫",R.drawable.five_stars));
        cardviewList.add(new hotel_CategoryHotel2_Home_Model(R.drawable.hotel_3,"San Marino Boutique ","1.050.000₫",R.drawable.five_stars));



        return list;

    }

    private List<hotel_CgrLocation2_Home_Model> getListLocation(){
        List<hotel_CgrLocation2_Home_Model> listLocation = new ArrayList<>();

        List<hotel_CgrLocation1_Home_Model> locations = new ArrayList<>();

        listLocation.add(new hotel_CgrLocation2_Home_Model("Điểm tham quan nổi bật",locations));

        locations.add(new hotel_CgrLocation1_Home_Model(R.drawable.danang,"Đà Nẵng","30 địa điểm"));
        locations.add(new hotel_CgrLocation1_Home_Model(R.drawable.nhatrang,"Nha Trang","20 địa điểm"));

        locations.add(new hotel_CgrLocation1_Home_Model(R.drawable.phuquoc,"Phú Quốc","35 địa điểm"));
        locations.add(new hotel_CgrLocation1_Home_Model(R.drawable.nhatrang,"Ninh Bình","15 địa điểm"));

        return listLocation;
    }

    private void setupClickListeners() {
        LinearLayout tourPage = findViewById(R.id.tour_page);
        LinearLayout planePage = findViewById(R.id.plane_page);
        ImageView userAccount = findViewById(R.id.user);

        planePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlanePageActivity();
            }
        });

        tourPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTourPageActivity();
            }
        });

        userAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserAccountActivity();
            }
        });
    }

    private void openPlanePageActivity() {
        Intent intent = new Intent(hotel_MainHome_Activity.this, plane_VeMayBay_Activity.class);
        startActivity(intent);
    }


    private void openTourPageActivity() {
        Intent intent = new Intent(hotel_MainHome_Activity.this, tour_Tour_Activity.class);
        startActivity(intent);
    }

    private void openUserAccountActivity() {
        Intent intent = new Intent(hotel_MainHome_Activity.this, Taikhoan.class);
        startActivity(intent);
    }
}