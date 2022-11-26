/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Custom.DanhMucCustom;
import entity.DanhMuc;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DanhMucRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class DanhMucService implements ICommonService<DanhMucCustom> {

    private DanhMucRepository _repodanhmuc;
    List<DanhMucCustom> _lstDanhMuc;

    public DanhMucService() {
        _repodanhmuc = new DanhMucRepository();
        _lstDanhMuc = new ArrayList<>();
    }
    
    DanhMuc getdanhmuc(DanhMucCustom danhmucc){
        DanhMuc danhmuc = new DanhMuc();
        danhmuc.setId(danhmucc.getId());
        danhmuc.setMaLoai(danhmucc.getMaLoai());
        danhmuc.setTenLoai(danhmucc.getTenLoai());
        return danhmuc;
    }

    @Override
    public List<DanhMucCustom> getLists() {
         _lstDanhMuc = new ArrayList<>();
        var colorr = _repodanhmuc.getAll();
        for (DanhMuc x : colorr) {
            _lstDanhMuc.add(new DanhMucCustom(x.getId(),x.getMaLoai(), x.getTenLoai()));
        }
        return _lstDanhMuc;
    }

    @Override
    public List<DanhMucCustom> search(String key) {
        List<DanhMucCustom> dm = new ArrayList<>();
       List<DanhMuc> danhmuc = new ArrayList<>();
        for (DanhMuc x : _repodanhmuc.getAll()) {
            if (x.getTenLoai().toLowerCase().contains(key.toLowerCase()) ) {
                dm.add(new DanhMucCustom(x.getId(),x.getMaLoai(), x.getTenLoai()));
                System.out.println(dm + "ádsd");
            }
        }
        return dm;
    }

    @Override
    public String addOrUpdate(DanhMucCustom t) {
       boolean checkdm = _repodanhmuc.addOrUpdate(getdanhmuc(t));
        if (checkdm == false) {
            return "sửa ko thành công";
        }
        return "thành công";
    }
    
    public String Them(DanhMucCustom danhmuccustom){
            DanhMuc dm = _repodanhmuc.insert(getdanhmuc(danhmuccustom));
            if (dm == null) {
            return "Thêm ko thành công";
        }
            return "Thêm Thành công";
    }

    @Override
    public String delete(DanhMucCustom t) {
//        if (repo.delete(t)) {
//            return "Thanh cong";
//        }
        return "That bai";
    }

}
