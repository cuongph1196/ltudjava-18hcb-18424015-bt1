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
            if((a = brOutput.readLine()) != null){
                br.readLine();
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
}
