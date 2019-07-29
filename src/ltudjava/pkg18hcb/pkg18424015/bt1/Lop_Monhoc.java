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
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author phanc
 */
public class Lop_Monhoc {
    int STT;
    String MSSV;
    String HoTen;
    boolean GioiTinh;
    String CMND;
    
    public void ReadFile(String className, String subjectName) throws FileNotFoundException, IOException{
        String pathInput = "../Data/"+ className + "_" + subjectName +".txt";
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
    
    public void DeleteSV(String subjectName, String className, String MSSV) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        File path = new File("../Data/"+ className + "_" + subjectName + ".txt");
        File path_temp = new File("../Data/"+ className + "_" + subjectName + "_Temp.txt");
        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);
//            System.out.println(br.readLine());
            FileWriter fw = new FileWriter(path_temp);
            bw = new BufferedWriter(fw);
            String i;
            while ((i = br.readLine()) != null) {
                System.out.println(i);
                String[] in = i.split(",");
                if(!(in[1].equals(MSSV))){
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
    public void AddSVFromKey(String subjectName, String className) throws IOException{
        BufferedReader dataInput = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter bw = null;
        String path = "../Data/"+ className + "_" + subjectName + ".txt";
        try {
            FileWriter fw = new FileWriter(path,true);
            bw = new BufferedWriter(fw);
            FileReader frOutput = new FileReader(path);
            BufferedReader brOutput = new BufferedReader(frOutput);
            String a;
            if((a = brOutput.readLine()) != null){
            }
            else{
                bw.write("STT,MSSV,Họ tên,Giới tính,CMND");
            }
            System.out.println("Hãy nhập thông tin sinh viên:");
            String value = dataInput.readLine();
            boolean flag = true;
            while((a = brOutput.readLine()) != null){
                String[] in= value.split(",");
                String[] out=a.split(",");
                if(in[1].equals(out[1])){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                bw.write(value);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            bw.close();
            System.out.println("Success...");
        }
    }
}
