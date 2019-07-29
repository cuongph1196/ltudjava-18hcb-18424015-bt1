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
}