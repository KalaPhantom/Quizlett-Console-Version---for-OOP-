package com.final_project_oop;


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;


// Import the local library of the SQL database
// import java.sql.*;
// import java.text.NumberFormat.Style;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.final_project_oop.quiz.QuizMainFunction;
import com.final_project_oop.quiz.Template_quiz;
import com.final_project_oop.quiz.quiz_collection;


// Main activity

// Title 
public class Main {


    public static void main(String[] args) {

        ClearConsole();

        // Scanner Instance 
        Scanner scn = new Scanner(System.in);

        // Invoke the tile here 
        DisplayTitle(); 

        boolean isUserInteracting = true; // Updates when the user chooses exit
     

        // TODO: Implement this RGB color scapes
        //System.out.println("\u001B[38;2;235;183;52m 235, 183, 52"); // this thing works HAHAHAH
    
        // TODO: For test purposes . . . . .
        // Initialize
        // Template_quiz.HistoryMultipleChoice();
        // Template_quiz.Identification();
        // System.out.println(quiz_collection.quizCollection.get(1).getQuizID() + "   >>QUIZ ID - - - - - ");
        // quiz_collection.quizCollection.get(1).PlayQuiz();


        /// Main activity interaction 
        /// This will keeps the application running until the user select the exit in the selection
        while (isUserInteracting) {

            int sample = InitializeNavigator();
            
            switch (sample) {
                // Call methods here
                case 1:
                QuizMainFunction.DisplayAndSelectQuestion();
                    break; 
                
                case 2: 
                    break;
                
                case 3:
                    break;
                
                case 4: 
                    isUserInteracting = false; // break the loop 
                    break;
            
                default:
                    break;
            }
            
        }

      




    }
    
    // TODO NOTE: ADDITIONAL METHODS

    /// Initialize all component in the start up
    /// It manages the common controls 
    public static int InitializeNavigator(){

        ClearConsole(); 


    
        // Initialize questions
        Template_quiz.HistoryMultipleChoice();
        Template_quiz.Identification();
        
        // -- Local method variables
        int currentSelected = 1; 
        boolean isNavigatorRunning = true;
        int input = 1;
        boolean isWritingRepeat = false; 

        //* Scanner class *// -------
        Scanner scn = new Scanner(System.in); 

        while (isNavigatorRunning != false) {
            try {

                System.out.print("\u001b[H\u001b[2J");  
                System.out.flush(); // Clear the console


                ClearConsole();// Clear

                UpdateCue(currentSelected);

                if(isWritingRepeat == false ){
                    // User input
                    System.out.print("\n Input the corresponding number choices [from 1 - 4] >> \n");
                    input = Integer.parseInt(scn.nextLine());
                }
                
                System.out.println(); // space

                // validate user input
                if(input > 4 || input <= 0){
                    throw new InputMismatchException("Wrong input format");
                }
                else{

                    ClearConsole(); // clear
                    // TODO  Update functionalities here - - - - - - - - - - - - - - - - - - 
                    currentSelected = input; // Update 

                    UpdateCue(currentSelected);
                    System.out.println("\n >>   Press \"Y\" or \"y\" to continue to the selection - or input another range - -    << \n ");;
              

                    // read additional 
                    String newInput = scn.next().toString().trim();

                    // validate new input
                    if(newInput.equalsIgnoreCase("y")) {

                        isNavigatorRunning  = false; 
                    }
                    else{

                        int tempInt = Integer.parseInt(newInput);
                        if(tempInt < 4 && tempInt > 0){
                            isNavigatorRunning = true; input = tempInt;  isWritingRepeat = true; }
                        else {throw new InputMismatchException("Wrong input format"); } // throw new exception
                    }

                }

            }
            catch (Exception e) {

                Scanner SCN2 = new Scanner(System.in);
                    
                // * Input mismatch
                System.out.println(" - -  !! Input Mismatch !! - -  < Input must be on the range of 1 - 4 , and must never contain letters > - - - - \n       << Press Enter to Continue >> "); 
                SCN2.nextLine();

                // reset input 
                currentSelected = 1; 
                input = 1;
                InitializeNavigator();
                break;

            }

        }

        // return value
        return currentSelected;
    }

    // * - - -  Updates the state of string from the navigation method
    public static void UpdateCue(int currentSelected){  

        System.out.println("\n \u001b[3m\u001B[38;2;235;183;52m =============================QUIZLETT================================\u001b[0m\n");

          // Update UI Queues
          System.out.println(
            currentSelected == 1? "     \u001b[93m>> Answer Quizzes <<\u001b[0m " : "     [1] Answer Quizzes" 
        );

    
        System.out.println(
            currentSelected == 2? "      \u001b[93m>> Scores <<\u001b[0m " : "     [2] Scores" 
        );

    
        System.out.println(

            currentSelected == 3? "      \u001b[93m>> Create Quiz << \u001b[0m " : "     [3] Create Quiz" 
        );

    
        System.out.println(
            currentSelected == 4? "      \u001b[93m>> Exit << \u001b[0m " : "     [4] Exit" 
        );
        
    }

    public static  void ClearConsole(){
          // Clear the console
          System.out.print("\u001b[H\u001b[2J");  
          System.out.flush(); // Clear the console
    }

    public static void DisplayTitle(){

        Scanner scn = new Scanner(System.in);
           // Display the title splash screen . . . . . . . . 
           System.out.println("""
            \u001b[47m\u001b[33m 
            Group 6 ----- . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ...
            ..#######..##.....##.####.########.########.##.......########.########.########
            .##.....##.##.....##..##.......##.......##..##.......##..........##.......##...
            .##.....##.##.....##..##......##.......##...##.......##..........##.......##...
            .##.....##.##.....##..##.....##.......##....##.......######......##.......##...
            .##..##.##.##.....##..##....##.......##.....##.......##..........##.......##...
            .##....##..##.....##..##...##.......##......##.......##..........##.......##...
            ..#####.##..#######..####.########.########.########.########....##.......##...
            \u001b[0m
                    """);
            
                    System.out.println("\u001B[38;2;235;183;52m. . . .  Press the Enter key to continue . . . .  ");
                    scn.nextLine();
        
        //scn.close(); // Close the instance for the garbage collection
    }
}