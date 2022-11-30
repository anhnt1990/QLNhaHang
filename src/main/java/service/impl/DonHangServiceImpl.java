/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.DonHangCustom;
import custom.NhanVienCustom;
import entity.DonHang;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DonHangRepositoryImpl;
import repository.impl.NhanVienRepositoryImpl;
import service.ICommonService;
import util.Validate;

/**
 *
 * @author admin
 */
public class DonHangServiceImpl implements ICommonService<DonHangCustom> {

    private DonHangRepositoryImpl repo;

    public DonHangServiceImpl() {
        repo = new DonHangRepositoryImpl();
    }

    @Override
    public List<DonHangCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(DonHangCustom t) {
        String mess;
        if (this.repo.addOrUpdate(new DonHang(t.getId(), t.getMaDH(), t.getNgayTao()
                , t.getNgayDatBan(), t.getTrangThai(), t.getGhiChu(), , idNhanVien, idKhuyenMai)) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    public NhanVienCustom checkLogin(String user, String pass) {
        NhanVienCustom nhanVien = this.repo.getNhanVien(user, pass);
        if (nhanVien == null) {
            nhanVien = null;
        }
        return nhanVien;
    }

}
