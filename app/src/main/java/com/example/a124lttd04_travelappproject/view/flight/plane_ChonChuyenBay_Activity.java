package com.example.a124lttd04_travelappproject.view.flight;

import android.content.Intent;
import android.graphics.Paint;
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

public class plane_ChonChuyenBay_Activity extends AppCompatActivity {
    TextView textView; // thay yourTextViewId bằng ID thực tế của TextView
    Button Xacnhangia;
    Button Exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_chonchuyenbay);
        Xacnhangia=findViewById(R.id.xacnhangia);
        Exit=findViewById(R.id.exit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textgach);
        textView.setText("1.986.000 VND/khách");
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_ChonChuyenBay_Activity.this, plane_TimKiemChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
        Xacnhangia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(plane_ChonChuyenBay_Activity.this, plane_XacNhanGiaChuyenBay_Activity.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });
    }
}
