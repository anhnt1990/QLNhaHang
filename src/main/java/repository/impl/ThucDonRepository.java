/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.MonAn;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author hieu
 */
public class ThucDonRepository implements ICommonRepository<MonAn>{

    @Override
    public List<MonAn> getAll() {
        List<MonAn> monan;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
        String hql ="SELECT m FROM MonAn m";
        TypedQuery<MonAn> query = session.createQuery(hql,MonAn.class);
        monan= query.getResultList();
                }
        return monan;
    }

    @Override
    public boolean addOrUpdate(MonAn t) {
         try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(t);
                trans.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                return false;
            }
        } 
    }

    @Override
    public boolean delete(MonAn t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MonAn> searchByKey(String key) {
       List<MonAn> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("SELECT m FROM ThucDon m WHERE "
                    + "a.maLoai LIKE CONCAT('%',:ma,'%') OR a.tenLoai LIKE CONCAT('%',:ten,'%')");
            query.setParameter("ma", key);
            query.setParameter("ten", key);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }
    
}
