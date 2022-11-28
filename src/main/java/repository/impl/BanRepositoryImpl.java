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
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class BanRepositoryImpl implements ICommonRepository<Ban,BanCustom>{



    @Override
    public boolean addOrUpdate(Ban t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<BanCustom> searchByMa(String maBan) {
        List<BanCustom> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a"
                    + " WHERE a.maBan = :maBan";
            TypedQuery<BanCustom> query = session.createQuery(hql,BanCustom.class);
            query.setParameter("maBan", maBan);
            list = query.getResultList();
        }
        return list;
    }

    @Override
    public List<BanCustom> findByKey(String key) {
        List<BanCustom> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "Select new custom.BanCustom(a.id, a.maBan, "
                    + "a.soLuongChoNgoi, a.trangThai, a.idKhuVuc.id) FROM Ban a"
                    + " WHERE a.maBan = :maBan";
            TypedQuery<BanCustom> query = session.createQuery(hql,BanCustom.class);
            query.setParameter("maBan", key);
            list = query.getResultList();
        }
        return list;
    }

    
}
