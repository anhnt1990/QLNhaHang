
package repository.impl;

import entity.DanhMuc;
import entity.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class DanhMucRepository implements ICommonRepository<DanhMuc>{

    @Override
    public List<DanhMuc> getAll() {
        List<DanhMuc> danhmuc;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
        String hql ="SELECT d FROM DanhMuc d";
        TypedQuery<DanhMuc> query = session.createQuery(hql,DanhMuc.class);
        danhmuc= query.getResultList();
                }
        return danhmuc;
    }

    @Override
    public boolean addOrUpdate(DanhMuc t) {
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
        } finally {
            return true;
        }
    }

    @Override
    public boolean delete(DanhMuc t) {
        boolean check = false;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction trans = session.beginTransaction();
            try{
                session.delete(t);
                trans.commit();
                check = true;
            }catch(Exception e){
                e.printStackTrace();
                trans.rollback();
            }
        }
        return check;
    }

    @Override
    public List<DanhMuc> searchByKey(String key) {
        List<DanhMuc> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("SELECT a FROM DanhMuc a WHERE "
                    + "a.maLoai LIKE CONCAT('%',:ma,'%') OR a.tenLoai LIKE CONCAT('%',:ten,'%')");
            query.setParameter("ma", key);
            query.setParameter("ten", key);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }
    
    public DanhMuc insert(DanhMuc danhmuc){
        danhmuc.setId(0);
       try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(danhmuc);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
               danhmuc = null;
            }
        } finally {
            return danhmuc;
        }
    }
    
   
}
