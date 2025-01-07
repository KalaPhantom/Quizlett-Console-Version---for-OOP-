package com.final_project_oop.quiz;

import java.io.Console;
import java.security.DrbgParameters.Reseed;
import java.sql.Blob;
import java.util.ArrayList;
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
    
    public static void PlaySelectedQuiz(){ // ! ---

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
    
   

    public static void DisplaySelection(int currentSelected){ // ! ---

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

              currentSelected == count? BRIGHT_YELLOW + ">> [" + count + "]" + quiz.getQuizName() + ">>  " + quiz.getQuizSubject() + " <<" + RESET:
                                         "[" + count + "]" + quiz.getQuizName() + ">>  " + quiz.getQuizSubject() 
            );
            count++;
        }
        System.out.println(); // Division
    }

    // Display all scores and the overall average of scores in all quizes
    public static void DisplayScoresAndStats(){ // ! ---

        ClearConsole();

        System.out.println(BG_BLUE + "=================================== SCORES ===================================="  + RESET);
        System.out.println("\n");

        ArrayList<Integer> scoreCollection = new ArrayList<>();
        ArrayList<Integer> AverageCollection = new ArrayList<>();

        for(QuizActivity a : quiz_collection.quizCollection){

            int total_score = a.getScores();
            int AVG = 0;
            
            AVG = total_score/a.question_collection.size() * 100;

            // Pass data
            scoreCollection.add(total_score);
            AverageCollection.add(AVG);

            // Display data here

            System.out.println(ORANGE + "---||" + BLUE+ " Name "+ RESET + a.getQuizName() + ORANGE+ " ||-------||" + BLUE +" Subject:  " + RESET + a.getQuizSubject() + ORANGE + " ||-------|| "+BLUE+ " Score:   " + RESET+  total_score + ORANGE+ " ||-------|| " +BLUE+"Average:   " + RESET + AVG +"%" + RED + " ||---" + RESET );



        }

        System.out.println("\n\n");
        System.out.println(">>     Press the enter key to continue     <<");
        Scanner SCN = new Scanner(System.in);
        SCN.nextLine();

    }


    /// Summary: - - - - - - - - - 
    /// This method will provide functionalities on Creating objects of type of Quiz Activity -
    /// - an object to represent each instance of a quiz containing a collection
    /// 


    // Main panel for activity
    public static void CreateModifyQuiz(){ // ! --

        // Call the selection method from the base class 
        int selection = Selection(
            new String[] {"Create Quiz", "Delete Quiz"},
            "  Create or delete Quiz-- use the commands below to modify \n  Select choices base on their numbers",
            "Invalid Input",
            "Modify or Create Quiz"
        );

        if(selection == 1){
            CreateQuiz();
        }
        else if (selection == 2){
            DeleteQuiz();
        }
        else{
            // exit
        }
    }

    private static void CreateQuiz(){ // ! --

        boolean isAdding = true;

        String QuizName;
        String Subject;
        int ID;
        String type;

        // Selection\
        String[] selection = {"Multiple Choice", "Identification"};

        // Create the instance of selection panel
        int selected = Selection(selection, 
        "Type the number of your selected choice then hit the enter key", 
        "Invalid type input",
        "Create New Quiz");

        // switch statement as a separator
        switch (selected) {
            case 1: // for multiple Choice
            // Call create here
            Create_MultipleChoice();
                break;

            case 2: // for identification
            // Call create here
            Create_Identification();
                break;
        
            default:
                break;
        }
    }

    private static void Create_MultipleChoice(){ // !--

        // Create the instance 
        QuizActivity MC =  new QuizActivity();

        // Scanner
        Scanner SCN = new Scanner(System.in);

          // Repeat all attributes each itteration
          System.out.println(); // space
          System.out.println(BG_BLUE+ "============================== CREATE MULTIPLE CHOICE ========================================" + RESET); 
          System.out.println(); // space

          System.out.print(YELLOW + " Enter the name of the quiz:  " + RESET);

          // Reader for quiz name
          System.out.print(ORANGE);
          MC.setQuizName(SCN.next());
          System.out.println(RESET);

          SCN.nextLine(); // Takes the extra line
          


          System.out.print(YELLOW + " Enter the subject of the quiz:  " + RESET);

          // Reead the subject string
          System.out.print(ORANGE);
          MC.setQuizSubject(SCN.next());
          System.out.println(RESET);

          // Set the type
          MC.setType("MC");



        boolean isCreating = true;
        int questionCount = 1;

        ClearConsole();

        // Loop to continually create quizes of type 
        while(isCreating == true){

            ClearConsole();



             // Repeat all attributes each itteration
            System.out.println(); // space
            System.out.println(BG_BLUE+ "============================== CREATE MULTIPLE CHOICE ========================================" + RESET); 
            System.out.println(); // space

            System.out.println(

            ORANGE + 
                "      Name: " + MC.getQuizName() + "\n" +
                "      Subject: " + MC.getQuizSubject() + "\n" +
                "      Type: " + MC.getType() + "\n" +
                "      Number of Questions: " + MC.question_collection.size() + "\n" + RESET
            );

            // Create instance
            MultipleChoice MC_Q = new MultipleChoice();

            MC_Q.set_question_number(questionCount);

            System.out.println(YELLOW + "==============================Question " + questionCount+"========================================" + RESET);
            System.out.println(); // space


            // reads the question from the user input
            System.out.println(BLUE + "- - Enter your Question - - ");
            System.out.print(ORANGE +">> " + YELLOW);
            MC_Q.setQuestion(SCN.next());
            SCN.nextLine();
            System.out.print(RESET);

            SCN.nextLine();// take all trailing space

            // reads the correct answer
            System.out.println(BLUE + "- - Enter the Correct Answer - - ");
            System.out.print(ORANGE +">> " + YELLOW);
            MC_Q.setCorrectAnswer(SCN.next());   
            System.out.println(RESET);


            // reads the correct answer
            System.out.println(BLUE + "- - Enter the Choices (On range of 1 to 4) - - ");
            System.out.print(ORANGE +">> \n " + YELLOW);

            // Template Array
            String[] choicesTemplate = new String[4];
            String[] letter = {"A","B", "C", "D"};

            for(int i = 0; i < 4 ; i++){
                System.out.print(BLUE+"    > Option " +letter[i] +":"+ YELLOW);
                choicesTemplate[i]= SCN.next();
                SCN.nextLine();
            }

            // Pass the array to the object
            MC_Q.setAnswerCollection(choicesTemplate);

            System.out.println(RESET);

            // Add the new question to the base model
            MC.question_collection.add(MC_Q);


            // Validate loop continuity
            System.out.println(ORANGE+">> Do you want to add new Question Y/n" + YELLOW);;
            String inputValidation = SCN.next();

            if(inputValidation.equalsIgnoreCase("y")){

                System.out.println(RESET);

            }
            else{

                System.out.print(YELLOW+"\n <> New Quiz has been added.. Press Enter to Continue . .  <>" + RESET);
                SCN.nextLine();
                SCN.nextLine();
            
                isCreating = false;
                quiz_collection.quizCollection.add(MC);

                // Add the new quiz
                System.out.println(RESET);
            }

        }
    }

    private static void Create_Identification(){ // !--

        // Initialize an interface here
        // Create the instance 
        QuizActivity ID =  new QuizActivity();

        // Scanner
        Scanner SCN = new Scanner(System.in);

        // Repeat all attributes each itteration
        System.out.println(); // space
        System.out.println(BG_BLUE+ "============================== CREATE IDENTIFICATION QUIZ ========================================" + RESET); 
        System.out.println(); // space

        System.out.print(YELLOW + " Enter the name of the quiz:  " + RESET);

        // Reader for quiz name
        System.out.print(ORANGE);
        ID.setQuizName(SCN.next());
        System.out.println(RESET);

        SCN.nextLine(); // Takes the extra line
   


        System.out.print(YELLOW + " Enter the subject of the quiz:  " + RESET);

        // Reead the subject string
        System.out.print(ORANGE);
         ID.setQuizSubject(SCN.next());
        System.out.println(RESET);

        // Set the type
        ID.setType("ID");



        boolean isCreating = true;
        int questionCount = 1;

        ClearConsole();

        // Loop to continually create quizes of type 
         while(isCreating == true){

            ClearConsole();



            // Repeat all attributes each itteration
            System.out.println(); // space
            System.out.println(BG_BLUE+ "============================== CREATE MULTIPLE CHOICE ========================================" + RESET); 
             System.out.println(); // space

            System.out.println(

                ORANGE + 
                 "      Name: " + ID.getQuizName() + "\n" +
                "      Subject: " + ID.getQuizSubject() + "\n" +
                "      Type: " + ID.getType() + "\n" +
                 "      Number of Questions: " + ID.question_collection.size() + "\n" + RESET
            );

             // Create instance
            Identification ID_Q = new Identification() ;

            ID_Q.set_question_number(questionCount);

            System.out.println(YELLOW + "============================== Question " + questionCount+" ========================================" + RESET);
            System.out.println(); // space


            // reads the question from the user input
            System.out.println(BLUE + "- - Enter your Question - - ");
            System.out.print(ORANGE +">> " + YELLOW);
            ID_Q.setQuestion(SCN.next().trim());
            System.out.print(RESET);

            SCN.nextLine();// take all trailing space

            // reads the correct answer
             System.out.println(BLUE + "- - Enter the Correct Answer - - ");
            System.out.print(ORANGE +">> " + YELLOW);
            ID_Q.setCorrectAnswer(SCN.next());   
            System.out.println(RESET);


          
        
            System.out.println(RESET);

            // Add the new question to the base model
            ID.question_collection.add(ID_Q);


            // Validate loop continuity
            System.out.println(ORANGE+">> Do you want to add new Question Y/n" + YELLOW);;
            String inputValidation = SCN.next();

             if(inputValidation.equalsIgnoreCase("y")){

                System.out.println(RESET);

             }
            else{

                System.out.print(YELLOW+"\n <> New Quiz has been added.. Press Enter to Continue . .  <>" + RESET);
                SCN.nextLine();
                SCN.nextLine();
     
                isCreating = false;
                quiz_collection.quizCollection.add(ID);

                // Add the new quiz
                 System.out.println(RESET);
            }

        }

    }


    private static void DeleteQuiz(){

        int selected = Selection(quiz_collection.quizCollection,
            "Sekect the choices by their numbers and hit the enter key",
            "Invalid Input",
            "Delete Quiz");

            if(selected == -1){

            }
            else{
                System.out.println( ORANGE + "   " + "The Quiz: " +
                quiz_collection.quizCollection.remove(selected -1).getQuizName()
                + " has been removed"
                );

            }
    }

    // Display Quiz Attributes

    private static void DisplayQuizAttributes(){


    }


}