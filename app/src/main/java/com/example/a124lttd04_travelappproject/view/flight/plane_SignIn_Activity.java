package com.example.a124lttd04_travelappproject.view.flight;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.CongServices.ApiService;
import com.example.a124lttd04_travelappproject.CongServices.HttpRequest;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.flight.Response;
import com.example.a124lttd04_travelappproject.model.flight.TaoKhoanModel;
import com.example.a124lttd04_travelappproject.model.flight.TaoTaiKhoanModel;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;

public class plane_SignIn_Activity extends AppCompatActivity {
    MaterialButton btn;

    MaterialButton btnlogin;
    EditText firtname;
    EditText email;
    String TAG="//++";
    EditText password;
    EditText password_confirm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plane_singin);
        btn=findViewById(R.id.btn_singin);
        firtname=findViewById(R.id.Firt_name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        password_confirm=findViewById(R.id.password_confirm);
        btnlogin=findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firtname.getText().toString().equals("First Name")||email.getText().toString().equals("Tài khoản")
                ||password.getText().toString().equals("Password")){
                    Toast.makeText(plane_SignIn_Activity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                else if(!password.getText().toString().equals(password_confirm.getText().toString())
                        ||password_confirm.getText().toString().equals("Confirm Password")){
                    Toast.makeText(plane_SignIn_Activity.this, "Vui lòng nhập lại mật khẩu!", Toast.LENGTH_SHORT).show();
                }
                else{
                    CreateNewUser();
                }
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(plane_SignIn_Activity.this, plane_LogIn_Activity.class);
                startActivity(t);
                finish();
            }
        });
        firtname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    firtname.setText("");
                    firtname.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    email.setText("");
                    email.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    password.setHint("");
                    password.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        password_confirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    password_confirm.setHint("");
                    password_confirm.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void CreateNewUser() {
        TaoTaiKhoanModel userData = new TaoTaiKhoanModel();
        userData.setTenkhachhang(firtname.getText().toString());
        userData.setTaikhoan(email.getText().toString());
        userData.setMatkhau(password.getText().toString());
            HttpRequest httpRequest = new HttpRequest();
            ApiService apiService = httpRequest.callAPI();

            Call<Response> call = apiService.Insert(userData);

            call.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    // Xử lý phản hồi
                    if (response.isSuccessful() && response.body() != null) {
                        if (response.body().getStatus() == 200) {
                            // Chèn thành công
                            Log.i(TAG, "Tài khoản và thông tin khách hàng đã được tạo!");
                        } else {
                            Log.i(TAG, "Chèn thất bại: " + response.body().getMessage());
                            Toast.makeText(plane_SignIn_Activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.i(TAG, "Phản hồi không thành công hoặc body là null");
                        Toast.makeText(plane_SignIn_Activity.this, "Tạo tài khoản không thành công", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    Log.i(TAG, "Lỗi: " + t.getMessage());
                    Toast.makeText(plane_SignIn_Activity.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }
}
