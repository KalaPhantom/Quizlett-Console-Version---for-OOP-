package com.final_project_oop.quiz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Queue;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

///   -----------  <Summary> ------------------------------------------------------------------------------------------
///
///   The interface below will serve as a framework class for all types of quizzes
///   This will serve as a framework for all questions 
///   
///   The purpose of this package is to provide an ability for the programmer to store temporary data -
///   Each Object will be instanced and will be stored to another object with a linear data structure -
///   - That object will serve as a base instance - and will be called as "Quiz"
/// 
///   Each base instance - we call it "quiz" - will be stored to another linear data structure (linklist) as the collection of all-
///   - quiz instance 
///   
/// 
///   -----------  <Summary> -------------------------------------------------------------------------------------------


// Base interface as the framework



@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, // Use type names to identify the concrete class
    include = JsonTypeInfo.As.PROPERTY, // Include type info as a property in the JSON
    property = "type" // The property name where type info will be stored (e.g., "type": "multiple_choice")
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MultipleChoice.class, name = "MultipleChoice"),
    @JsonSubTypes.Type(value = Identification.class, name = "Identification")
})
public interface Quiz_model{ // ! abstraction

    public void displayQuestion();
    public void displayChoices();
    public void ValidateAnswer();
    public void MainActivity(); 
    
    public boolean GetQuestionState();

}

/// Multiple Choice type
@JsonIgnoreProperties(ignoreUnknown = true)
class MultipleChoice implements Quiz_model{


    // Abstraction
    // Local class properties
    private String question;
    private String correctAnswer;
    private String[] answer_collection;
    private int question_number;
    private boolean isAnswerCorrect;
    private int Score; 

    // Scanner for user input
    transient Scanner userInput = new Scanner(System.in);

    // Local Properties without mutators and accessors
    private String userAnswer;
   
    // Boolean value to determine 

    // Accessor - - 
    public String getQuestion(){
        return question.trim();
    }

    public String getCorrectAnswer(){
        return correctAnswer.trim();
    }

    public String[] getAnswerCollection(){

        return answer_collection;
    }

    public int get_question_number(){
        return question_number;
    }

    public boolean get_isAnswerCorrect(){
        return isAnswerCorrect;
    }

    public int getScores(){
        return this.Score;
    }


    // Mutator - -
    public void setQuestion(String question){
        this.question = question.trim(); 
    }

    public void setCorrectAnswer(String answer){
        this.correctAnswer = answer;
    }

    public void setAnswerCollection(String[] collection){

        this.answer_collection = collection;
    }

    public void set_question_number(int question_number){

        this.question_number = question_number; 
    }

 


    // Multiple Choice Constructor
    // TODO: Implement an overload
    public MultipleChoice(String question, String correctAnswer, String[] collection, int question_number){
        // Pass preloaded data
        this.question = question;
        this.correctAnswer = correctAnswer;                   
        this.answer_collection = collection;
        this.question_number = question_number;
    }

    // Use when all mutator methods are invoked
    public MultipleChoice(){


    }


    @Override
    public void displayChoices() {
        
        int count = 1;
        String letter = "";

       // Use itterator (foreach) to loop through an array of collection 
       for(String a : answer_collection){
        
        System.out.print(Quiz_Console_Base.BRIGHT_CYAN);
          System.out.println(  // Display

            letter = count == 1? "    A. " + answer_collection[count - 1] : // Ternary Operation
            count == 2? "    B. " + answer_collection[count -1] : 
            count == 3? "    C. " + answer_collection[count-1]: 
            count == 4? "    D. " + answer_collection[count-1] : "A" +
            a 
          
          );
          System.out.print(Quiz_Console_Base.RESET);

          count++;

       }

       letter = ""; // Reset
       count = 0; // reset

       System.out.println();
       
    }

    // Display Questions
    @Override
    public void displayQuestion(){

        System.out.println( Quiz_Console_Base.BOLD + Quiz_Console_Base.BG_GREEN + "==== Qustion:" +question_number+" ===================================================================" + Quiz_Console_Base.RESET 
            );

        System.out.println("\n" +question+ "\n");
    }

    // Validate answer 
    @Override
    public void ValidateAnswer(){
        isAnswerCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

        // Display the correct answer if the user input the incorrects input
        if(isAnswerCorrect == false){

            System.out.println(
                Quiz_Console_Base.BG_RED +"Awww snap... The correct answer is " + correctAnswer + Quiz_Console_Base.RESET
            );
            System.out.println("\n");
            isAnswerCorrect = false;
        }

        else{


            System.out.println( // Message
                Quiz_Console_Base.BG_CYAN + "   Correct, the answer is"  + correctAnswer + Quiz_Console_Base.RESET
            ); 
            System.out.println("\n");
            isAnswerCorrect = true; 
        }
    }

