package com.example.a124lttd04_travelappproject.CongServices;

import com.example.a124lttd04_travelappproject.model.flight.HanhLyModel;
import com.example.a124lttd04_travelappproject.model.flight.NoidenModel;
import com.example.a124lttd04_travelappproject.model.flight.NoidiModel;
import com.example.a124lttd04_travelappproject.model.flight.TaoKhoanModel;
import com.example.a124lttd04_travelappproject.model.flight.TaoTaiKhoanModel;
import com.example.a124lttd04_travelappproject.model.flight.TenChuyenBayModel;
import com.example.a124lttd04_travelappproject.model.flight.TenGheModel;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeNoiDia_Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import com.example.a124lttd04_travelappproject.model.flight.Response;
import com.example.a124lttd04_travelappproject.model.flight.plane_GiaVeQuocTe_Model;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    String url = "http://192.168.101.13:3009/";

    @GET("noidia")
    Call<Response<ArrayList<plane_GiaVeNoiDia_Model>>> getListGiaVeNoiDia();

    @GET("quocte")
    Call<Response<ArrayList<plane_GiaVeQuocTe_Model>>> getListGiaVeQuocTe();

    @GET("ListNoiDi") // Replace with your actual endpoint
    Call<Response<List<NoidiModel>>> getNoidiList();
    @GET("ListNoiDen") // Replace with your actual endpoint
    Call<Response<List<NoidenModel>>> getNoidenList();

    @GET("ListHangBay")
    Call<Response<List<TenChuyenBayModel>>> getHangBayList();

    @GET("ListTenGhe")
    Call<Response<List<TenGheModel>>> getTenGheList();

    @GET("ListHanhLy")
    Call<Response<ArrayList<HanhLyModel>>> getHanhLyList();

    @POST("login")
    Call<Response> login(@Body TaoKhoanModel userData);

    @POST("insert")
    Call<Response> Insert(@Body TaoTaiKhoanModel NewUserData);
}
