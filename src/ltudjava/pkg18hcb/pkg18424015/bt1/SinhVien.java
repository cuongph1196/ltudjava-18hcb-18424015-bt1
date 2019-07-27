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
    public void ReadFile(String path) throws FileNotFoundException, IOException{
        BufferedReader br = null;
        try{
        FileReader fr = new FileReader(path);
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
    public void WriteFile(String pathInput, String pathOutput) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            FileWriter fw = new FileWriter(pathOutput,true);
            bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(pathInput);
            br = new BufferedReader(fr);
            FileReader frOutput = new FileReader(pathOutput);
            BufferedReader brOutput = new BufferedReader(frOutput);
            int i;
            int a ;
            if((a = brOutput.read()) != -1){
                br.readLine();
            }
            while ((i = br.read()) != -1) {
    //            System.out.print((char) i);
                bw.write((char) i);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            br.close();
            bw.close();
            System.out.println("Success...");
        }

    }
    
    public void WriteFileFromKey() throws IOException{
        BufferedReader dataInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("../Data/Output.txt",true);
            bw = new BufferedWriter(fw);
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../Data/Output.txt"), StandardCharsets.UTF_8));
            System.out.println("Hãy nhập thông tin sinh viên:");
            String value = dataInput.readLine();
            System.out.println(value);
            bw.write(value);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            bw.close();
            System.out.println("Success...");
        }

    }
    
    public void Temp() throws IOException{
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        BufferedReader br = null;
        try
        {
            bin = new BufferedInputStream( new FileInputStream("../Data/Person.csv"));
            br = new BufferedReader(new FileReader("../Data/Person.csv"));
            bout = new BufferedOutputStream( new FileOutputStream("../Data/Output.txt",true));
            String str ;
            while (true) {
                    int datum = bin.read();
                    if (datum == -1)
                            break;
                    bout.write(datum);
                    
                    str = br.readLine();
			if (str==null)
				break;
			System.out.println(str);
            }
            bout.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            br.close();
            bin.close();
            bout.close();
        }
    }
}
