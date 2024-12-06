package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;

public class tour_Cart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        setupClickListeners();
    }

    private void setupClickListeners() {
        TextView datVe = findViewById(R.id.datve);

        datVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTourChiTietPageActivity();
            }
        });
    }

    private void openTourChiTietPageActivity() {
        Intent intent = new Intent(tour_Cart_Activity.this, tour_ChiTiet_Activity.class);
        startActivity(intent);
    }
}
