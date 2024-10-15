package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;

public class plane_XacNhanGiaChuyenBay_Activity extends AppCompatActivity {
    Button xng;
    TextView xng1;
    Button ThanhToan;
    Button Exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_xacnhangiachuyenbay);
        xng=findViewById(R.id.themhanhly1);
        xng1=findViewById(R.id.themhanhly);
        ThanhToan=findViewById(R.id.thanhtoan);
        Exit=findViewById(R.id.exit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ChonChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m= new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ChuyenBay_ThanhToan_Activity.class);
                startActivity(m);
            }
        });
        xng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ThemHanhLy_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        xng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_XacNhanGiaChuyenBay_Activity.this, plane_ThemHanhLy_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }
}
