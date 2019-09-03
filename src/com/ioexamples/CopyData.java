package com.ioexamples;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Chirag
 */
public class CopyData {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full path :- ");
        String filepath = sc.nextLine();
        
        
        File oldfile = new File(filepath);
        if(!oldfile.exists()){
            System.out.println("File does not exist");
        }  
        else{
        System.out.println("Where to copy? (Enter full path)");
        String newfilepath = sc.nextLine();
        File newfile = new File(newfilepath);
        FileReader fr = null;
        try {
            fr = new FileReader(oldfile);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        FileWriter fw = null;
        try (BufferedReader br = new BufferedReader(fr)) {
            fw = new FileWriter(newfile,true);
            String s;
            while((s=br.readLine())!= null){
                fw.write(s);
                fw.flush();
            }
        } catch (IOException ex) {
            
        }
        fw.close();
        fr.close();
        System.out.println("File Copied !");
    }
    }
}
