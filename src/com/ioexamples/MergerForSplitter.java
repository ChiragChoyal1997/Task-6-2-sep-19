package com.ioexamples;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Chirag
 */
public class MergerForSplitter {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Provide full path of folder whose files you r going to merge");
        Scanner sc = new Scanner(System.in);
        String folderpath = sc.nextLine();
        
        File checkfiles = new File(folderpath);
        if(checkfiles.exists()){
            if(checkfiles.isDirectory()){
                if(checkfiles.list().length>0){
                    List<FileInputStream> listFiles = new ArrayList<>();
                    for (String list : checkfiles.list()) {
                        FileInputStream fis = new FileInputStream(checkfiles+"\\" + list);
                        listFiles.add(fis);
                    }
                    Enumeration e = Collections.enumeration(listFiles);
                    SequenceInputStream sis = new SequenceInputStream(e);
                    File newfile = new File(folderpath+"\\"+"new.txt");
                    newfile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(newfile);
                    int ch;
                    while ((ch = sis.read()) != -1) {
                        fos.write((char) ch);
                        fos.flush();
                    }
                }
                else{
                    System.out.println("Directory do not contain any file to merge");
                }
            }
            else{
                System.out.println("It is not a directory");
            }
                
        }
        else{
            System.out.println("Diretory does not exists");
        }
    }
}
