/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.DonHangCustom;
import custom.NhanVienCustom;
import entity.DonHang;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class DonHangRepositoryImpl implements ICommonRepository<DonHang, DonHangCustom> {

    @Override
    public boolean addOrUpdate(DonHang t) {
        boolean check = false;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.saveOrUpdate(t);
                tran.commit();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                tran.rollback();
            }
        }
        return check;
    }

    @Override
    public List<DonHangCustom> findByKey(String key) {
        List<DonHangCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangCustom(a.id, a.maDH, "
                    + "a.ngayTao, a.ngayDatBan, a.trangThai, a.ghiChu, a.idBan.id, "
                    + "a.idNhanVien.id, a.idKhuyenMai.id) FROM DonHang a"
                    + " WHERE a.maDH LIKE CONCAT('%',:ma,'%') ";
            TypedQuery<DonHangCustom> query = session.createQuery(hql, DonHangCustom.class);
            query.setParameter("ma", key);
            query.setParameter("hoTen", key);
            list = query.getResultList();
        }
        return list;
    }

    public DonHangCustom getDonHangByMa(String maBan) {
        DonHangCustom donHang = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangCustom(a.id, a.maDH, "
                    + "a.ngayTao, a.ngayDatBan, a.trangThai, a.ghiChu, a.idBan.id, "
                    + "a.idNhanVien.id, a.idKhuyenMai.id) FROM DonHang a"
                    + " WHERE a.idBan.maBan = :maBan AND a.trangThai = :tt";
            TypedQuery<DonHangCustom> query = session.createQuery(hql, DonHangCustom.class);
            query.setParameter("maBan", maBan);
            query.setParameter("tt", 0);
            donHang = query.getSingleResult();
        }
        return donHang;
    }

    public boolean updateDonHangGiamGia(DonHang dh) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE DonHang SET idKhuyenMai = :km WHERE maDH = :maDH";
            TypedQuery query = session.createQuery(hql);
            query.setParameter("km", dh.getIdKhuyenMai());
            query.setParameter("maDH", dh.getMaDH());
            if (query.executeUpdate() < 1) {
                return false;
            }
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
