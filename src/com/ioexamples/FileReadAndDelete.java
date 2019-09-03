package com.ioexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class FileReadAndDelete {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give file path");
        String filepath = sc.nextLine();
        File file = new File(filepath);
        if(file.exists()){
            try (FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(fr)) {
                String s;
                while ((s = br.readLine())!= null) {
                    System.out.println(s);
                }
            }
            file.delete();
        }else{
            System.out.println("File does not exist");
        }
    }
}
