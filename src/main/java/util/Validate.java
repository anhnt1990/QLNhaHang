/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author admin
 */
public class Validate {
    
    public static String checkSdt = "0\\d{9}";
    public static final String checkString = "[a-zA-Z]+";
    public static String regexEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static String checkMaNV = "^NV\\d\\d$";
    public static void main(String[] args) {
        String sdt = "NV01";
        if (sdt.matches(checkMaNV)) {
            System.out.println("ok");
        }
    }
}
