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
//        System.out.println("Hello World!");
//        Person a = new Person();
//        a.Name = "Phan huy cuong";
//        a.Age = 22;
//        a.Height = 173;
//        System.out.println(a.Name);

//          BufferedReader br = new BufferedReader(new FileReader("../Data/Person.csv"));
//          BufferedWriter bw = new BufferedWriter(new FileWriter("../Data/Output.txt"));
//		String str ;
//		while (true)
//		{
//			str = br.readLine();
//			if (str==null)
//				break;
//			//System.out.println(str);
//                        bw.write(str);
//		}
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try
        {
            bin = new BufferedInputStream( new FileInputStream("../Data/Person.csv"));
            bout = new BufferedOutputStream( new FileOutputStream("../Data/Output.txt",true));
            while (true) {
                    int datum = bin.read();
                    if (datum == -1)
                            break;
                    bout.write(datum);
            }
            bout.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            bin.close();
            bout.close();
        }

    }
    
}
