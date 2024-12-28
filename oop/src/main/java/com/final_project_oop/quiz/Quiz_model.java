package com.final_project_oop.quiz;




///   -----------  <Summary> ------------------------------------------------------------------------------------------
///
///   The interface below will serve as a framework class for all types of quizzes
///   
///   The purpose of this package is to provide an ability for the programmer to store temporary data -
///   Each Object will be instanced and will be stored to another object with a linear data structure -
///   - That object will serve as a base instance - and will be called as "Quiz"
///   
/// 
///   -----------  <Summary> -------------------------------------------------------------------------------------------
public interface Quiz_model {

    public void displayQuestion();
    public void displayChoices();

}


/// Multiple Choice type
class MultipleChoice implements Quiz_model{


    // Abstraction
    // Local class properties
    private String question;
    private String correctAnswer;

    // Accessor - - 
    public String getQuestion(){
        return question.trim();
    }

    public String getCorrectAnswer(){
        return correctAnswer.trim();
    }


    // Mutator - - 
    public void setQuestion(String question){
        this.question = question.trim(); 
    }

    public void setCorrectAnswer(String answer){
        this.correctAnswer = answer;
    }




    // Multiple Choice Constructor
    public MultipleChoice(String question, String correctAnswer, String[] collection ){

    }

    @Override
    public void displayChoices() {
       
        
    }

    @Override
    public void displayQuestion(){


    }

}

class Identification implements Quiz_model{



    @Override
    public void displayChoices() {
       
        
    }

    @Override
    public void displayQuestion(){


    }




}


