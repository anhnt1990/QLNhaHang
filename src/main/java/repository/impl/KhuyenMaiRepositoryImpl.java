/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.BanCustom;
import custom.KhuyenMaiCustom;
import entity.Ban;
import entity.KhuyenMai;
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
public class KhuyenMaiRepositoryImpl implements ICommonRepository<KhuyenMai, KhuyenMaiCustom> {

    @Override
    public boolean addOrUpdate(KhuyenMai t) {
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
    public List<KhuyenMaiCustom> findByKey(String key) {
        List<KhuyenMaiCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.KhuyenMaiCustom(a.id, a.maGiamGia, "
                    + "a.phanTram, a.ngayBatDau, a,ngayKetThuc,a.trangThai) FROM KhuyenMai a"
                    + " WHERE a.maGiamGia LIKE CONCAT('%',:ma,'%')";
            TypedQuery<KhuyenMaiCustom> query = session.createQuery(hql, KhuyenMaiCustom.class);
            query.setParameter("ma", key);
            list = query.getResultList();
        }
        return list;
    }


}
