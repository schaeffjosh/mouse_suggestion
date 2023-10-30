package org.example;

import org.example.model.*;
import org.example.dao.*;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        //get mouse name
//        Scanner userInput = new Scanner(System.in);
//        System.out.println("What is the name of the mouse you want to find?");
//        String mouseName = userInput.nextLine();

//        System.out.println("Do you want a symmetrical mouse or an ergonomic mouse (Y/N)?");
//        String shape = userInput.nextLine();
//        boolean isSym = true;
//        if(shape.equalsIgnoreCase("f")){
//            isSym = false;
//        }

//        Questions newQuery = new Questions();
//        List<String> answers = newQuery.getAnswers();
//        for (String answer : answers){
//            System.out.println(answer);
//        }
//        List<Mouse> miceList = makeMouseList(mouseName, isSym);
//
//        //import mouse as Mouse object
//        for(Mouse mouse : miceList) {
//            System.out.println("\n" +mouse.toString() + "\n");
//        }
        makeMouseList();

    }

    public static List<Mouse> makeMouseList() {

        File mice = new File("C:\\Users\\Student\\workspace\\mouse_suggestion\\untitled\\src\\main\\resources\\Mouse Specs Doc - Sheet1.csv");
        if (!mice.exists()) {
            System.out.println("File not found");
            System.exit(1);
        } else if (!mice.isFile()) {
            System.out.println("File not found");
            System.exit(1);
        }

        String[] mouseArr;
        List<Mouse> miceList = new ArrayList<Mouse>();
        File newfile = new File("C:\\Users\\Student\\workspace\\mouse_suggestion\\untitled\\src\\main\\resources\\mouse-query");
        //open file
        try (Scanner mouseFile = new Scanner(mice); PrintWriter writer = new PrintWriter(new FileOutputStream(newfile, true))) {
            while (mouseFile.hasNextLine()) {
                String line = mouseFile.nextLine();
                //find mouse with name given
                mouseArr = line.split(",");
//                if(mouseArr[1].equalsIgnoreCase(mouseName)) {
                    Mouse mouseFound = new Mouse(mouseArr[0], mouseArr[1], Double.parseDouble(mouseArr[2]), Double.parseDouble(mouseArr[3]),
                            Double.parseDouble(mouseArr[4]), Integer.parseInt(mouseArr[5]), mouseArr[6], mouseArr[7],
                            mouseArr[8], Integer.parseInt(mouseArr[9]), Integer.parseInt(mouseArr[10]));
                    //add mouse to list
                    miceList.add(mouseFound);
                    writer.write("\n" + mouseFound.toString());
                }
//            }


        } catch(IOException ex){
            System.out.println("File not found");
        }
        return miceList;
    }
}