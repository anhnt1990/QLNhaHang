/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Custom.DanhMucCustom;
import Custom.ThucDonCustom;
import entity.DanhMuc;
import entity.MonAn;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DanhMucRepository;
import repository.impl.ThucDonRepository;
import service.ICommonService;

/**
 *
 * @author hieu
 */
public class ThucDonService implements ICommonService<ThucDonCustom>{
 ICommonRepository<MonAn> repothucdon;
    List<ThucDonCustom> lstthucdon;
    DanhMucService danhmucservice;
    public ThucDonService(){
        repothucdon = new ThucDonRepository();
        danhmucservice = new DanhMucService();
    }
    @Override
    public List<ThucDonCustom> getLists() {
        lstthucdon = new ArrayList<>();
        var colorr = repothucdon.getAll();
        for (MonAn x : colorr) {
            DanhMucCustom dmct = new DanhMucCustom();
            dmct.setId(x.getDanhMuc().getId());
            dmct.setMaLoai(x.getDanhMuc().getMaLoai());
            dmct.setTenLoai(x.getDanhMuc().getTenLoai());
            lstthucdon.add(new ThucDonCustom(x.getId(), 
                    x.getMaMon(), 
                    x.getTenMon(), 
                    x.getDonViTinh(), 
                    x.getHinhAnh(), 
                    x.getDonGia(), 
                    x.getGhiChu(), 
                    x.getTrangThai(), 
                    dmct));
        }
        return lstthucdon;
    }
    
    MonAn getmonan(ThucDonCustom thucdon){
        MonAn monan = new MonAn();
        monan.setId(thucdon.getId());
        monan.setMaMon(thucdon.getMaMon());
        monan.setTenMon(thucdon.getTenMon());
        monan.setDonViTinh(thucdon.getDonViTinh());
        monan.setGhiChu(thucdon.getGhiChu());
        monan.setHinhAnh(thucdon.getHinhAnh());
        monan.setTrangThai(thucdon.getTrangThai());
        monan.setDanhMuc(new DanhMuc(thucdon.getDanhMuc().getId(),thucdon.getDanhMuc().getMaLoai(),thucdon.getDanhMuc().getTenLoai()));
        monan.setDonGia(thucdon.getDonGia());
        
        return monan;
    }

    @Override
    public List<ThucDonCustom> search(String key) {
        List<ThucDonCustom> dm = new ArrayList<>();
       List<MonAn> danhmuc = new ArrayList<>();
        for (MonAn x : repothucdon.getAll()) {
            if (x.getTenMon().toLowerCase().contains(key.toLowerCase()) ) {
               // dm.add(new ThucDonCustom(x.getId(), x.getMaMon(), x.getTenMon(), x.getDonViTinh(), x.getHinhAnh(), x.getDonGia(),x.getGhiChu(), x.getTrangThai(),x.getDanhMuc()));
            }
            if (x.getMaMon().toLowerCase().contains(key.toLowerCase()) ) {
               // dm.add(new ThucDonCustom(x.getId(), x.getMaMon(), x.getTenMon(), x.getDonViTinh(), x.getHinhAnh(), x.getDonGia(),x.getGhiChu(), x.getTrangThai(), x.getDanhMuc()));
            }
        }
        return dm;
    }

    @Override
    public String addOrUpdate(ThucDonCustom t) {
       boolean checkdm = repothucdon.addOrUpdate(getmonan(t));
        if (checkdm == false) {
            return "sửa ko thành công";
        }
        return "thành công";
    }

    @Override
    public String delete(ThucDonCustom t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
