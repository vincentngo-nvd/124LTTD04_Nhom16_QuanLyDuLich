package com.example.a124lttd04_travelappproject.view.flight;

import static androidx.fragment.app.FragmentManager.TAG;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.a124lttd04_travelappproject.CongServices.HttpRequest;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_BottomSheetEnd;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_BottomSheetStart;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_GiaVeNoiDia_Adapter;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_GiaVeQuocTe_Adapter;
import com.example.a124lttd04_travelappproject.model.flight.TenChuyenBayModel;
import com.example.a124lttd04_travelappproject.model.flight.TenGheModel;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeNoiDia_Model;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeQuocTe_Model;
import com.example.a124lttd04_travelappproject.model.flight.plane_Category_Model;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_Category_Adapter;
import com.example.a124lttd04_travelappproject.model.flight.plane_CategoryQuocte_Model;
import com.example.a124lttd04_travelappproject.adapter.flight.plane_CategoryQuocTe_Adapter;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Cart_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_ThanhToanThanhCong_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import com.example.a124lttd04_travelappproject.model.flight.Response;

public class plane_VeMayBay_Activity extends AppCompatActivity {
    public TextView TextViewNoiDen;
    public TextView TextViewNoiDi;
    String TAG="//++";
    private RecyclerView rcvCategory;
    private plane_GiaVeNoiDia_Adapter NoiDiaAdapter;
    private plane_GiaVeQuocTe_Adapter QuocTeAdapter;
    List<plane_GiaVeNoiDia_Model> NoiDialist;
    List<plane_GiaVeQuocTe_Model> QuocTelist;
    HttpRequest httpRequest;
    private RecyclerView rcvCategory1;
    private plane_Category_Adapter categoryAdapter;
    private plane_CategoryQuocTe_Adapter categoryAdapter1;
    Button btnn1;
    Button btnn2;
    Button btnhn;
    Button btntphcm;
    Button btndn;
    Button btnDNAhn;
    Button btnDNAhcm;
    Button btnDNAdn;
    Button noidi;
    Button noiden;

