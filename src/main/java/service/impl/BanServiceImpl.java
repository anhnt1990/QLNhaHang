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
public class BanServiceImpl implements ICommonService<BanCustom>{

    private BanRepositoryImpl repo;
    private List<BanCustom> list;

    public BanServiceImpl() {
        repo = new BanRepositoryImpl();
        list = new ArrayList<>();
    }
    
    public List<BanCustom> getList(String maBan){
        return this.repo.searchByMa(maBan);
    }

    @Override
    public List<BanCustom> getLists() {
        List<Ban> listBan = this.repo.getAll();
        for (Ban ban : listBan) {
            list.add(new BanCustom(ban.getId(), ban.getMaBan(), ban.getSoLuongChoNgoi()
                    , ban.getTrangThai(), ban.getIdKhuVuc().getId()));
        }
        return list;
    }

    @Override
    public List<BanCustom> search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        }else{
            mess = "That bai";
        }
        return mess;
    }

    @Override
    public String delete(BanCustom t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
