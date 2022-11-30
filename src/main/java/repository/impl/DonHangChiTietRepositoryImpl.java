/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.DonHangChiTietCustom;
import custom.DonHangCustom;
import entity.DonHang;
import entity.DonHangChiTiet;
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
public class DonHangChiTietRepositoryImpl implements ICommonRepository<DonHangChiTiet, DonHangChiTietCustom> {

    @Override
    public boolean addOrUpdate(DonHangChiTiet t) {
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
    public List<DonHangChiTietCustom> findByKey(String key) {
        List<DonHangChiTietCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangChiTietCustom(a.id, a.soLuong, "
                    + "a.donGia, a.idDonHang.id, a.idMonAn.id) FROM DonHangChiTiet a"
                    + " WHERE  a.idMonAn.maMon LIKE CONCAT('%',:monAn,'%')";
            TypedQuery<DonHangChiTietCustom> query = session.createQuery(hql, DonHangChiTietCustom.class);
            query.setParameter("monAn", key);
            list = query.getResultList();
        }
        return list;
    }

    public DonHangChiTietCustom getDonHang(String id) {
        DonHangChiTietCustom donHangChiTiet = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangChiTietCustom(a.id, a.soLuong, "
                    + "a.donGia, a.idDonHang.id, a.idMonAn.id) FROM DonHangChiTiet a"
                    + " WHERE  a.idMonAn.maMon LIKE CONCAT('%',:monAn,'%')";
            TypedQuery<DonHangChiTietCustom> query = session.createQuery(hql, DonHangChiTietCustom.class);
            query.setParameter("ma", id);
            donHangChiTiet = query.getSingleResult();
        }
        return donHangChiTiet;
    }

}
