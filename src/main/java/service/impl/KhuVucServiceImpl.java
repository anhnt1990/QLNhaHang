/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.KhuVucCustom;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.KhuVucRepositoryImpl;
import repository.impl.NhanVienRepositoryImpl;
import service.ICommonService;
import util.Validate;

/**
 *
 * @author admin
 */
public class KhuVucServiceImpl implements ICommonService<KhuVucCustom> {

    private KhuVucRepositoryImpl repo;

    public KhuVucServiceImpl() {
        repo = new KhuVucRepositoryImpl();
    }

    @Override
    public List<KhuVucCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(KhuVucCustom t) {  
        return "";
    }
    
    public KhuVucCustom getById(int id) {
        return this.repo.getById(id);
    }
    
}
