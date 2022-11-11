/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import entity.Ban;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author ngocKhanh
 */
public class BanRepository implements ICommonRepository<Ban>{

    @Override
    public List<Ban> getAll() {
         List<Ban> lists = new ArrayList<Ban>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT m FROM Ban m";
            TypedQuery<Ban> query = session.createQuery(hql, Ban.class);
            lists = query.getResultList();
        }
        return lists;
    }

    @Override
    public boolean addOrUpdate(Ban t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Ban t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ban getOne(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean UpdateBan(Ban ban){
         try {     
             Session session = HibernateUtil.getFACTORY().openSession(); 
             Transaction tran = session.beginTransaction();
            String hql = "UPDATE Ban SET tenBan = :ten,trangThai =:tt  WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("ten", ban.getTenBan());
            query.setParameter("tt", ban.getTrangThai());
            query.setParameter("id", ban.getId());
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
    
    public boolean UpdateTrangThaiban(Ban ban){
         try {     
             Session session = HibernateUtil.getFACTORY().openSession(); 
             Transaction tran = session.beginTransaction();
            String hql = "UPDATE Ban SET trangThai =:tt  WHERE id = :id";
            Query query = session.createQuery(hql);           
            query.setParameter("tt", ban.getTrangThai());
            query.setParameter("id", ban.getId());
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
    
    public List<Ban> Getban() {
      List<Ban> result = null;
      try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from Ban a ";
            javax.persistence.Query query = session.createQuery(hql);
            
            result = query.getResultList();
        }
      
        return result;
        }
    
}
