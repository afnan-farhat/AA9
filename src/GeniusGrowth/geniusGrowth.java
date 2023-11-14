/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeniusGrowth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Afnan
 */
public class geniusGrowth {

    private static ArrayList<CreateFile> fileIdeas = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");

        System.out.println("Enter the the number of idea file: ");
        int FileNo = in.nextInt();
        CreateFile file = null;
        for (int i = 0; i < FileNo; i++) {
            System.out.println("the file:" + (i + 1));
            System.out.println("\tEnter your name: ");
            String Ownername = in.next();

            System.out.println("\tEnter the idea name: ");
            String ideaName = in.next();

            System.out.println("\tEnter the description of idea: ");

            String description = in.next();

            file = new CreateFile(ideaName, description, Ownername);

            fileIdeas.add(file);
            //Print value

            PrintInFile.write(file.toString());
            System.out.println("+ " +  file.getFavoriteState());

            String FavIdea;
            System.out.println("Do you want to add idea to Favorite place (enter Y for yes or N for no) :");
            FavIdea = in.next();
           if (FavIdea.equalsIgnoreCase("Y")) {
               file.ChangeFavoriteIdea();
           }
            file = new CreateFile(ideaName, description, Ownername, file.getFavoriteState(), file.getState());
            PrintInFile.write(file.toString());
        }

        PrintInFile.close();
        PrintInFile.flush();
    }
}
