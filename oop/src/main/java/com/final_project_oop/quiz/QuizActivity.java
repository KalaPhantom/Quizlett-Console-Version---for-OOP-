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
/// 
/// </Summary Note> ------------------------------------------------------


public class QuizActivity {

    private String QuizName; 
    private String QuizSubject;

    // Accessor methods

    public String getQuizName(){

        return this.QuizName;
    }

    public String getQuizSubjeString(){

        return this.QuizSubject;
    }

    // Mutator Methods
    public void setQuizName(String QuizName){
        this.QuizName = QuizName.trim();
    }

    public void setQuizSubj (String QuizName){
        this.QuizSubject = QuizSubject.trim();
    }

    // Collection of all questions
    public ArrayList<Quiz_model> question_collection = new ArrayList<Quiz_model>();




	
}



