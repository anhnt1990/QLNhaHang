/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

import java.math.BigDecimal;

/**
 *
 * @author hieu
 */
public class ThucDonCustom {
     
    private int id;
    
    
    private String maMon;
    
    
    private String tenMon;
    
   
    private String donViTinh;
    
   
    private String hinh;
    
    
    private BigDecimal donGia;
    
    
    private String ghiChu;
    
    private DanhMucCustom danhMuc;
    
    private DonViTinhCustom donvitinh;

    public ThucDonCustom() {
    }

    public ThucDonCustom(int id, String maMon, String tenMon, String donViTinh, String hinh, BigDecimal donGia, String ghiChu, DanhMucCustom danhMuc, DonViTinhCustom donvitinh) {
        this.id = id;
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donViTinh = donViTinh;
        this.hinh = hinh;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
        this.danhMuc = danhMuc;
        this.donvitinh = donvitinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public DanhMucCustom getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMucCustom danhMuc) {
        this.danhMuc = danhMuc;
    }

    public DonViTinhCustom getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(DonViTinhCustom donvitinh) {
        this.donvitinh = donvitinh;
    }
    
}
