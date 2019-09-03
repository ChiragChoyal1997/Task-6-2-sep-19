package com.ioexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class DeserializeEmployee {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Provide full path of employee object file");
        Scanner sc = new Scanner(System.in);
        String filepath = sc.nextLine();
        
        File file= new File(filepath);
        if(!file.exists()){
            System.out.println("File does not exists");
            System.exit(0);
        }
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream oi = new ObjectInputStream(fis);
        List<Employee> list = (ArrayList<Employee>)oi.readObject();
        
        for(Employee e:list){
            System.out.println(e);
        }
        
//        //int x = oi.available();
//        while (x = >0) {            
//            try {
//                e = (Employee)oi.readObject();
//                System.out.println(e.eno);
//            } catch (ClassNotFoundException ex) {
//                System.out.println("Employee class not found");
//            }
//                
//        }
    }
}
