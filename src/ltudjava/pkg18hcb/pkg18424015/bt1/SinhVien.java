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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author phanc
 */
public class SinhVien {
    int STT;
    String MSSV;
    String HoTen;
    boolean GioiTinh;
    String CMND;
    
    public String GetMSSV(){
        return MSSV;
    }
    public String GetHoTen(){
        return HoTen;
    }
    public void ReadFile(String className) throws FileNotFoundException, IOException{
        String pathInput = "../Data/"+ className +".txt";
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
    public void WriteFile(String pathInput, String className) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        String pathOutput = "../Data/"+ className +".txt";
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
    
    public void WriteFileFromKey(String className) throws IOException{
        BufferedReader dataInput = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter bw = null;
        String pathOutput = "../Data/"+ className +".txt";
        try {
            FileWriter fw = new FileWriter(pathOutput,true);
            bw = new BufferedWriter(fw);
            FileReader frOutput = new FileReader(pathOutput);
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
