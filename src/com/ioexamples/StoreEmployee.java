package com.ioexamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class StoreEmployee {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Employee e1 = new Employee(1, "Chirag Choyal", 25000, "Development", "DEvelopment");
        Employee e2 = new Employee(1, "Anand Lachheta", 20000, "Field Eng.", "Mechanical");
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Full Path of file to save objects");
        String filePath = sc.nextLine();
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
            
        }
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream os = new ObjectOutputStream(fos);
            List<Employee> list = new ArrayList<>();
            list.add(e1);
            list.add(e2);
            os.writeObject(list);
            os.close();
        }
    }
}
