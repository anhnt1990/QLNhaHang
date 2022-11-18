/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import entity.DonHangChiTiet;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DonHangChiTietRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class DonHangChiTietService implements ICommonService<DonHangChiTiet> {

    private ICommonRepository repo;

    public DonHangChiTietService() {
        this.repo = new DonHangChiTietRepository();
    }

    @Override
    public List<DonHangChiTiet> getLists() {
        return repo.getAll();
    }

    @Override
    public List<DonHangChiTiet> search(String key) {
        return repo.searchByKey(key);
    }

    @Override
    public String addOrUpdate(DonHangChiTiet t) {
        if (repo.addOrUpdate(t)) {
            return "Thanh cong";
        }else if(t.getId() == 0){
            return "bbbb";
        }
        return "That bai";
    }

    @Override
    public String delete(DonHangChiTiet t) {
        if (repo.delete(t)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public DonHangChiTiet getOne(String ma) {
        return (DonHangChiTiet) this.repo.getOne(ma);
    }

}
