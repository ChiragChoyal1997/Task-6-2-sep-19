package com.ioexamples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class CityNames {
    public static void main(String[] args) throws FileNotFoundException, IOException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Give path of file where to save city names");
            String filepath = sc.nextLine();
            File file = new File(filepath);
            if(file.exists()){
                if(!file.isFile()){
                    System.out.println("The given path conains a folder not a file");
                }
                else{
                    FileOutputStream fos = new FileOutputStream(file,true);
                    byte[] s = null;
                    int i=1;
                    System.out.println("Enter city name");
                    while(i>0){
                        s = sc.nextLine().getBytes();
                        if(s.length>0){
                            fos.write(s);
                            fos.flush();
                        }else{
                            i=0;
                        }
                    }
                    fos.close();
                }
            }
            else{
                System.out.println("File does not exists");
            }
            
    }
}
