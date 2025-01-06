package com.final_project_oop.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz_Console_Base {

    public static final String RESET = "\u001B[0m";

    // String Letter Styles
    public static final String BOLD = "\u001B[1m";
    public static final String DIM = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String REVERSE = "\u001B[7m";
    public static final String STRIKE = "\u001B[9m";

    // RGB
    public static final String ORANGE = "\u001B[38;2;235;183;52m";

    // Low tones
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA =  "\u001B[35m";
    public static final String CYAN =  "\u001B[36m";
    public static final String WHITE =  "\u001B[97m";

    // Bright Colors
    public static final String BRIGHT_RED =  "\u001B[91m";
    public static final String BRIGHT_GREEN =  "\u001B[92m";
    public static final String BRIGHT_YELLOW=  "\u001B[93m";
    public static final String BRIGHT_BLUE =  "\u001B[94m";
    public static final String BRIGHT_MAGENTA =  "\u001B[95m";
    public static final String BRIGHT_CYAN =  "\u001B[96m";
    public static final String BRIGHT_WHITE =  "\u001B[97m";

    // BG COLORS
    public static final String BG_RED =  "\u001B[101m";
    public static final String BG_GREEN =  "\u001B[102m";
    public static final String BG_YELLOW=  "\u001B[103m";
    public static final String BG_BLUE =  "\u001B[104m";
    public static final String BG_MAGENTA =  "\u001B[105m";
    public static final String BG_CYAN =  "\u001B[106m";
    public static final String BG_WHITE =  "\u001B[107m";

    public static void ClearConsole(){
        // Clear the console
        System.out.print("\u001b[H\u001b[2J");  
        System.out.flush(); // Clear the console
        
    }

    public static void DisplayTitle(){

     
           // Display the title splash screen . . . . . . . . 
           System.out.println(Quiz_Console_Base.ORANGE);
           System.out.println("""
                ██████ ██    ████████████████████     ███████████████████████ 
                ██    ████    ████   ███    ███ ██     ██        ██      ██    
                ██    ████    ████  ███    ███  ██     █████     ██      ██    
                ██ ▄▄ ████    ████ ███    ███   ██     ██        ██      ██    
                 ██████  ██████ ██████████████████████████████   ██      ██    
                    ▀▀                                                         
            \u001b[0m
                    """);
            
                  
        
        //scn.close(); // Close the instance for the garbage collection
    }

    public static int Selection(String[] choices, String instruction, String errorMsg, String title){

        // Create an instance of the Scanner
        Scanner SCN = new Scanner(System.in);

        boolean isUserInputCorrect = false; // determines the state of the loop
        int currentSelected = 1; // holds the temporary data 
        int selected = 1; // The permanent value being returned
        int range = choices.length;     
        boolean isModifying = false;
        

        while(isUserInputCorrect == false){

            
            try{

                ClearConsole(); // Clear the console

                // Display the message
                System.out.println(BG_GREEN+"============================<" + title + ">==================================" + RESET);
                System.out.print("\n\n"); // 2x standard spacing
                System.out.println(ORANGE+"   " + instruction + "  "+RESET);
                System.out.println("\n\n\n");

                // print every contents of the choices and assign values using "for" loop statement
                for(int i = 0 ; i < range; i++) {

                    // display all choices 
                    System.out.println(
                        selected -1 == i?  BG_YELLOW + "     >> " + "[" +(i +1) +"]" +choices[i] + " <<" + RESET :
                        "     " + "[" + (i +1)+ "]" +  choices[i] + " <<"
                    );


                }


                // instructional message
                System.out.println(BRIGHT_BLUE +"  >>> Select range from 1 to" + range + "  and press the enter key <<<" + RESET);
                System.out.println(YELLOW +" >> ");

                // Disables
                if(isModifying != true){
                
                    currentSelected = SCN.nextInt(); // Read Value and throws an exception if the desired data type is not met

                    if(currentSelected > range && currentSelected <= 0){
                        throw new Exception("Selection out of range"); // throw an exception when a desired range is not met
                    }
                    selected = currentSelected;
                    isModifying = true;
                }

                System.out.println(); // Space
                System.out.println();

              

                // Display the header again
                ClearConsole();
                  // Display the message
                  System.out.println(BG_GREEN+"============================<" + title + ">==================================" + RESET);
                  System.out.print("\n\n"); // 2x standard spacing
                  System.out.println(ORANGE+"   " + instruction + "  "+RESET);
                  System.out.println("\n\n\n");

                    // Update some values
                    for(int i = 0 ; i < range; i++) {

                        // display all choices 
                        System.out.println(
                            (selected-1) == i?  BG_YELLOW + "     >> " + "[" + (i+1) +"]" +choices[i] + " <<" + RESET :
                            "     " + "[" + (i+1) + "]" +  choices[i] 
                        );
                    }

                System.out.println("\n\n\n");

                // Intruction
                System.out.println(YELLOW + "  - Enter Y/y to confirm the selction \n" +
                                            "  - Enter N/n to exit the selection \n" +
                                            "  - Enter another number to select another choice " +
                                            RESET
                );

                System.out.println("\n\n"); // space

                System.out.print(" >> "); // Input indicator

                String Temp = SCN.next().trim(); // Validates the string for continual execution of the program
                

                if(Temp.equalsIgnoreCase("y")){
                    isUserInputCorrect = true;
                    selected = currentSelected;
                }
                else if (Temp.equalsIgnoreCase("n")){
                    isUserInputCorrect = true;// breaks the program
                    selected = -1;  // assign a non-null value
                }
                else{

                    int recentInput = Integer.parseInt(Temp); // will throw an argument for invalid format type 

                    // validates input and also throw an exception
                    if(recentInput > range || recentInput <= 0){
                        throw new Exception("The Input is higher than the expected range");
                    }
                    else{
                        selected = recentInput;
                    }

                }

            }
            catch(Exception ex){

                Scanner SCN2 = new Scanner(System.in);
                
                System.out.println(
                    "------ <!!> Wrong input Format : Please enter the valid range of numbers from " + 1  +" to " + range + " <!!> ------\n " + ex.getMessage()
                );

                System.out.println(
                    BRIGHT_RED+"------ <> Please press enter to continue <> ---------" + RESET
                );

                // Reset values
                selected = 1;
                currentSelected = 1;

                SCN2.nextLine();


            }

        }

        return selected;
    }

    public static int Selection(ArrayList choices, String instruction, String errorMsg, String title){

        // Create an instance of the Scanner
        Scanner SCN = new Scanner(System.in);

        boolean isUserInputCorrect = false; // determines the state of the loop
        int currentSelected = 1; // holds the temporary data 
        int selected = 1; // The permanent value being returned
        int range = choices.size();     
        boolean isModifying = false;
        

        while(isUserInputCorrect == false){

            
            try{

                ClearConsole(); // Clear the console

                // Display the message
                System.out.println(BG_GREEN+"============================<" + title + ">==================================" + RESET);
                System.out.print("\n\n"); // 2x standard spacing
                System.out.println(ORANGE+"   " + instruction + "  "+RESET);
                System.out.println("\n\n\n");

                // // print every contents of the choices and assign values using "for" loop statement
                // for(int i = 0 ; i < range; i++) {

                //     // display all choices 
                //     System.out.println(
                //         selected -1 == i?  BG_YELLOW + "     >> " + "[" +(i +1) +"]" +choices.get(i) + " <<" + RESET :
                //         "     " + "[" + (i +1)+ "]" +  choices.get(i) + " <<"
                //     );
                // }

                int i = 1;
                for(QuizActivity a : quiz_collection.quizCollection) {

                    // display all choices 
                    System.out.println(
                        selected  == i?  BG_YELLOW + "     >> " + "[" +(i) +"]" + a.getQuizName() + " <<" + RESET :
                        "     " + "[" + (i)+ "]" +  a.getQuizName() + " <<"
                    );
                    i++;
                }




                // instructional message
                System.out.println(BRIGHT_BLUE +"  >>> Select range from 1 to" + range + "  and press the enter key <<<" + RESET);
                System.out.println(YELLOW +" >> ");

                // Disables
                if(isModifying != true){
                
                    currentSelected = SCN.nextInt(); // Read Value and throws an exception if the desired data type is not met

                    if(currentSelected > range && currentSelected <= 0){
                        throw new Exception("Selection out of range"); // throw an exception when a desired range is not met
                    }
                    selected = currentSelected;
                    isModifying = true;
                }

                System.out.println(); // Space
                System.out.println();

              

                // Display the header again
                ClearConsole();
                  // Display the message
                  System.out.println(BG_GREEN+"============================<" + title + ">==================================" + RESET);
                  System.out.print("\n\n"); // 2x standard spacing
                  System.out.println(ORANGE+"   " + instruction + "  "+RESET);
                  System.out.println("\n\n\n");

                    // print every contents of the choices and assign values using "for" loop statement
                    i = 1;
                    for(QuizActivity a : quiz_collection.quizCollection) {
    
                        // display all choices 
                        System.out.println(
                            selected  == i?  BG_YELLOW + "     >> " + "[" +(i) +"]" + a.getQuizName() + " <<" + RESET :
                            "     " + "[" + (i)+ "]" +  a.getQuizName() + " <<"
                        );

                        i++;
                    }

                System.out.println("\n\n\n");

                // Intruction
                System.out.println(YELLOW + "  - Enter Y/y to confirm the selction \n" +
                                            "  - Enter N/n to exit the selection \n" +
                                            "  - Enter another number to select another choice " +
                                            RESET
                );

                System.out.println("\n\n"); // space

                System.out.print(" >> "); // Input indicator

                String Temp = SCN.next().trim(); // Validates the string for continual execution of the program
                

                if(Temp.equalsIgnoreCase("y")){
                    isUserInputCorrect = true;
                    selected = currentSelected;
                }
                else if (Temp.equalsIgnoreCase("n")){
                    isUserInputCorrect = true;// breaks the program
                    selected = -1;  // assign a non-null value
                }
                else{

                    int recentInput = Integer.parseInt(Temp); // will throw an argument for invalid format type 

                    // validates input and also throw an exception
                    if(recentInput > range || recentInput <= 0){
                        throw new Exception("The Input is higher than the expected range");
                    }
                    else{
                        selected = recentInput;
                    }

                }

            }
            catch(Exception ex){

                Scanner SCN2 = new Scanner(System.in);
                
                System.out.println(
                    "------ <!!> Wrong input Format : Please enter the valid range of numbers from " + 1  +" to " + range + " <!!> ------\n " + ex.getMessage()
                );

                System.out.println(
                    BRIGHT_RED+"------ <> Please press enter to continue <> ---------" + RESET
                );

                // Reset values
                selected = 1;
                currentSelected = 1;

                SCN2.nextLine();


            }

        }

        return selected;
    }

  
}
