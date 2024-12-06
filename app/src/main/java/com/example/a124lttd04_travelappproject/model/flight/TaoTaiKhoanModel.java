package com.example.a124lttd04_travelappproject.model.flight;

public class TaoTaiKhoanModel {
    private String tenkhachhang;
    private String taikhoan;
    private String matkhau;

    public TaoTaiKhoanModel() {
    }

    public TaoTaiKhoanModel(String tenkhachhang, String taikhoan, String matkhau) {
        this.tenkhachhang = tenkhachhang;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "TaoTaiKhoanModel{" +
                "tenkhachhang='" + tenkhachhang + '\'' +
                ", taikhoan='" + taikhoan + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }
}
