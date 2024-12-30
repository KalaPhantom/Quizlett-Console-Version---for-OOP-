package com.final_project_oop.quiz;

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
}
