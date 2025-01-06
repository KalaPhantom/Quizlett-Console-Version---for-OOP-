package com.final_project_oop;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.final_project_oop.quiz.QuizMainFunction;
import com.final_project_oop.quiz.Quiz_Console_Base;
import com.final_project_oop.quiz.Template_quiz;
import com.final_project_oop.quiz.quiz_collection;

import json_methods.JSON_methods;


// Main activity

// Title 
public class Main  {


    public static void main(String[] args) {

        ClearConsole();
        JSON_methods.LoadFromJson();

        // Initialize questions
        Template_quiz.HistoryMultipleChoice();
        Template_quiz.Identification();
        

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
                QuizMainFunction.PlaySelectedQuiz();  // TODO - this is temporary
                    break; 
                
                case 2: 
                QuizMainFunction.DisplayScoresAndStats();
                    break;
                
                case 3:
                QuizMainFunction.CreateModifyQuiz();
                    break;
                
                case 4: 
                    isUserInteracting = false; // break the loop 
                    break;
            
                default:
                    break;
            }
            
        }

        JSON_methods.StoreToJson();
    }
    
    // TODO NOTE: ADDITIONAL METHODS

    /// Initialize all component in the start up
    /// It manages the common controls 
    public static int InitializeNavigator(){

        // Clear console
        ClearConsole(); 
        

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
                Quiz_Console_Base.DisplayTitle();
               

                UpdateCue(currentSelected);

                if(isWritingRepeat == false ){
                    // User input
                    
                    System.out.print(Quiz_Console_Base.ORANGE+"\n Input the corresponding number choices [from 1 - 4] >> \n" + Quiz_Console_Base.RESET);
                    input = Integer.parseInt(scn.nextLine());
                }
                
                System.out.println(); // space

                // validate user input
                if(input >= 5 || input <= 0){
                    throw new InputMismatchException("Wrong input format");
                }
                else{

                    
                    ClearConsole(); // clear
                    Quiz_Console_Base.DisplayTitle();

                    // TODO  Update functionalities here - - - - - - - - - - - - - - - - - - 
                    currentSelected = input; // Update 

                    UpdateCue(currentSelected);
                    System.out.println(Quiz_Console_Base.BG_BLUE);
                    System.out.println("\n >>   Press \"Y\" or \"y\" to continue to the selection - or input another range - -    << ");;
                    System.out.print(Quiz_Console_Base.RESET + "\n\n");

                    // read additional 
                    String newInput = scn.next().toString().trim();

                    // validate new input
                    if(newInput.equalsIgnoreCase("y")) {

                        isNavigatorRunning  = false; 
                    }
                    else{

                        int tempInt = Integer.parseInt(newInput);
                        if(tempInt <= 4 && tempInt >= 0){
                            isNavigatorRunning = true; input = tempInt; tempInt = currentSelected;  isWritingRepeat = true; }
                        else {throw new InputMismatchException(Quiz_Console_Base.RED +"Wrong input format" + Quiz_Console_Base.RESET); } // throw new exception
                    }

                }

            }
            catch (Exception e) {

                Scanner SCN2 = new Scanner(System.in);
                    
                // * Input mismatch -- 
                System.out.println(Quiz_Console_Base.RED+" - -  !! Input Mismatch !! - -  < Input must be on the range of 1 - 4 , and must never contain letters > - - - -      ");
                System.out.println( "      << Press Enter to Continue >>" + Quiz_Console_Base.RESET); 
                SCN2.nextLine();
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

            currentSelected == 3? "      \u001b[93m>> Create or Delete Quiz << \u001b[0m " : "     [3] Create or Delete Quiz" 
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
           System.out.println(Quiz_Console_Base.ORANGE);
           System.out.println("""
            
            Group 6 ----- . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ...
            
                ██████ ██    ████████████████████     ███████████████████████ 
                ██    ████    ████   ███    ███ ██     ██        ██      ██    
                ██    ████    ████  ███    ███  ██     █████     ██      ██    
                ██ ▄▄ ████    ████ ███    ███   ██     ██        ██      ██    
                 ██████  ██████ ██████████████████████████████   ██      ██    
                    ▀▀                                                         
                                                               

            \u001b[0m
                    """);
            
                    System.out.println("\u001B[38;2;235;183;52m. . . .  Press the Enter key to continue . . . .  ");
                    scn.nextLine();
        
        //scn.close(); // Close the instance for the garbage collection
    }
}