    Spinner myspinner;
    Spinner myspinnertenghe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpRequest=new HttpRequest();
        EdgeToEdge.enable(this);
        setContentView(R.layout.plane_ve_may_bay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        // Đặt mục action_hotel là mặc định
        bottomNavigationView.setSelectedItemId(R.id.action_plane);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(plane_VeMayBay_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        rcvCategory=findViewById(R.id.rcv_category);


        categoryAdapter = new plane_Category_Adapter(this);

        TextViewNoiDen=findViewById(R.id.textnoiden);
        TextViewNoiDi=findViewById(R.id.textnoidi);
        btnn1=findViewById(R.id.btn1);
        btnn2=findViewById(R.id.btn2);
        btnhn=findViewById(R.id.btnHN);
        btntphcm=findViewById(R.id.btnTPHCM);
        btndn=findViewById(R.id.btnDN);
        btnDNAhn=findViewById(R.id.btndnahn);
        btnDNAhcm=findViewById(R.id.btndnahcm);
        btnDNAdn=findViewById(R.id.btndnadn);
        noidi=findViewById(R.id.noidi);
        noiden=findViewById(R.id.noiden);
        myspinner=findViewById(R.id.my_spinner);
        myspinnertenghe=findViewById(R.id.my_spinner_ghe);

        fetchHangBayList();
        fetchTenGheList();


        String selectedNoiden = getIntent().getStringExtra("selected_noiden");
        if (selectedNoiden != null) {
            TextViewNoiDen.setText(selectedNoiden); // Set the text of the TextView
        }

        String selectedNoiDi= getIntent().getStringExtra("selected_noidi");
        if (selectedNoiDi != null) {
            TextViewNoiDi.setText(selectedNoiDi); // Set the text of the TextView
        }

        noiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the BottomSheetDialogFragment
                plane_BottomSheetEnd bottomSheet = new plane_BottomSheetEnd();

                // Show the Bottom Sheet
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
        noidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the BottomSheetDialogFragment
                plane_BottomSheetStart bottomSheet = new plane_BottomSheetStart();

                // Show the Bottom Sheet
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());

            }
        });
        btnDNAhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDNAhn.setTextColor(getResources().getColor(R.color.white));
                btnDNAhn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnDNAhcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btnDNAdn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAdn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btnDNAhcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDNAhcm.setTextColor(getResources().getColor(R.color.white));
                btnDNAhcm.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnDNAhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btnDNAdn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAdn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btnDNAdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDNAdn.setTextColor(getResources().getColor(R.color.white));
                btnDNAdn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnDNAhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btnDNAhcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnDNAhcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btnhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnhn.setTextColor(getResources().getColor(R.color.white));
                btnhn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btntphcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btntphcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btndn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btndn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btntphcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntphcm.setTextColor(getResources().getColor(R.color.white));
                btntphcm.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btndn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btndn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btndn.setTextColor(getResources().getColor(R.color.white));
                btndn.setBackground(getResources().getDrawable(R.drawable.button_maybay1));
                btnhn.setTextColor(getResources().getColor(R.color.xanhncbien));
                btnhn.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
                btntphcm.setTextColor(getResources().getColor(R.color.xanhncbien));
                btntphcm.setBackground(getResources().getDrawable(R.drawable.button_maybay2));
            }
        });

        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnn1.setTextColor(getResources().getColor(R.color.xanh));
                btnn1.setTypeface(null, Typeface.BOLD);
                btnn2.setTextColor(getResources().getColor(R.color.xám));
                btnn2.setTypeface(null, Typeface.NORMAL);
            }
        });
        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnn2.setTextColor(getResources().getColor(R.color.xanh));
                btnn2.setTypeface(null, Typeface.BOLD);
                btnn1.setTextColor(getResources().getColor(R.color.xám));
                btnn1.setTypeface(null, Typeface.NORMAL);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        NoiDiaAdapter=new plane_GiaVeNoiDia_Adapter();
        fetchNoiDiaList();



        rcvCategory1=findViewById(R.id.rcv_category1);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvCategory1.setLayoutManager(linearLayoutManager1);
        QuocTeAdapter=new plane_GiaVeQuocTe_Adapter();
        fetchQuocTeList();


        setupClickListeners();
    }

    //Lấy danh sách chuyến bay nội địa
    private void fetchNoiDiaList() {
        httpRequest.callAPI().getListGiaVeNoiDia().enqueue(getListNoiDiaDistributor);
    }

    Callback<Response<ArrayList<plane_GiaVeNoiDia_Model>>> getListNoiDiaDistributor = new Callback<Response<ArrayList<plane_GiaVeNoiDia_Model>>>() {
        @Override
        public void onResponse(Call<Response<ArrayList<plane_GiaVeNoiDia_Model>>> call, retrofit2.Response<Response<ArrayList<plane_GiaVeNoiDia_Model>>> response) {
            if (response.isSuccessful() && response.body() != null) {
                if (response.body().getStatus() == 200) {
                    NoiDialist = new ArrayList<>();
                    NoiDialist = response.body().getData();
                    NoiDiaAdapter.setData(NoiDialist);
                    rcvCategory.setAdapter(NoiDiaAdapter);
                    for (plane_GiaVeNoiDia_Model item : NoiDialist) {
                        Log.i(TAG, "//==" + item.toString());
                    }
                } else {
                    Log.i(TAG, "Status not 200: " + response.body().getStatus());
                }
            } else {
                Log.i(TAG, "Response not successful or body is null");
            }
        }

        @Override
        public void onFailure(Call<Response<ArrayList<plane_GiaVeNoiDia_Model>>> call, Throwable t) {
            Log.i(TAG, "/Error==" + t.getMessage());
        }
    };

    //Lấy danh sách chuyến bay quốc tế
    private void fetchQuocTeList() {
        httpRequest.callAPI().getListGiaVeQuocTe().enqueue(getListQuocTeDistributor);
    }
    Callback<Response<ArrayList<plane_GiaVeQuocTe_Model>>> getListQuocTeDistributor = new Callback<Response<ArrayList<plane_GiaVeQuocTe_Model>>>() {
        @Override
        public void onResponse(Call<Response<ArrayList<plane_GiaVeQuocTe_Model>>> call, retrofit2.Response<Response<ArrayList<plane_GiaVeQuocTe_Model>>> response) {
            if (response.isSuccessful() && response.body() != null) {
                if (response.body().getStatus() == 200) {
                    QuocTelist = new ArrayList<>();
                    QuocTelist = response.body().getData();
                    QuocTeAdapter.setData(QuocTelist);
                    rcvCategory1.setAdapter(QuocTeAdapter);
                    for (plane_GiaVeQuocTe_Model item : QuocTelist) {
                        Log.i(TAG, "//==" + item.toString());
                    }
                } else {
                    Log.i(TAG, "Status not 200: " + response.body().getStatus());
                }
            } else {
                Log.i(TAG, "Response not successful or body is null");
            }
        }

        @Override
        public void onFailure(Call<Response<ArrayList<plane_GiaVeQuocTe_Model>>> call, Throwable t) {
            Log.i(TAG, "/Error==" + t.getMessage());
        }
    };


    //Lấy danh sách hãng bay
    private void fetchHangBayList() {
        httpRequest.callAPI().getHangBayList().enqueue(getListhangbay);
    }
    Callback<Response<List<TenChuyenBayModel>>> getListhangbay = new Callback<Response<List<TenChuyenBayModel>>>() {
        @Override
        public void onResponse(Call<Response<List<TenChuyenBayModel>>> call, retrofit2.Response<Response<List<TenChuyenBayModel>>> response) {
            if (response.isSuccessful() && response.body() != null) {
                if (response.body().getStatus() == 200) {
                    List<TenChuyenBayModel> chuyensBay = response.body().getData();

                    // Chuyển đổi danh sách thành mảng tên chuyến bay
                    String[] tenChuyenBayArray = new String[chuyensBay.size()];
                    for (int i = 0; i < chuyensBay.size(); i++) {
                        tenChuyenBayArray[i] = chuyensBay.get(i).getTenhangbay();
                    }

                    // Tạo ArrayAdapter và thiết lập cho Spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(plane_VeMayBay_Activity.this, android.R.layout.simple_spinner_item, tenChuyenBayArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    myspinner.setAdapter(adapter);
                } else {
                    Log.i(TAG, "Status not 200: " + response.body().getStatus());
                }
            } else {
                Log.i(TAG, "Response not successful or body is null");
            }
        }

        @Override
        public void onFailure(Call<Response<List<TenChuyenBayModel>>> call, Throwable t) {
            Log.i(TAG, "/Error==" + t.getMessage());
        }
    };


    //Lấy danh sách hãng ghế
    private void fetchTenGheList() {
        httpRequest.callAPI().getTenGheList().enqueue(getListtenghe);
    }
    Callback<Response<List<TenGheModel>>> getListtenghe = new Callback<Response<List<TenGheModel>>>() {
        @Override
        public void onResponse(Call<Response<List<TenGheModel>>> call, retrofit2.Response<Response<List<TenGheModel>>> response) {
            if (response.isSuccessful() && response.body() != null) {
                if (response.body().getStatus() == 200) {
                    List<TenGheModel> TenGhe = response.body().getData();

                    // Chuyển đổi danh sách thành mảng tên chuyến bay
                    String[] tenGheArray = new String[TenGhe.size()];
                    for (int i = 0; i < TenGhe.size(); i++) {
                        tenGheArray[i] = TenGhe.get(i).getTenghe();
                    }

                    // Tạo ArrayAdapter và thiết lập cho Spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(plane_VeMayBay_Activity.this, android.R.layout.simple_spinner_item, tenGheArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    myspinnertenghe.setAdapter(adapter);
                } else {
                    Log.i(TAG, "Status not 200: " + response.body().getStatus());
                }
            } else {
                Log.i(TAG, "Response not successful or body is null");
            }
        }

        @Override
        public void onFailure(Call<Response<List<TenGheModel>>> call, Throwable t) {
            Log.i(TAG, "/Error==" + t.getMessage());
        }
    };


    private void setupClickListeners() {
        ImageButton backButton = findViewById(R.id.back_button);

        MaterialButton tk = findViewById(R.id.timkiem);

        tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimKiemChuyenBayActivity();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePageActivity();
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

    private void openCartPageActivity() {
        Intent intent = new Intent(plane_VeMayBay_Activity.this, tour_Cart_Activity.class);
        startActivity(intent);
    }

    private void openTimKiemChuyenBayActivity() {
        Intent intent = new Intent(plane_VeMayBay_Activity.this, plane_TimKiemChuyenBay_Activity.class);
        startActivity(intent);
    }

    private void openHomePageActivity() {
        Intent intent = new Intent(plane_VeMayBay_Activity.this, hotel_MainHome_Activity.class);
        startActivity(intent);
    }
}