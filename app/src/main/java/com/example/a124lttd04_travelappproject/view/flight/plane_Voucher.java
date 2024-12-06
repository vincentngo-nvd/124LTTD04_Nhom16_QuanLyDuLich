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

public class plane_Voucher extends AppCompatActivity {
    boolean check=true;
    Button giamgia;
    Button xacnhan;
    TextView tongtien;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.plane_them_voucher);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.voucher), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        giamgia=findViewById(R.id.applygiamgia);
        tongtien=findViewById(R.id.TongTien);
        xacnhan=findViewById(R.id.xacnhan);

        String selectTongTien= getIntent().getStringExtra("voucher");
        tongtien.setText(selectTongTien);


        giamgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==true){
                    tongtien.setText("1.508.651 VND (TCBDOMBAY)");
                    check=false;
                }
                else {
                    tongtien.setText("1.708.651 VND");
                    check=true;
                }
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(plane_Voucher.this, plane_ChuyenBay_SauThanhToan.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }

}
