/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package h8;

//import scanner
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

//begin program
public class H8 {

    /**
     * @param args the command line arguments
     */
    //main
    public static void main(String[] args) {
        
    //this program is a game of hangman, if the user guesses 10 times and does not get the correct word they lose    
        
        
        //declare scanner
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("This is a game of hangman, you have 10 wrong guesses before you lose the game, Good Luck.");
        
        //initializing count
        int count = 0;
        
       File inFile = new File("words_no_duplicates.txt"); 
       Scanner fileInput = null;
       //get file input
       try{
           fileInput = new Scanner(inFile);
       }
       //print out an exception if file is not found
       catch(FileNotFoundException e){
           System.out.println(e);
       }
       
       //random word from file
       Random rand = new Random();
       int randIndex = rand.nextInt(4581) + 1;
       String word = "";
       for(int i = 0; i < randIndex; ++i){
           if(fileInput.hasNext()){
               word = fileInput.next();
           }
       }
        
        //word is blank for the string
        String guess = "";        

        //for loop to add a _ for each letter in the word that needs to be guessed
        for (int i = 0; i<word.length(); ++i){
            guess = guess + "_";
        }
        System.out.println(guess);
        //str is guess 
        String str = guess;
        
        //while loop for the amount of guess the user has done
        while(count<= 10){
        // get first guess letter from user
            System.out.println("Enter a letter: ");
            String letter1 = scnr.nextLine();
            // get char as letter for letter1 
            char letter = letter1.charAt(0);
            int index = word.indexOf(letter);
        
        //if statement for the number of guesses by the user
        if (!word.contains(letter1)){
            count++;
            //print out the guesses that the user has tried
            System.out.println("Guesses: " + count);
        }
        //for loop if the letter is in the word
        for (int i = 0; i < word.length(); ++i){
            //looking for the letter in the word
            if (word.charAt(i) == letter){
                //adding the letter to its location
                str = str.substring(0,i) + letter + str.substring(i+1);
            }
        }
        // if statement if str equals the word the user wins
        if (str.equals(word)){
            System.out.println("You win!");
            System.out.println("The word was: " + word);
            break;
        }
        
        //if the users count is 10 they lose and the word is revealed
        if(count == 10){
            System.out.println("You lost!");
            System.out.println("The word was: " + word);
            break;
    }

        System.out.println(str);

        }
   
        
    }//end
    
}//main