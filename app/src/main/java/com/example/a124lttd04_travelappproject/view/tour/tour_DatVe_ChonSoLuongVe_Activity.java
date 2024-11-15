package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;

public class tour_DatVe_ChonSoLuongVe_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_datve_chonsoluongve);

        setupClickListeners();
    }

    private void setupClickListeners() {
        LinearLayout firstProduct = findViewById(R.id.first_product_chonsoluongve);

        firstProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity();
            }
        });
        ImageView backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatChoActivity();
            }
        });
    }

    private void openDatChoActivity() {
        Intent intent = new Intent(tour_DatVe_ChonSoLuongVe_Activity.this, tour_ChiTiet_Activity.class);
        startActivity(intent);
    }

    private void openDetailActivity() {
        Intent intent = new Intent(tour_DatVe_ChonSoLuongVe_Activity.this, tour_DatVe_DatCho_Activity.class);
        startActivity(intent);
    }
}
