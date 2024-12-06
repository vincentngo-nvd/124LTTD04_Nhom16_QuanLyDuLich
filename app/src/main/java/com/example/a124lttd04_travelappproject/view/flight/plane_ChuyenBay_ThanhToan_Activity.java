package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_ThanhToanThanhCong_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class plane_ChuyenBay_ThanhToan_Activity extends AppCompatActivity {
    Button Thoat;
    private TextView timerTextView;
    private TextView Tongtien;
    private TextView voucher;
    private CountDownTimer countDownTimer;
    LinearLayout thanhToanThanhCong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.plane_chuyenbay_thanhtoan);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_plane);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    Intent intent = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        Thoat = findViewById(R.id.thoat);
        voucher = findViewById(R.id.voucher);
        thanhToanThanhCong = findViewById(R.id.thanhtoanthanhcong);
        Tongtien= findViewById(R.id.ThanhToan);

        String selectTongTien= getIntent().getStringExtra("thanhtoan");
        Tongtien.setText(selectTongTien);

        voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext(); // Lấy context từ view
                Intent m = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, plane_Voucher.class);
                m.putExtra("voucher", Tongtien.getText().toString());
                context.startActivity(m);
            }
        });

        thanhToanThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, tour_ThanhToanThanhCong_Activity.class);
                startActivity(m);
            }
        });

        // Khởi tạo TextView
        timerTextView = findViewById(R.id.timerTextView); // Đảm bảo ID này đúng với layout của bạn
        startTimer(180000); // Bắt đầu đếm ngược 180 giây

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main5), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_ChuyenBay_ThanhToan_Activity.this, plane_XacNhanGiaChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }

    private void startTimer(long millis) {
        countDownTimer = new CountDownTimer(millis, 1000) { // mỗi giây
            @Override
            public void onTick(long millisUntilFinished) {
                // Cập nhật TextView với thời gian còn lại
                int seconds = (int) (millisUntilFinished / 1000);
                timerTextView.setText(String.format("%d giây", seconds));
            }

            @Override
            public void onFinish() {
                timerTextView.setText("Hết thời gian!");
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Dừng đồng hồ khi Activity bị hủy
        }
    }
}