package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;

public class tour_DatVe_SauThanhToan_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_datve_sauthanhtoan);

        TextView textView = findViewById(R.id.textView_Contact);

        String htmlText = "Bằng cách nhấn vào nút trên, bạn đồng ý với các <font color='#475CD1'><b>Điều khoản & Điều kiện</b></font> và <font color='#475CD1'><b>Chính sách quyền riêng tư</b></font> của <font color='#475CD1'><b>Nhóm 16</b></font>.";
        textView.setText(Html.fromHtml(htmlText));

        // Bắt sự kiện click vào từng layout
        setupClickListeners();
    }

    private void setupClickListeners() {
        ImageView backButton = findViewById(R.id.back_button);
        LinearLayout thanhToanThanhCong = findViewById(R.id.thanhtoanthanhcong);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatChoActivity();
            }
        });

        thanhToanThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThanhToanThanhCongActivity();
            }
        });
    }

    private void openDatChoActivity() {
        Intent intent = new Intent(tour_DatVe_SauThanhToan_Activity.this, tour_DatVe_DatCho_Activity.class);
        startActivity(intent);
    }

    private void openThanhToanThanhCongActivity() {
        Intent intent = new Intent(tour_DatVe_SauThanhToan_Activity.this, tour_ThanhToanThanhCong_Activity.class);
        startActivity(intent);
    }
}
