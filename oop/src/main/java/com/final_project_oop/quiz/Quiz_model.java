package com.final_project_oop.quiz;




///   -----------  <Summary> ------------------------------------------------------------------------------------------
///
///   The interface below will serve as a framework class for all types of quizzes
///   
///   The purpose of this package is to provide an ability for the programmer to store temporary data -
///   Each Object will be instanced and will be stored to another object with a linear data structure -
///   - That object will serve as a base instance - and will be called as "Quiz"
/// 
///   Each base instance - we call it "quiz" - will be stored to another linear data structure (linklist) as the qollection of all-
///   - quiz instance 
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
    private String[] answer_collection;

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


/// Identification
class Identification implements Quiz_model{


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

    @Override
    public void displayChoices() {
       
        
    }

    @Override
    public void displayQuestion(){


    }


}


