package com.final_project_oop.quiz;

import java.util.ArrayList;


/// <Summary> -----------------------------------------------------
/// 
/// This class initializes the pre built quizes on the main activity
/// 
/// 
/// 
/// 
///  <Summary> ----------------------------------------------------- 

public class Template_quiz {

    public static void HistoryMultipleChoice(){


        // Pass properties
        QuizActivity history = new QuizActivity();
            history.setQuizName("General History of the Philippines");
            history.setQuizID(100);
            history.setQuizSubj("History ");
            history.setType("MC"); // Multiple Choice
        
        ArrayList<Quiz_model> questions = new ArrayList<Quiz_model>();

            // Questions 1
            questions.add(new MultipleChoice(
                "Whats your name?", 
                "Allen",
                new String[]{"Sample", "Sample", "Sample" , "Sample"},
                1
            ));

            // Questions 2
            questions.add(new MultipleChoice(
                "What of the person who is known as the 1st editor of La Solaridad?", 
                "Graciano Lopez Jaena",
                new String[]{"Graciano Lopez Jaena", "Jose Rizal", "Paciano Lopez" , "Juan Ponce Inrile"},
                2
            ));

            // Questions 3
            questions.add(new MultipleChoice(
                "What of the person who is known as the 1st editor of La Solaridad?", 
                "Graciano Lopez Jaena",
                new String[]{"Graciano Lopez Jaena", "Jose Rizal", "Paciano Lopez" , "Juan Ponce Inrile"},
                2
            ));

            // Intance the list
            history.question_collection = questions;

            // Add the base class
            quiz_collection.quizCollection.add(history);
        


    }

    public static void Identification(){
        
        // Create the instance of the object
        QuizActivity historyOfComputing = new QuizActivity();
            historyOfComputing.setQuizName("History of computing");
            historyOfComputing.setQuizID(100);
            historyOfComputing.setQuizSubj("History ");
            historyOfComputing.setType("MC"); 

        
            // Create a temporary Array list collection
            ArrayList<Quiz_model> temporaryQuestionCollection = new ArrayList<>();


            // Add data to the temporary arraylist collection 
            temporaryQuestionCollection.add(
                new Identification(
                    "Sample Question",
                    "Sample Answer",
                    1
                )
            );

            // Add data to the temporary arraylist collection 
            temporaryQuestionCollection.add(
                new Identification(
                    "Sample Question",
                    "Sample Answer",
                    2
                )
            );

            // Add data to the temporary arraylist collection 
            temporaryQuestionCollection.add(
                new Identification(
                    "Sample Question",
                    "Sample Answer",
                    3
                )
            );

            // Add data to the temporary arraylist collection 
            temporaryQuestionCollection.add(
                new Identification(
                    "Sample Question",
                    "Sample Answer",
                    4
                )
            );


            // pass the temporary question collection to the object
            historyOfComputing.question_collection = temporaryQuestionCollection;

            // Pass the object to the 
            quiz_collection.quizCollection.add(historyOfComputing);


    }

}

