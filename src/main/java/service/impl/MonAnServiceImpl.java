/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.MonAnCustom;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import repository.impl.MonAnRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class MonAnServiceImpl implements ICommonService<MonAnCustom> {

    private MonAnRepositoryImpl repo;

    public MonAnServiceImpl() {
        repo = new MonAnRepositoryImpl();
    }

    @Override
    public List<MonAnCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(MonAnCustom t) {
        
        return "";
    }

    public MonAnCustom getById(int id){
        return this.repo.getById(id);
    }

}
