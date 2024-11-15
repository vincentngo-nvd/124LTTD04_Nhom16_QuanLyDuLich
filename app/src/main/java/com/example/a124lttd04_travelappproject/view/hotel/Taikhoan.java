package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.flight.plane_LogIn_Activity;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Taikhoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_taikhoan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_tour);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Sử dụng if-else thay vì switch
                if (item.getItemId() == R.id.action_home) {
                    // Chuyển đến HotelMainHomeActivity
                    Intent homeIntent = new Intent(Taikhoan.this, hotel_MainHome_Activity.class);
                    startActivity(homeIntent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    // Chuyển đến HotelMainHotelActivity
                    Intent hotelIntent = new Intent(Taikhoan.this, hotel_MainHotel_Activity.class);
                    startActivity(hotelIntent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    // Chuyển đến PlaneVeMayBayActivity
                    Intent planeIntent = new Intent(Taikhoan.this, plane_VeMayBay_Activity.class);
                    startActivity(planeIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    // Chuyển đến SettingActivity (nếu có)
                    Intent settingIntent = new Intent(Taikhoan.this, Taikhoan.class);
                    startActivity(settingIntent);
                    return true;
                }
                return false;
            }
        });
        setupClickListeners();
    }

    private void setupClickListeners() {
        Button signOutButton = findViewById(R.id.signout);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInPageActivity();
            }
        });
    }

    private void openSignInPageActivity() {
        Intent intent = new Intent(Taikhoan.this, plane_LogIn_Activity.class);
        startActivity(intent);
    }
}