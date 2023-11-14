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
        String FavIdea, Accept;

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");

        System.out.println("Enter the the number of idea file: ");
        int FileNo = 1;
        
        

        String job;
        int value;

        System.out.println("the file:" + FileNo++);
        System.out.println("\tEnter your name: ");
        String Ownername = in.next();

        System.out.println("\tEnter the idea name: ");
        String ideaName = in.next();

        System.out.println("\tEnter the description of idea: ");

        String description = in.next();

        CreateFile file = new CreateFile(ideaName, description, Ownername);
        //} while(!(FavIdea.equalsIgnoreCase("y")&& Accept.equalsIgnoreCase("yes") ));
        do {

            showMenu();
            job = in.next();
            value = in.nextInt();
            if (null == job) {

            } else {
                switch (job) {
                    case "Owner": {

                     

                        fileIdeas.add(file);
                        fileIdeas.remove(file);

                        System.out.println(file.toString());
                        PrintInFile.write(file.toString());

                        break;

                    }
                    case "Investor": {
                        System.out.println("Do you want to add idea to Favorite place (enter Y for yes or N for no) :");
                        FavIdea = in.next();
                        if (FavIdea.equalsIgnoreCase("Y")) {
                            file.ChangeFavoriteIdea();
                        }
                        file = new CreateFile(FileNo + "." + ideaName, description, Ownername, file.getFavoriteState(), file.getState());

                        PrintInFile.write(file.toString());

                        break;
                    }
                    case "Staff": {
                        System.out.print("Dose the idea accepted?(if Yes enter Y)");
                        Accept = in.next();

                        if (Accept.equalsIgnoreCase("yes")) {
                            file.ChangeStateIdea();

                        }
                        file = new CreateFile(ideaName, description, Ownername, file.getFavoriteState(), file.getState());
                        PrintInFile.write(file.toString());
                        break;
                    }
                    default:
                        break;
                }
            }
        } while (!"".equals(job));

        PrintInFile.close();
        PrintInFile.flush();
    }

    public static void showMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------      JOBS     ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. owner                                    |");
        System.out.println("|   2. investor                                 |");
        System.out.println("|   3. staff                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your job: ");

    }

}
