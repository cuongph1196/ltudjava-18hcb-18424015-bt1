/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava.pkg18hcb.pkg18424015.bt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        String pathInput = "./database/lop/"+ className +".txt";
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
        String pathOutput = "./database/lop/"+ className +".txt";
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
    
    public void WriteFileFromKey(String className) throws IOException{
        BufferedReader dataInput = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter bw = null;
        String pathOutput = "./database/lop/"+ className +".txt";
        try {
            FileWriter fw = new FileWriter(pathOutput,true);
            bw = new BufferedWriter(fw);
            FileReader frOutput = new FileReader(pathOutput);
            BufferedReader brOutput = new BufferedReader(frOutput);
            String a;
            String title = brOutput.readLine();
            if(title != null && !"".equals(title)){
            }
            else{
                bw.write("STT,MSSV,Họ tên,Giới tính,CMND");
                bw.newLine();
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
