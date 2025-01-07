package json_methods;

import com.final_project_oop.quiz.QuizActivity;
import com.final_project_oop.quiz.Quiz_model;
import com.final_project_oop.quiz.quiz_collection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;



public class JSON_methods {

    public static void SerializeOnJson() throws Exception{

        File file = new File("quizCollection.json");

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(file, quiz_collection.quizCollection);

        // Serialize the Quiz object to JSON
        //String json = objectMapper.writeValueAsString(quiz_collection.quizCollection);
        
    }


    public static void deserialize() throws IOException{

         // Create an ObjectMapper instance
         ObjectMapper objectMapper = new ObjectMapper();

         // Specify the file to read from
         File file = new File("quizCollection.json");

        quiz_collection.quizCollection = objectMapper.readValue(file, new TypeReference<ArrayList<QuizActivity>>() {});

        
    }


  


}



