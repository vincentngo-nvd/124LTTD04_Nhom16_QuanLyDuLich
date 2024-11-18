package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.google.android.material.button.MaterialButton;

public class plane_LogIn_Activity extends AppCompatActivity {
    MaterialButton btn;
    EditText editTextEmail ;
    EditText editTextPassword;
    ImageView check;
    TextView account;
    boolean isChecked = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plane_login);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.EditTextPassword);
        check=findViewById(R.id.check_remember);
        btn = findViewById(R.id.btn_login);
        account=findViewById(R.id.new_account);

        // Cập nhật padding cho View khi có Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main0), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked==false){
                    check.setBackgroundResource(R.drawable.checkbox_with_check);
                    isChecked=true;
                }
                else if(isChecked==true){
                    check.setBackgroundResource(R.drawable.border);
                    isChecked=false;
                }
            }
        });

        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    editTextEmail.setText("");
                    editTextEmail.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
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
                Intent m = new Intent(plane_LogIn_Activity.this, hotel_MainHome_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }
}
