package com.example.a124lttd04_travelappproject.view.flight;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a124lttd04_travelappproject.R;
import com.google.android.material.button.MaterialButton;

public class plane_SignIn_Activity extends AppCompatActivity {
    MaterialButton btn;
    EditText firtname;
    EditText email;
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(plane_SignIn_Activity.this);
                builder.setTitle("Thông báo")
                        .setMessage("Bán có chắc chắn muốn tạo tài khoản không ?")
                        .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent m = new Intent(plane_SignIn_Activity.this, plane_LogIn_Activity.class); // Kiểm tra lớp đích
                                startActivity(m);
                            }
                        })
                        .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false);

                AlertDialog dialog =builder.create();
                dialog.show();
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
}
