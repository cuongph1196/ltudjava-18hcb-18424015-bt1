/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava.pkg18hcb.pkg18424015.bt1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author phanc
 */
public class Ltudjava18hcb18424015Bt1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        System.out.println("Hello World!");
//        Person a = new Person();
//        a.Name = "Phan huy cuong";
//        a.Age = 22;
//        a.Height = 173;
//        System.out.println(a.Name);

        
        //SV
        SinhVien a = new SinhVien();
//        a.ReadFile("../Data/Person.csv");
        //xem ds lớp
//        a.ReadFile("18HCB");
//        a.WriteFile("../Data/Person.csv", "18HCB");
//        a.WriteFileFromKey("18HCB");
        
        //TKB
        ThoiKhoaBieu tkb = new ThoiKhoaBieu();
//        tkb.WriteFile("../Data/TKB.csv", "18HCB");
//        tkb.ReadFile("18HCB");
        
        //Mon hoc - lop
        Lop_Monhoc lmh = new Lop_Monhoc();
//        lmh.DeleteSV("CTT001", "18HCB", "1742001");
//        lmh.AddSVFromKey("CTT001", "18HCB");
        //xem ds lớp môn học
//        lmh.ReadFile("18HCB","CTT001");

        //Diem
        Diem d = new Diem();
//        d.WriteFile("../Data/Diem.csv", "18HCB", "CTT001");
//        d.ReadFile("18HCB","CTT001");
//        d.XepLoaiSV("18HCB","CTT001");
        d.ThongKeSV("18HCB","CTT001");
    }
}
