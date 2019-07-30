/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava.pkg18hcb.pkg18424015.bt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author phanc
 */
public class Diem {
    int STT;
    String MSSV;
    String HoTen;
    int DiemGK;
    int DiemCK;
    int DiemKhac;
    float DiemTong;
    
    public void ReadFile(String className, String subjectName) throws FileNotFoundException, IOException{
        String pathInput = "../Data/DIEM_"+ className + "_" + subjectName +".txt";
        BufferedReader br = null;
        try{
        FileReader fr = new FileReader(pathInput);
        br = new BufferedReader(fr);
        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            br.close();
        }
    }
    
    public void WriteFile(String pathInput, String className, String subjectName) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        String pathOutput = "../Data/DIEM_"+ className+ "_" + subjectName +".txt";
        try {
            FileWriter fw = new FileWriter(pathOutput,true);
            bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(pathInput);
            br = new BufferedReader(fr);
            FileReader frOutput = new FileReader(pathOutput);
            BufferedReader brOutput = new BufferedReader(frOutput);
            String i;
            String a ;
            String title = brOutput.readLine();
            if(title != null && !"".equals(title)){
                br.readLine();
            }
            else{
                bw.write(br.readLine());
                bw.newLine();
            }
            while ((i = br.readLine()) != null) {
                boolean flag = true;
                while((a = brOutput.readLine()) != null){
                    String[] in = i.split(",");
                    String[] out = a.split(",");
                    if(in[1].equals(out[1])){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    bw.write(i);
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            br.close();
            bw.close();
            System.out.println("Success...");
        }
    }
    
    public void XepLoaiSV(String className, String subjectName) throws IOException{
        BufferedReader br = null;
        File path = new File("../Data/DIEM_"+ className + "_" + subjectName + ".txt");
        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);
            String i;
            System.out.print(br.readLine());
            System.out.println(",Kết quả");
            while ((i = br.readLine()) != null) {
//                System.out.println(i);
                String[] in = i.split(",");
                if(Float.parseFloat(in[6]) >= 5){
                    System.out.print(i);
                    System.out.println(",Đậu");
                }else{
                    System.out.print(i);
                    System.out.println(",Rớt");
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            br.close();
            System.out.println("Success...");
        }
    }
    
    public void ThongKeSV(String className, String subjectName) throws IOException{
        BufferedReader br = null;
        File path = new File("../Data/DIEM_"+ className + "_" + subjectName + ".txt");
        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);
            String i;
            int countDau = 0, countRot = 0, countTong = 0;
            br.readLine();
            while ((i = br.readLine()) != null) {
//                System.out.println(i);
                countTong++;
                String[] in = i.split(",");
                if(Float.parseFloat(in[6]) >= 5){
                    countDau++;
                }else{
                    countRot++;
                }
            }
            //Xuất thông báo:
            if(countTong > 0){
                System.out.printf("Số lượng đậu: %d (SV)%n",countDau);
                System.out.printf("Phần trăm đậu: %d ",countDau*100/countTong);
                System.out.println("(%)");
                System.out.printf("Số lượng rớt: %d (SV)%n",countRot);
                System.out.printf("Phần trăm rớt: %d ",countRot*100/countTong);
                System.out.println("(%)");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            br.close();
            System.out.println("Success...");
        }
    }
    
    public void UpdateDiemSV(String className, String subjectName, String MSSV, String GK, String CK, String Orther, String Sum) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        File path = new File("../Data/DIEM_"+ className + "_" + subjectName + ".txt");
        File path_temp = new File("../Data/DIEM_"+ className + "_" + subjectName + "_Temp.txt");
        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);
//            System.out.println(br.readLine());
            FileWriter fw = new FileWriter(path_temp);
            bw = new BufferedWriter(fw);
            String i;
            while ((i = br.readLine()) != null) {
                String[] in = i.split(",");
                if((in[1].equals(MSSV))){
                    bw.write(in[0]+","+in[1]+","+in[2]+","+GK+","+CK+","+Orther+","+ Float.toString(Float.parseFloat(Sum)));
                    bw.newLine();
                }
                else{
                    bw.write(i);
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            br.close();
            bw.close();
            if(path.delete()){
                boolean successful = path_temp.renameTo(path);
                if(successful)
                System.out.println("Success...");
                else
                System.out.println("Failed...");
            }
        }
    }
}
