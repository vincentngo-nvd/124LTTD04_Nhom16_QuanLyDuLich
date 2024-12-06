package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.tour.tour_Horizontal_Adapter;
import com.example.a124lttd04_travelappproject.model.tour.tour_City_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainRoom_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class tour_Tour_Activity extends AppCompatActivity {
    private boolean isLoved = false;
    private RecyclerView horizontalRecyclerView;
    private tour_Horizontal_Adapter horizontalAdapter;
    private List<tour_City_Model> cityList;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(tour_Tour_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    Intent intent = new Intent(tour_Tour_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(tour_Tour_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(tour_Tour_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        ImageView loveImageView = findViewById(R.id.love);

        // Gắn sự kiện click cho ImageView
        loveImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra trạng thái và chuyển đổi hình ảnh
                if (isLoved) {
                    loveImageView.setImageResource(R.drawable.love); // Trở về icon "love"
                    Toast.makeText(tour_Tour_Activity.this, "Đã xóa khỏi yêu thích!", Toast.LENGTH_SHORT).show();
                } else {
                    loveImageView.setImageResource(R.drawable.redlove); // Chuyển sang icon "redlove"
                    Toast.makeText(tour_Tour_Activity.this, "Đã thêm vào yêu thích!", Toast.LENGTH_SHORT).show();

                    // Lưu thông tin item vào SharedPreferences hoặc Database (bạn có thể dùng SharedPreferences để lưu lại trạng thái yêu thích)
                    saveFavoriteItem();  // Thay giá trị tương ứng
                }
                isLoved = !isLoved; // Đảo trạng thái
            }
        });
        textView = findViewById(R.id.textgach);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        horizontalRecyclerView = findViewById(R.id.horizontal_recyclerview);

        // Tạo danh sách các thành phố và hình ảnh
        cityList = new ArrayList<>();
        cityList.add(new tour_City_Model("Đà Nẵng", R.drawable.anh1));
        cityList.add(new tour_City_Model("Hà Nội", R.drawable.anh2));
        cityList.add(new tour_City_Model("Hồ Chí Minh", R.drawable.anh3));
        cityList.add(new tour_City_Model("Huế", R.drawable.anh4));

        // Thiết lập adapter và layout cho RecyclerView
        horizontalAdapter = new tour_Horizontal_Adapter(cityList, this);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecyclerView.setAdapter(horizontalAdapter);

        Spinner spinnerGia = findViewById(R.id.spinner_gia);
        Spinner spinnerThanhPho = findViewById(R.id.spinner_thanhpho);
        Spinner spinnerDanhMuc = findViewById(R.id.spinner_danhmuc);
        Spinner spinnerSoLuong = findViewById(R.id.spinner_soluong);

        setupSpinner(spinnerGia);
        setupSpinner(spinnerThanhPho);
        setupSpinner(spinnerDanhMuc);
        setupSpinner(spinnerSoLuong);

        setupClickListeners();
    }

    // Lưu item vào SharedPreferences (hoặc có thể lưu vào Database)
    private void saveFavoriteItem() {
        // Lấy thông tin sản phẩm yêu thích (ví dụ)
        String itemName = "Vé Công viên nước The Amazing Bay";
        String itemPrice = "465.000đ";
        int itemImage = R.drawable.anh1;

        // Lưu thông tin vào SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FavoriteItems", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("item_name", itemName);
        editor.putString("item_price", itemPrice);
        editor.putInt("item_image", itemImage);
        editor.putString("item_xperiencedeal", "Xperience Deals");
        editor.putString("item_textgach", "1.474.999đ");
        editor.apply();
    }

    private void setupClickListeners() {
        ImageView backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageActivity();
            }
        });

        LinearLayout itemTour = findViewById(R.id.item_tour);
        itemTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTourChiTietPageActivity();
            }
        });

        ImageButton cartButton = findViewById(R.id.cart_button);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCartPageActivity();
            }
        });
    }

    private void openHomePageActivity() {
        Intent intent = new Intent(tour_Tour_Activity.this, hotel_MainHome_Activity.class);
        startActivity(intent);
    }

    private void openCartPageActivity() {
        Intent intent = new Intent(tour_Tour_Activity.this, tour_Cart_Activity.class);
        startActivity(intent);
    }

    private void openTourChiTietPageActivity() {
        Intent intent = new Intent(tour_Tour_Activity.this, tour_ChiTiet_Activity.class);
        startActivity(intent);
    }

    private void setupSpinner(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                } else {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}