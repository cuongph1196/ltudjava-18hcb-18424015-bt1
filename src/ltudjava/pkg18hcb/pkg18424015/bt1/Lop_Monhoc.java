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
public class Lop_Monhoc {
    int STT;
    String MSSV;
    String HoTen;
    boolean GioiTinh;
    String CMND;
    
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
}
