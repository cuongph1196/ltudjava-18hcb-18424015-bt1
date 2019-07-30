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
//        if(args.length<2){
//            System.out.println("Vui lòng truyền đúng tham số !!!");
//        }else{
//            int funcID = Integer.parseInt(args[0]);//theo thứ tự yêu cầu
//            SinhVien sv = new SinhVien();
//            //SV
//            if(funcID == 1){ //import danh sách lớp
//                String pathInput = args[1];
//                String className = args[2];
//                sv.WriteFile(pathInput, className);
//            }
//            else if(funcID == 2){//thêm 1 sv
//                String className = args[1];
//                sv.WriteFileFromKey(className);
//            }
//        }
        
        SinhVien a = new SinhVien();
    //        a.ReadFile("../Data/Person.csv");
            //xem ds lớp
    //        a.ReadFile("18HCB");
//            a.WriteFile("../Data/Person.csv", "18HCB");
//            a.WriteFileFromKey("18HCB");

            //TKB
            ThoiKhoaBieu tkb = new ThoiKhoaBieu();
//            tkb.WriteFile("../Data/TKB.csv", "18HCB");
    //        tkb.ReadFile("18HCB");

            //Mon hoc - lop
            Lop_Monhoc lmh = new Lop_Monhoc();
    //        lmh.DeleteSV("18HCB", "CTT001", "1742001");
    //        lmh.AddSVFromKey("18HCB", "CTT001");
            //xem ds lớp môn học
    //        lmh.ReadFile("18HCB","CTT001");

            //Diem
            Diem d = new Diem();
    //        d.WriteFile("../Data/Diem.csv", "18HCB", "CTT001");
    //        d.ReadFile("18HCB","CTT001");
    //        d.XepLoaiSV("18HCB","CTT001");
//            d.ThongKeSV("18HCB","CTT001");
            d.UpdateDiemSV("18HCB","CTT001", "1742001","9","9","9","9");
    }
}
