package com.final_project_oop.quiz;

import java.util.Scanner;

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
public interface Quiz_model {

    public void displayQuestion();
    public void displayChoices();
    public void ValidateAnswer();
    public void MainActivity(); 

}

/// Multiple Choice type
class MultipleChoice implements Quiz_model{


    // Abstraction
    // Local class properties
    private String question;
    private String correctAnswer;
    private String[] answer_collection;
    private int question_number;
    private boolean isAnswerCorrect;

    // Scanner for user input
    Scanner userInput = new Scanner(System.in);

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
    public MultipleChoice(String question, String correctAnswer, String[] collection ){
        
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

          System.out.println(  // Display

            letter = count == 1? "A" : // Ternary Operation
            count == 2? "B" : 
            count == 3? "C" : 
            count == 4? "D" : "A" +
            a 
          
          );

          count++;

       }

       letter = ""; // Reset
       count = 0; // reset
       
    }

    // Display Questions
    @Override
    public void displayQuestion(){

        System.out.println( "==== Qustion:" +question_number+" ===================================================================\n\n" +
            question);
    }

    // Validate answer 
    @Override
    public void ValidateAnswer(){
        isAnswerCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

        // Display the correct answer if the user input the incorrects input
        if(isAnswerCorrect == false){

            System.out.println(
                "Awww snap... The correct answer is " + correctAnswer + "\n"
            );
        }
    }

    @Override
    public void MainActivity(){
        
        // char value of the correct answer
        char userInputOnActivity = ' ';
        boolean isUserInputCorrect = false; // To avoid null reference exception

        displayChoices();
        System.out.println(); // space
        displayChoices();

        System.out.println(
            ">> Type the letter of the correct answer (From A - B - C - D).... <<"
        );

        


        // Loop until the user inputs the correct answer
        while(isUserInputCorrect != true){
            System.out.print("Answer >>");
            try{ 

                userInputOnActivity = userInput.next().charAt(0); // Assign value

            }
            catch(Exception ex) {
    
                System.out.println("!! ----- Wrong input ------ !! --|| Please enter the valid character || ------");
            }

        }

        // Interpret the user input
        userAnswer = Character.toLowerCase(userInputOnActivity) == 'a'?  answer_collection[0] : 
        Character.toLowerCase(userInputOnActivity) == 'b'?  answer_collection[0] : 
        Character.toLowerCase(userInputOnActivity) == 'c'?  answer_collection[0] : 
        Character.toLowerCase(userInputOnActivity) == 'd'?  answer_collection[0] : 
        answer_collection[0];

        // Call the validator method
        ValidateAnswer();

    }

}


/// Identification
class Identification implements Quiz_model{


    private String question;
    private String correctAnswer;
    private int question_number; 
    private boolean isAnswerCorrect;

    // Local Properties without mutators and accessors
    private String userAnswer;

    // Initialize Scanner Here
    Scanner userInput = new Scanner(System.in);
     
 

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
    public Identification(String question, String correctAnswer, String[] collection ){
        
    }
 

     // Use when all mutator methods are invoked
    public Identification(){
 

    }
    

    // Main activity function instances

    @Override
    public void displayChoices() {
       
        // Do nothing here
    }

    @Override
    public void displayQuestion(){
        System.out.println( "==== Qustion:" +question_number+" ===================================================================\n\n" +
        question);


    }

    @Override
    public void ValidateAnswer(){

        isAnswerCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

        // display the correct answer if the user input the incorrect answer
        if(isAnswerCorrect == false){

            System.out.println(
                "Awww snap... The correct answer is " + correctAnswer + "\n"
            );
        }
        
    }

    @Override
    public void MainActivity(){
         // char value of the correct answer
         String userInputOnActivity = "";
         boolean isUserInputCorrect = false; // To avoid null reference exception
 
         // Display the question for the user 
         displayQuestion();
         System.out.println(); // space
        
         // Loop until the user inputs the correct answer
         while(isUserInputCorrect != true){
             System.out.print("Answer >>");
             try{ 
                
                 userInputOnActivity = userInput.nextLine().toLowerCase();
                 isUserInputCorrect = true; 
                
             }
             catch(Exception ex) {
     
                 System.out.println("!! ----- Wrong input ------ !! --|| Please enter the valid character || ------");

             }

         }

         userInput.close();  // Close the instance of the scanner class for the Java Garbage Collector to get rid of excess memory usage
         isUserInputCorrect = false; // Reset the property for the next use

         // Pass the local property to the global property in the class
         userAnswer = userInputOnActivity;

         // validate the answer 
         ValidateAnswer();
    }


}