    @Override
    public void MainActivity(){
        
        // char value of the correct answer
        char userInputOnActivity = ' ';
        boolean isUserInputCorrect = false; // To avoid null reference exception

        displayQuestion();
        System.out.println(); // space
        displayChoices();

        // For direction
        System.out.println(
            Quiz_Console_Base.ORANGE +">> Type the letter of the correct answer (From A - B - C - D).... << " + Quiz_Console_Base.RESET
        );

        
        // Collection of valid answer
        Queue<Character> b = new LinkedList<>();
        b.add('a');
        b.add('b');
        b.add('c');
        b.add('d');
        
        

        // Loop until the user inputs the correct answer
        while(isUserInputCorrect != true){
            System.out.print("------\n "+"Answer >> ");
            try{ 

                System.out.print(Quiz_Console_Base.BRIGHT_YELLOW);
                userInputOnActivity =  Character.toLowerCase( userInput.next().charAt(0)); // Assign value
                System.out.println(Quiz_Console_Base.RESET);
                if(b.contains(userInputOnActivity)){} else {throw new Exception("WrongInputException");};
                isUserInputCorrect = true;

            }
            catch(Exception ex) {
    
                System.out.println(Quiz_Console_Base.RED +"!! ----- Wrong input ------ !! --|| Please enter the valid character || ------ " + Quiz_Console_Base.RESET);
                System.out.println(); // space
              
            }
            System.out.println();
        }

        // Interpret the user input
        userAnswer = Character.toLowerCase(userInputOnActivity) == 'a'?  answer_collection[0] : 
        Character.toLowerCase(userInputOnActivity) == 'b'?  answer_collection[1] : 
        Character.toLowerCase(userInputOnActivity) == 'c'?  answer_collection[2] : 
        Character.toLowerCase(userInputOnActivity) == 'd'?  answer_collection[3] : 
        answer_collection[0];

        // Call the validator method
        ValidateAnswer();

    }

    @Override
    public boolean GetQuestionState(){
        return this.isAnswerCorrect;
    }

}


/// Identification
@JsonIgnoreProperties(ignoreUnknown = true)
class Identification implements Quiz_model{


    private String question;
    private String correctAnswer;
    private int question_number; 
    private boolean isAnswerCorrect;
    private int Score; // TODO -- remove this after debugs

    // Local Properties without mutators and accessors
    private String userAnswer;

    // Initialize Scanner Here
    transient Scanner userInput = new Scanner(System.in);
     
    // Accessor - - 
    public String getQuestion(){
        return question.trim();
    }

    public String getCorrectAnswer(){
        return correctAnswer.trim();
    }

    public int get_question_number(){
        return question_number;
    }

    public boolean get_isAnswerCorrect(){
        return isAnswerCorrect;
    }
    
    public int getScores(){
        return this.Score; 
    }


    // Mutator - - 
    public void setQuestion(String question){
        this.question = question.trim(); 
    }

    public void setCorrectAnswer(String answer){
        this.correctAnswer = answer;
    }

    public void set_question_number(int question_number){
        this.question_number = question_number; 
    }


    // Constructors
    public Identification(String question, String correctAnswer, int question_number ){

        // Assign new values
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.question_number = question_number;
        
    }
 

     // Use when all mutator methods are invoked
    public Identification(){
        // When this constructor has been called
        // The object must individually calls the mutator methods
        // Otherwise, all properties will return a null value
    }
    

    // Main activity function instances

    @Override
    public void displayChoices() {
       
        // Do nothing here
    }

    @Override
    public void displayQuestion(){
        System.out.println( "\u001b[93m==== Qustion:" +question_number+" ===================================================================\u001b[0m\n\n" 
        + "\u001b[1m" + question + "\u001b[0m");


    }

    @Override
    public void ValidateAnswer(){

        userAnswer = userAnswer.trim(); // trim trailing white spaces
        isAnswerCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

        // display the correct answer if the user input the incorrect answer
        if(isAnswerCorrect == false){

            System.out.println(
                "        \u001b[91mAwww snap... The correct answer is  \u001b[31m \u001b[3m  " + correctAnswer + "\u001b[0m\n"
            );
            isAnswerCorrect = false;
        }
        else{
            System.out.println(
                "         \u001b[94mCorrect.. The right answer is   \u001b[3m \u001b[34m" + correctAnswer + "\u001b[0m \n"
            );
            isAnswerCorrect = true;
        }
    }

    @Override
    public void MainActivity(){
         // char value of the correct answer
         String userInputOnActivity = "" ;
         boolean isUserInputCorrect = false; // To avoid null reference exception
 
         // Display the question for the user 
         displayQuestion();
         System.out.println(); // space
        
         // Loop until the user inputs the correct answer
         while(isUserInputCorrect != true){
             System.out.print("Answer >>");
             try{ 
                
                 userInputOnActivity = userInput.nextLine();
                 isUserInputCorrect = true; 

             }
             catch(Exception ex) {
     
                 System.out.println(Quiz_Console_Base.RED + "!! ----- Wrong input ------ !! --|| Please enter the valid character || ------ " + ex.getMessage() + Quiz_Console_Base.RESET);
                 isAnswerCorrect = false;

             }
         }

          // Close the instance of the scanner class for the Java Garbage Collector to get rid of excess memory usage
         isUserInputCorrect = false; // Reset the property for the next use

         // Pass the local property to the global property in the class
         userAnswer = userInputOnActivity;

         System.out.println(); // space

         // validate the answer 
         ValidateAnswer();
    }

    @Override
    public boolean GetQuestionState(){
        return this.isAnswerCorrect;
    }


}


