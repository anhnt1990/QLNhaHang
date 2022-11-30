/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.KhuVucCustom;
import entity.KhuVuc;
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
public class KhuVucRepositoryImpl implements ICommonRepository<KhuVuc, KhuVucCustom> {

    @Override
    public boolean addOrUpdate(KhuVuc t) {
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
    public List<KhuVucCustom> findByKey(String key) {
        List<KhuVucCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.KhuVucCustom(a.id, a.maKV, "
                    + "a.tenKV, a.trangThai) FROM KhuVuc a"
                    + " WHERE a.maKV LIKE CONCAT('%',:ma,'%') OR a.tenKV LIKE CONCAT('%',:hoTen,'%')";
            TypedQuery<KhuVucCustom> query = session.createQuery(hql, KhuVucCustom.class);
            query.setParameter("ma", key);
            query.setParameter("hoTen", key);
            list = query.getResultList();
        }
        return list;
    }

    public KhuVucCustom getById(int id) {
        KhuVucCustom khuVuc = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.KhuVucCustom(a.id, a.maKV, "
                    + "a.tenKV, a.trangThai) FROM KhuVuc a"
                    + " WHERE a.id = :id";
            TypedQuery<KhuVucCustom> query = session.createQuery(hql, KhuVucCustom.class);
            query.setParameter("id", id);
            khuVuc = query.getSingleResult();
        }
        return khuVuc;
    }

}
