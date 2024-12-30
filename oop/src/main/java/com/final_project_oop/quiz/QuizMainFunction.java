package com.final_project_oop.quiz;

import java.io.Console;
import java.security.DrbgParameters.Reseed;
import java.util.Scanner;

/// Read and Display files files
/// Select files
/// Execute Files
/// At end - Store some scores
/// 

public class QuizMainFunction extends Quiz_Console_Base {

    /// ------------------------------------------------------
    /// play the selected quiz base on an index
    /// 
    /// ------------------------------------------------------
    
    public static void PlaySelectedQuiz(){

        // calls the Display Selection interface method 
        int indexOfSelectedQuiz = DisplayAndSelectQuestion(); // return int

        if(indexOfSelectedQuiz < 0){
            // Do nothing
            // Return
        }
        else{
            // retreives the data from the quiz collection
            quiz_collection.quizCollection.get(indexOfSelectedQuiz).PlayQuiz();;
        }
        


    }



    /// <Summary>
    /// returns the selected index of a quiz base on the selected item in the console interfaces
    public static int DisplayAndSelectQuestion(){

        // Create the instance of the scanner
        Scanner scn =  new Scanner(System.in);

        ClearConsole(); 

        // Create an itterator loop that will display the quizzes stored in an array list
        boolean isUserInputCorrect = false;
        int currentSelected = 1;
        int currentRange_byIndex = quiz_collection.quizCollection.size() -1 ;

        while(isUserInputCorrect == false){

            // Local varaibles on the loop bloc
            String userInput = ""; // Must never contain a null value

            DisplaySelection(currentSelected); // display current selected

            System.out.println();// space 

            // Message
            System.out.println("Type the number under the \"[number]\" block to select and play the quiz \n     --- And hit the enter key on your keyboard -------");
    
            // System input validator
            try{

                // template input
                int templateInput;

                // temporary storage for string
                String templateInput_onStirng; 
                
                System.out.print(" >>  ");
                userInput = scn.next().trim(); // ? reader

                // will throw an exception
                // if it do so repeat the loop
                currentSelected = Integer.parseInt(userInput);
              
                System.out.println(); // Space 

                // clear console
                ClearConsole();

                // Display the collection
                DisplaySelection(currentSelected);
                System.out.println(BRIGHT_YELLOW);
                System.out.println("- - - -  Type y\\Y to confirm selection and play the quiz \n- - - -   Type n\\N to exit \n- - - -   or type another range from the collection");
                System.out.println(RESET);;
                // Validate the input
                templateInput_onStirng = scn.next(); // ? -- Reader

                if(templateInput_onStirng.equalsIgnoreCase("y")){
                    isUserInputCorrect = true; // Break the loop by assigning a new value of type boolean as true;
                }
                else if(templateInput_onStirng.equalsIgnoreCase("n")){
                    currentSelected = 0;
                    break;
                }
                else{

                    templateInput = Integer.parseInt(templateInput_onStirng);

                    // validate the input
                    // The input must not be less than zero and greater than the size in index of the collection
                    if(templateInput > currentRange_byIndex || templateInput <= 0){                       
                        throw new Exception("Out of Range");
                    }
                    else{
                        currentSelected = templateInput;
                    }
                }
            }
            catch(Exception e){

                // Display wrong input messsage  - - - -
                System.out.println(" - - -  <!!>---- Wrong Input ---- <!!> - - - \n -- Please try again  - - - \n" + e.getMessage());
                
            }
        }

        return currentSelected -1 ;
    }
    
   

    public static void DisplaySelection(int currentSelected){

        ClearConsole();

        // Trailing display for title
        // TODO -- implement a decorator
        System.out.println("\n");
        System.out.println(BG_YELLOW +"============================== Quiz List ==========================================" + RESET);
        System.out.println("\n\n");

        // Loop to display questions 
        int count = 1;
        for(QuizActivity quiz : quiz_collection.quizCollection){
            System.out.println(

              currentSelected == count? BRIGHT_YELLOW + ">> [" + count + "]" + quiz.getQuizName() + ">>  " + quiz.getQuizSubjeString() + " <<" + RESET:
                                         "[" + count + "]" + quiz.getQuizName() + ">>  " + quiz.getQuizSubjeString() 
            );
            count++;
        }
        System.out.println(); // Division
    }

    // Display all scores and the overall average of scores in all quizes
    public static void DisplayScoresAndStats(){


        // method local properties


    }
}