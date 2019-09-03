package com.ioexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class Maingame {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter X position");
        int x = sc.nextInt();
        System.out.println("Enter Y position");
        int y = sc.nextInt();
        System.out.println("Enter Z position");
        int z = sc.nextInt();
        ThreeDGame commandoposition = new ThreeDGame(x, y, z);

        File file = new File("G:\\gamepos.txt");
        if(file.exists()){
            if(file.length()>0){
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ThreeDGame positioncontinue = (ThreeDGame)ois.readObject();
                System.out.println(positioncontinue);
            }
            else{
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(commandoposition);
                System.out.println("Position saved");
            }
        }
        else{
            System.out.println("Unable to save  ");
        }
    }
}
