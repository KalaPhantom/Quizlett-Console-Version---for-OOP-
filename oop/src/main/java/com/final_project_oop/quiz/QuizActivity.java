package com.final_project_oop.quiz;

import java.util.ArrayList;

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


public class QuizActivity {

    private String QuizName; 
    private String QuizSubject;
    private String type;
    private int QuizID;

    // Accessor methods

    public String getQuizName(){

        return this.QuizName;
    }

    public String getQuizSubjeString(){

        return this.QuizSubject;
    }

    public int getQuizID(){
        return this.QuizID;
    }

    public String getType(){
        return this.type;
    }


    // Mutator Methods
    public void setQuizName(String QuizName){
        this.QuizName = QuizName;
    }

    public void setQuizSubj (String QuizName){
        this.QuizSubject = QuizSubject;
    }

    public void setQuizID(int QuizID){
        this.QuizID = QuizID;
    }

    public void setType (String type){
        this.type = type; 
    }

    // Collection of all questions
    public ArrayList<Quiz_model> question_collection = new ArrayList<Quiz_model>();

	public void PlayQuiz(){

        for(Quiz_model a : question_collection){
            a.MainActivity();
        }
    }
}



