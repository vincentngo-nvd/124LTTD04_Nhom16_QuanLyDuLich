package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;

public class plane_ThemHanhLy_Activity extends AppCompatActivity {
    Button Exit;
    Button Save;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_themhanhly);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Exit=findViewById(R.id.exit1);
        Save=findViewById(R.id.luu);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(plane_ThemHanhLy_Activity.this, plane_XacNhanGiaChuyenBay_Activity.class);
                startActivity(m);
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(plane_ThemHanhLy_Activity.this, plane_XacNhanGiaChuyenBay_Activity.class);
                startActivity(m);
            }
        });
    }
}
