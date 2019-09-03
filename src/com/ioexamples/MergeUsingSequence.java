package com.ioexamples;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class MergeUsingSequence {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
           System.out.println("Give first file path");
           String file1path = sc.nextLine();
           File file1 = new File(file1path);
           if(!file1.exists()){
               System.out.println("File does not exist");
               System.exit(0);
           }
           System.out.println("Give Second file path");
           String file2path = sc.nextLine();
           File file2 = new File(file2path);
           if(!file2.exists()){
               System.out.println("File does not exist");
               System.exit(0);
           }
           InputStream fis1 = new FileInputStream(file1path);
           InputStream fis2 = new FileInputStream(file2path);
 
        try (InputStream sis = new SequenceInputStream(fis1, fis2)) {
            int ch;
            System.out.println("Destination file path");
            String newfilepath = sc.nextLine();
            File newfile = new File(newfilepath);
            
            FileOutputStream fos = new FileOutputStream(newfile);
            while ((ch = sis.read()) != -1) {
                fos.write((char) ch);
            }
        }
    }
}