package com.ioexamples;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Chirag
 */
public class RenameFile {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name which you want to rename along with path :- ");
        String oldnamewithpath = sc.nextLine();
        String filepath = oldnamewithpath.substring(0,oldnamewithpath.lastIndexOf('\\'))+"\\";
        String oldname = oldnamewithpath.substring(oldnamewithpath.lastIndexOf("\\")+1, oldnamewithpath.length());
        System.out.println("Enter name ");
        String newname = sc.nextLine();
        
        File file = new File(oldnamewithpath);
        File newfile = new File(filepath+newname);
        if(file.exists()){
            if(file.isFile()){
                if(!newfile.exists()){
                    if(file.length()<500){
                        file.renameTo(newfile);
                        System.out.println("Name of file "+oldname+" changed to "+newname);
                    }
                    else{
                        System.out.println("Large files cannot be renamed");
                    }
                }
                else{
                    System.out.println("File with this name already exists");
                }
            }
            else{
                System.out.println("File you want to rename is not file maybe its a directory/n"+"Check again....");
            }
        }
        else{
            System.out.println("File you want to rename does not exist");
        }
        
    }
}
