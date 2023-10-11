package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questions {
    Scanner userInput = new Scanner(System.in);
    public List<String> answers = new ArrayList<>();
    File questions = new File("C:\\Users\\Student\\workspace\\mouse_suggestion\\untitled\\src\\main\\resources\\questionnaire.csv");

    public List<String> getAnswers(){
        try(Scanner askQuestions = new Scanner(questions)){
            while(askQuestions.hasNextLine()){
                System.out.println(askQuestions.nextLine());
                String newAnswer = userInput.nextLine();
                answers.add(newAnswer);
            }
        } catch(IOException ex){
            System.out.println("File not found.");
        }
        return answers;
    }
}
