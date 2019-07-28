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
public class ThoiKhoaBieu {
    int STT;
    String MaMon;
    String TenMon;
    String PhongHoc;
    String Lop;
    
    public void WriteFile(String pathInput, String className) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        String pathOutput = "../Data/TKB_"+ className +".txt";
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
                    String[] in=i.split(",");
                    String[] out=a.split(",");
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