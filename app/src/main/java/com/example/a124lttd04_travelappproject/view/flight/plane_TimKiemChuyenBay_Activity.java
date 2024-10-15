package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;

public class plane_TimKiemChuyenBay_Activity extends AppCompatActivity {
    Button chonchuyenbay;
    Button Exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_timkiemvemaybay);
        chonchuyenbay=findViewById(R.id.chonbay);
        Exit=findViewById(R.id.exit);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_TimKiemChuyenBay_Activity.this, plane_VeMayBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        chonchuyenbay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_TimKiemChuyenBay_Activity.this, plane_ChonChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }
}
