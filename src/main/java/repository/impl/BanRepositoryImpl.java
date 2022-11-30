/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.BanCustom;
import entity.Ban;
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
public class BanRepositoryImpl implements ICommonRepository<Ban, BanCustom> {

    @Override
    public boolean addOrUpdate(Ban t) {
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

    public List<BanCustom> Getban(String ma) {
        List<BanCustom> result = null;
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            hql = "select custom.BanCustom(a.id, a.maBan, a.soLuongChoNgoi,"
                    + "a.trangThai,a.idKhuVuc.id) from Ban a WHERE a.maBan = :maban";
            Query query = session.createQuery(hql);
            query.setParameter("maban", ma);
            result = query.getResultList();
        }

        return result;
    }

    @Override
    public List<BanCustom> findByKey(String key) {
        List<BanCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a"
                    + " WHERE a.maBan LIKE CONCAT('%',:ma,'%')";
            TypedQuery<BanCustom> query = session.createQuery(hql, BanCustom.class);
            query.setParameter("ma", key);
            list = query.getResultList();
        }
        return list;
    }

    public List<BanCustom> getkhuvuc(int idkv) {
        List<BanCustom> result = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a"
                    + " WHERE a.idKhuVuc.id = :idkv";
            Query query = session.createQuery(hql);
            query.setParameter("idkv", idkv);
            result = query.getResultList();
        }

        return result;
    }

}
