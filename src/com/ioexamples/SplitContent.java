package com.ioexamples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class SplitContent {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Provide the full path of file which is to be splitted");
        String filepath = sc.nextLine();
        System.out.println("No. of parts");
        int parts = sc.nextInt();
        File file = new File(filepath);
        String exactpath = filepath.substring(0, filepath.lastIndexOf("\\"));
        String filename = filepath.substring(filepath.lastIndexOf("\\"),filepath.lastIndexOf("."));
        String fileextension = filepath.substring(filepath.lastIndexOf("."),filepath.length());
        if(!file.exists()){
            System.out.println("File does not exists"); 
       }
        else{
            if(!file.isFile()){
                System.out.println("It is not a file");
            }
            else{
                long noofbytes = file.length()/parts;
                int remainingbytes = (int) (file.length()%parts);
                FileInputStream fis = new FileInputStream(file);
                String folderpath = exactpath+"\\"+"Folder";
                File folder = new File(folderpath);
                folder.mkdir();       
                List<File> files = new ArrayList<>();
                FileOutputStream fos;
                boolean firstfile = true;
                int count = 1;
                for(int i=1;i<=parts;i++){
                    File newfile = new File(folderpath+"\\"+filename+i+fileextension);
                    fos = new FileOutputStream(newfile);
                    files.add(newfile);
                    byte[] b = new byte[(int)noofbytes];    
                    fis.read(b);
                    if(count != parts){    
                        fos.write(b, 0, (int) noofbytes);
                        fos.flush();
                        count++;
                    }
                    else{    
                        fos.write(b,0, (int) noofbytes + remainingbytes);
                        fos.flush();
                    }
                    }
                }
            }
            
        }
    }

