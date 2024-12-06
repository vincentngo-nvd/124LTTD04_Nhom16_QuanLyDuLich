package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.flight.plane_ChuyenBay_ThanhToan_Activity;
import com.example.a124lttd04_travelappproject.view.flight.plane_Voucher;

public class tour_DatVe_ThanhToan_Activity extends AppCompatActivity {
    TextView Voucher;
    LinearLayout thanhToanThanhCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_datve_thanhtoan);

        TextView textView = findViewById(R.id.textView_Contact);

        String htmlText = "Bằng cách nhấn vào nút trên, bạn đồng ý với các <font color='#475CD1'><b>Điều khoản & Điều kiện</b></font> và <font color='#475CD1'><b>Chính sách quyền riêng tư</b></font> của <font color='#475CD1'><b>Nhóm 16</b></font>.";
        textView.setText(Html.fromHtml(htmlText));

        // Bắt sự kiện click vào từng layout
        setupClickListeners();

        Voucher=findViewById(R.id.voucher);
        Voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(tour_DatVe_ThanhToan_Activity.this, tour_Voucher.class);
                startActivity(m);
            }
        });


        thanhToanThanhCong = findViewById(R.id.thanhtoanthanhcong);

        thanhToanThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(tour_DatVe_ThanhToan_Activity.this, tour_ThanhToanThanhCong_Activity.class);
                startActivity(m);
            }
        });
    }

    // Phương thức để set sự kiện click cho các layout
    private void setupClickListeners() {
        ImageView backButton = findViewById(R.id.back_button);

        // Set the click listener for the ImageView
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to DatVe_DatCho_Activity
                openDatChoActivity();
            }
        });
    }

    // Phương thức để mở giao diện activity_tour_chitiet.xml
    private void openDatChoActivity() {
        Intent intent = new Intent(tour_DatVe_ThanhToan_Activity.this, tour_DatVe_DatCho_Activity.class);
        startActivity(intent);
    }

}
