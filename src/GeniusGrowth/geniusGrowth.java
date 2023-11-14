/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeniusGrowth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Afnan
 */
public class geniusGrowth {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile=new PrintWriter("Ideas");
        System.out.println("Enter your name: ");
        String Ownername = in.nextLine();
        
        System.out.println("Enter the idea name: ");
        String ideaName = in.nextLine();
        
        System.out.println("Enter the description of idea: ");

        String description = in.nextLine();

        CreateFile file = new CreateFile(ideaName, description, Ownername);
        
        PrintInFile.write("Idea: "+ideaName+"\n"+"description: "+description+"\nOwnername: "+Ownername+"\n State: "+file.getState()
        +"\n Favorite: "+file.getFavoriteState()+"");
        
        
        PrintInFile.close();
        PrintInFile.flush();
    }
}
