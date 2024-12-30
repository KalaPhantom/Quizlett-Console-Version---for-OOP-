package com.final_project_oop.quiz;

import java.util.Scanner;

/// Read and Display files files
/// Select files
/// Execute Files
/// At end - Store some scores
/// 

public class QuizMainFunction {


    // should have a return value
    public static void DisplayAndSelectQuestion(){

        // Create the instance of the scanner
        Scanner scn =  new Scanner(System.in);

        ClearConsole(); 
     

        // TODO -- implement a decorator
        System.out.println("\n============================== Quiz List ==========================================\n\n");

        // Create an itterator loop that will display the quizzes stored in an array list
        boolean isUserInputCorrect = false;
        int currentSelected = 1;
        int currentRange_byIndex = quiz_collection.quizCollection.size() -1 ;

        while(isUserInputCorrect == false){

            // Local varaibles on the loop bloc
            String userInput = ""; // Must never contain a null value



        
            // Loop to display questions 
            int count = 1;
            for(QuizActivity quiz : quiz_collection.quizCollection){
                System.out.println(

                  currentSelected == count?  ">> [" + count + "]" + quiz.getQuizName() + ">>  " + quiz.getQuizSubjeString() + " <<" :
                                             "[" + count + "]" + quiz.getQuizName() + ">>  " + quiz.getQuizSubjeString() 
                );
                count++;
            }

            System.out.println();// space 

            // Message
            System.out.println("Type the number under the \"[number]\" block to select and play the quiz \n     --- And hit the enter key on your keyboard -------");
    
            // System input validator
            try{

                // template input

                int templateInput;
                String templateInput_onStirng; 
                
                System.out.print(" >>  ");
                userInput = scn.next().trim(); // ? reader

                // will throw an exception
                // if it do so repeat the loop
                currentSelected = Integer.parseInt(userInput);
              
                System.out.println(); // Space 

                ClearConsole();
                System.out.println("- - - -  Type y\\Y to confirm selection or type another range from the collectiom");

                // Validate the input
                templateInput_onStirng = scn.next(); // ? -- Reader


                if(templateInput_onStirng.equalsIgnoreCase("y")){
                    isUserInputCorrect = true; // Break the loop by assigning a new value of type boolean as true;
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

                // Repeat the loop
                System.out.println(" - - -  <!!>---- Wrong Input ---- <!!> - - - \n -- Please try again  - - - \n" + e.getMessage());
                

            }
        }
    }
    
    
    public static void ClearConsole(){
        // Clear the console
        System.out.print("\u001b[H\u001b[2J");  
        System.out.flush(); // Clear the console
         
    }
}
