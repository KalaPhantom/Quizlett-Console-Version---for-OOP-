package json_methods;

import com.final_project_oop.quiz.QuizActivity;
import com.final_project_oop.quiz.quiz_collection;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class JSON_methods {



    public static void StoreToJson() {
        String fileName = "QuizData.json";
        Gson gson = new Gson();
    
        try (FileWriter writer = new FileWriter(fileName)) {
            // Serialize the entire quiz collection to JSON
            gson.toJson(quiz_collection.quizCollection, writer);
            System.out.println("JSON stored in " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LoadFromJson() {
        String fileName = "QuizData.json";
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(fileName)) {
            // Deserialize JSON into a collection of QuizActivity objects
            QuizActivity[] activities = gson.fromJson(reader, QuizActivity[].class);
            quiz_collection.quizCollection = new ArrayList<>(Arrays.asList(activities));

            if (new File(fileName).length() == 0) {
                 System.out.println("File is empty. No data to load.");
                 return;
            }

            System.out.println("JSON loaded successfully.");
            
        } catch (IOException e) {

            e.printStackTrace();

        }
    }


}
