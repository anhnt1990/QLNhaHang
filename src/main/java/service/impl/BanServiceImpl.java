/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.BanCustom;
import entity.Ban;
import entity.KhuVuc;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class BanServiceImpl implements ICommonService<BanCustom> {

    private BanRepositoryImpl repo;
    private List<BanCustom> list;

    public BanServiceImpl() {
        repo = new BanRepositoryImpl();
        list = new ArrayList<>();
    }

    @Override
    public List<BanCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(BanCustom t) {
        String mess = "";
        KhuVuc kv = new KhuVuc();
        kv.setMaKV("KV1");
        kv.setTenKV("Tầng 1");
        kv.setTrangThai(0);
        if (this.repo.addOrUpdate(new Ban(t.getId(), t.getMaBan(),
                t.getSoLuongChoNgoi(), t.getTrangThai(), kv))) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    public List<BanCustom> Getban(String ma) {
        return this.repo.Getban(ma);
    }
    
    public List<BanCustom> getkhuvuc(int idkv) {
        return this.repo.getkhuvuc(idkv);
    }

}
