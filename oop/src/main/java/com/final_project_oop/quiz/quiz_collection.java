package com.final_project_oop.quiz;

import java.util.ArrayList;

public class quiz_collection {

    // Main Collection of the quiz
    public static ArrayList<QuizActivity> quizCollection = new ArrayList<QuizActivity>();

    // Operation
    public static void RemoveQuiz(int index){
        quizCollection.remove(index);
    }

    // Add instance
    public static void AddQuiz(QuizActivity quiz){
        quizCollection.add(quiz);
    }

    
}
