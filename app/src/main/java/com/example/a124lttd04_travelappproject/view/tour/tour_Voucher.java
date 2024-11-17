package com.example.a124lttd04_travelappproject.view.tour;

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
import com.example.a124lttd04_travelappproject.view.flight.plane_ChuyenBay_SauThanhToan;
import com.example.a124lttd04_travelappproject.view.flight.plane_ChuyenBay_ThanhToan_Activity;
import com.example.a124lttd04_travelappproject.view.flight.plane_Voucher;

public class tour_Voucher extends AppCompatActivity {
    boolean check=true;
    Button giamgia;
    Button xacnhan;
    TextView tongtien;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_voucher);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.voucher), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        giamgia=findViewById(R.id.applygiamgia);
        tongtien=findViewById(R.id.TongTien);
        xacnhan=findViewById(R.id.xacnhan);
        giamgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==true){
                    tongtien.setText("265.000 VND (TCBDOMBAY)");
                    check=false;
                }
                else {
                    tongtien.setText("465.000 VND");
                    check=true;
                }
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(tour_Voucher.this, tour_DatVe_SauThanhToan_Activity.class);
                startActivity(m);
            }
        });
    }
}
