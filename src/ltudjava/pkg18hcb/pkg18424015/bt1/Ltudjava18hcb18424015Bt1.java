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
import java.io.File;
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
        File directory = new File("database/");
        if (!directory.exists()) {
            directory.mkdir();
        }
        if(args.length<2){
            System.out.println("Vui lòng truyền đúng tham số !!!");
        }else{
            int funcID = Integer.parseInt(args[0]);
            //SV
            SinhVien sv = new SinhVien();
            File dirSV = new File("database/lop/");
            if (!dirSV.exists()) {
                dirSV.mkdir();
            }
            //TKB
            ThoiKhoaBieu tkb = new ThoiKhoaBieu();
            File dirtkb = new File("database/tkb/");
            if (!dirtkb.exists()) {
                dirtkb.mkdir();
            }
            //Mon hoc - lop
            Lop_Monhoc lmh = new Lop_Monhoc();
            File dirlmh = new File("database/lop_monhoc/");
            if (!dirlmh.exists()) {
                dirlmh.mkdir();
            }
            //Diem
            Diem diem = new Diem();
            File dirdiem = new File("database/diem/");
            if (!dirdiem.exists()) {
                dirdiem.mkdir();
            }
            
            switch (funcID) {
                case 1:
                    {
                        //import danh sách lớp
                        String pathInput = args[1];
                        String className = args[2];
                        sv.WriteFile(pathInput, className);
                        break;
                    }
                case 2:
                    {
                        //thêm 1 sv
                        String className = args[1];
                        sv.WriteFileFromKey(className);
                        break;
                    }
                case 3:
                    {
                        //import tkb
                        String pathInput = args[1];
                        String className = args[2];
                        tkb.WriteFile(pathInput, className);
                        break;
                    }
                case 4:
                    {
                        //lưu ds lop-monhoc
                        String pathInput = args[1];
                        String className = args[2];
                        String subjectName = args[3];
                        lmh.WriteFile(pathInput, className, subjectName);
                        break;
                    }
                case 5:
                    {
                        //xoá sv khỏi lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        String MSSV = args[3];
                        lmh.DeleteSV(className, subjectName, MSSV);
                        break;
                    }
                case 6:
                    {
                        //thêm sv vào lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        lmh.AddSVFromKey(className, subjectName);
                        break;
                    }
                case 7:
                    {
                        //xem ds lớp
                        String className = args[1];
                        sv.ReadFile(className);
                        break;
                    }
                case 8:
                    {
                        //xem ds lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        lmh.ReadFile(className, subjectName);
                        break;
                    }
                case 9:
                    {
                        //xem ds tkb
                        String className = args[1];
                        tkb.ReadFile(className);
                        break;
                    }
                case 10:
                    {
                        //import điểm
                        String pathInput = args[1];
                        String className = args[2];
                        String subjectName = args[3];
                        diem.WriteFile(pathInput,className,subjectName);
                        break;
                    }
                case 11:
                    {
                        //xem điểm lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        diem.ReadFile(className,subjectName);
                        break;
                    }
                case 12:
                    {
                        //xem loại kq lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        diem.XepLoaiSV(className,subjectName);
                        break;
                    }
                case 13:
                    {
                        //thống kê lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        diem.ThongKeSV(className,subjectName);
                        break;
                    }
                case 14:
                    {
                        //sửa điểm 1 sv lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        String MSSV = args[3];
                        String GK = args[4];
                        String CK = args[5];
                        String Orther = args[6];
                        String Sum = args[7];
                        diem.UpdateDiemSV(className,subjectName,MSSV,GK,CK,Orther,Sum);
                        break;
                    }
                case 15:
                    {
                        //sv xem điểm lop-monhoc
                        String className = args[1];
                        String subjectName = args[2];
                        String MSSV = args[3];
                        diem.XemDiem(className,subjectName,MSSV);
                        break;
                    }
                default:
                    System.out.println("Vui lòng truyền đúng tham số !!!");
                    break;
            }
        }
        
//            SinhVien a = new SinhVien();
//    //        a.ReadFile("../Data/Person.csv");
//            //xem ds lớp
//    //        a.ReadFile("18HCB");
//            //a.WriteFile("../Data/Person.csv", "18HCB");
////            a.WriteFileFromKey("18HCB");
//
//            //TKB
//            ThoiKhoaBieu tkb = new ThoiKhoaBieu();
////            tkb.WriteFile("../Data/TKB.csv", "18HCB");
//    //        tkb.ReadFile("18HCB");
//
//            //Mon hoc - lop
//            Lop_Monhoc lmh = new Lop_Monhoc();
//    //        lmh.DeleteSV("18HCB", "CTT001", "1742001");
//    //        lmh.AddSVFromKey("18HCB", "CTT001");
//            //xem ds lớp môn học
//    //        lmh.ReadFile("18HCB","CTT001");
//
//            //Diem
//            Diem d = new Diem();
//    //        d.WriteFile("../Data/Diem.csv", "18HCB", "CTT001");
//    //        d.ReadFile("18HCB","CTT001");
//    //        d.XepLoaiSV("18HCB","CTT001");
////            d.ThongKeSV("18HCB","CTT001");
//            //d.UpdateDiemSV("18HCB","CTT001", "1742001","9","9","9","9");
////            d.XemDiem("18HCB","CTT001", "1742001");
    }
}
