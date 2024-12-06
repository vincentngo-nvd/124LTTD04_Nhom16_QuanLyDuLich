package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.CongServices.ApiService;
import com.example.a124lttd04_travelappproject.CongServices.HttpRequest;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.Response;
import com.example.a124lttd04_travelappproject.model.flight.TaoKhoanModel;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class plane_LogIn_Activity extends AppCompatActivity {
    MaterialButton btn;
    EditText editTextEmail ;
    EditText editTextPassword;
    ImageView check;
    String TAG="//++";
    TextView account;
    boolean isChecked = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plane_login);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.EditTextPassword);
        check = findViewById(R.id.check_remember);
        btn = findViewById(R.id.btn_login);
        account = findViewById(R.id.new_account);

        // Cập nhật padding cho View khi có Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main0), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked == false) {
                    check.setBackgroundResource(R.drawable.checkbox_with_check);
                    isChecked = true;
                } else if (isChecked == true) {
                    check.setBackgroundResource(R.drawable.border);
                    isChecked = false;
                }
            }
        });

        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextEmail.setText("");
                    editTextEmail.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextPassword.setHint("");
                }
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_LogIn_Activity.this, plane_SignIn_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });

        // Khởi tạo Button và thiết lập sự kiện OnClick

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }



    private void loginUser() {
        TaoKhoanModel userData = new TaoKhoanModel();
        userData.setTaikhoan(editTextEmail.getText().toString());
        userData.setMatkhau(editTextPassword.getText().toString());


        HttpRequest httpRequest = new HttpRequest();
        ApiService apiService = httpRequest.callAPI();

        Call<Response> call = apiService.login(userData);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                // Xử lý phản hồi
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getStatus() == 200) {
                        // Đăng nhập thành công
                        Log.i(TAG, "Đăng nhập thành công! Tài khoản: " + editTextEmail);
                        Intent intent = new Intent(plane_LogIn_Activity.this, hotel_MainHome_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Log.i(TAG, "Đăng nhập thất bại: " + response.body().getMessage());
                        Toast.makeText(plane_LogIn_Activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.i(TAG, "Phản hồi không thành công hoặc body là null");
                    Toast.makeText(plane_LogIn_Activity.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.i(TAG, "Lỗi: " + t.getMessage());
                Toast.makeText(plane_LogIn_Activity.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
