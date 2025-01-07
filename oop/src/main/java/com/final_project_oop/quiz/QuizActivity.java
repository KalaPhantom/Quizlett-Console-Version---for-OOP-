package com.final_project_oop.quiz;

import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/// <Summary Note> ------------------------------------------------------
/// 
///  This will serve as the base class of the quiz
/// 
///     this will contain:
///     > Introductory messages and information about the quiz
///     > Local properties such as Quiz name and the subject
///     > A linear data structure as a storage for all instances of quiz
///     > Method to play the quiz
/// 
/// </Summary Note> ------------------------------------------------------

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizActivity extends Quiz_Console_Base{

    private String QuizName; 
    private String QuizSubject;
    private String Quiztype;
    private int QuizID;
    private int Scores; // Must be declared as read only 

    // Constructor
    public QuizActivity(){

    }

    // Accessor methods
    public String getQuizName(){

        return this.QuizName;
    }

    public String getQuizSubject(){

        return this.QuizSubject;
    }

    public int getQuizID(){
        return this.QuizID;
    }

    public String getType(){
        return this.Quiztype;
    }

    public int getScores(){
        return this.Scores;
    }


    // Mutator Methods
    public void setQuizName(String QuizName){
        this.QuizName = QuizName;
    }

    public void setQuizSubject (String QuizSubject){
        this.QuizSubject = QuizSubject;
    }

    public void setQuizID(int QuizID){
        this.QuizID = QuizID;
    }

    public void setType (String type){
        this.Quiztype = type; 
    }

    public void setScores(int scores) {
        this.Scores = scores;
    }


    // Collection of all questions
    public ArrayList<Quiz_model> question_collection = new ArrayList<Quiz_model>();

	public void PlayQuiz(){

        ClearConsole(); // clear the contents of the console

        
        Scanner SCN = new Scanner(System.in);

        for(Quiz_model a : question_collection){

            System.out.println();
            System.out.println(BG_BLUE + "================================= QUIZ ========================================= " + RESET);
            System.out.println("\n");
            System.out.println(ORANGE + 
                            "      Quiz Name: " + getQuizName() + "\n" +
                            "      Quiz ID: " + getQuizID() + "\n" +
                            "      Subject: " + getQuizSubject() + "\n" +
                            "      Total Items: " + question_collection.size() + "\n" + RESET 
                            );
        
            System.out.println(BG_BLUE +"=================================================================================" + RESET );
            System.out.println("\n\n");

            a.MainActivity();

            System.out.println();
            System.out.println(BG_BLUE + "   >> Press Enter to Continue <<   " + RESET);
            SCN.nextLine();
            ClearConsole();
        }

        CountScores();
    }

    // returns the value of the total scores of a quiz
    public int CountScores(){

        Scanner SCN_Canceler = new Scanner(System.in);

        ClearConsole();

        System.out.println(BRIGHT_CYAN + " = = = = = = = = = =  Quiz Results = = = = = = = = = = " + RESET + "\n\n");

        int Score = 0;
        int numberOfQuestion = question_collection.size();
        int Average;

        for(Quiz_model a : question_collection){

            if(a.GetQuestionState() == true){
                Score++;
            }
        }

        this.Scores = Score;

        



        // Display the header
        System.out.println(BRIGHT_YELLOW +"     >> YOUR SCORE << \n\n" + RESET );

        // Calculates the average in 100 base score system
        Average = (Score / numberOfQuestion) * 100;

        // Acts similar to a switch statement
        System.out.println(
             Average > 70? BRIGHT_BLUE +"        Score:" + Score + "/ " + numberOfQuestion +"    ..... [AVERAGE] : "+ Average + RESET : 
             Average < 70 && Average > 50? BRIGHT_YELLOW +"        Score:" + Score + "/" + numberOfQuestion +"    ..... [AVERAGE] : "+ Average + RESET:
             Average < 50 ? BRIGHT_RED +"        Score" + Score + "/" + numberOfQuestion +"    ..... [AVERAGE] : "+ Average + RESET : "NO SCORE"
        );

        System.out.println(BRIGHT_CYAN + ". . . . . . >> Press Enter to Continue << . . . . ."  + RESET );
        SCN_Canceler.nextLine();

        return Score;
    }   
    
}



