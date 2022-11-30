/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.BanCustom;
import custom.KhuyenMaiCustom;
import custom.MonAnCustom;
import entity.Ban;
import entity.KhuyenMai;
import entity.MonAn;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class MonAnRepositoryImpl implements ICommonRepository<MonAn, MonAnCustom> {

    @Override
    public boolean addOrUpdate(MonAn t) {
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
    public List<MonAnCustom> findByKey(String key) {
        List<MonAnCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.MonAnCustom(a.id, a.maMon, "
                    + "a.tenMon, a.donViTinh, a,hinhAnh, a.donGia, a.ghiChu, a.trangThai, a.idDanhMuc.id) FROM KhuyenMai a"
                    + " WHERE a.maMon LIKE CONCAT('%',:ma,'%')";
            TypedQuery<MonAnCustom> query = session.createQuery(hql, MonAnCustom.class);
            query.setParameter("ma", key);
            list = query.getResultList();
        }
        return list;
    }
    
    public MonAnCustom getById(int id){
        MonAnCustom monAn = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.MonAnCustom(a.id, a.maMon, "
                    + "a.tenMon, a.donViTinh, a,hinhAnh, a.donGia, a.ghiChu, a.trangThai, a.idDanhMuc.id) FROM KhuyenMai a"
                    + " WHERE a.id = :id";
            TypedQuery<MonAnCustom> query = session.createQuery(hql, MonAnCustom.class);
            query.setParameter("id", id);
            monAn = query.getSingleResult();
        }
        return monAn;
    }

}
