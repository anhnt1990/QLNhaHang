/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hieu
 */
@Entity
@Table(name = "DonViTinh")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donvitinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "MaDonVi")
    private String MaDonVi;
    @Column(name = "MaTenDonVi")
    private String TenDonVi;
    public Object[] toRowData(){
        return new Object[] {id, MaDonVi, TenDonVi};
    }
}
