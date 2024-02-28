/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 02/16/2024
Description: The program will prompt the user to enter a word. After the user
             enters a word, then program will output the anagrams of that word.
 */


import java.io.FileReader;
import java.util.*;

public class Anagram {
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> map = new HashMap<>(); // making hashmap
        Sort s = new Sort(); // making the sort object



       try{
           // reading the txt file
           FileReader fileReader = new FileReader("anagram_dictionary.txt");
           Scanner obj = new Scanner(fileReader);


           while(obj.hasNextLine()){
               String word = obj.nextLine(); // storing the words that's in the file into a string
               String sortedWord = s.sortWords(word); // sorts the words in the file

                // checking the key
               if (!map.containsKey(sortedWord)){
                   ArrayList<String> list = new ArrayList<>(); // making the arraylist of values
                   list.add(sortedWord);                       // for the HashMap
                   map.put(sortedWord, list);
               }

               map.get(sortedWord).add(word); // appending to the values in the HashMap

           }

           obj.close();

       } catch (Exception e){
           e.printStackTrace();
       }

       while(true){
           // prompting the user
           Scanner input = new Scanner(System.in);
           System.out.println("Enter in a word to show it's anagram." +
                   " \n-> Enter exit to end the program");

           String newWord = input.next(); // getting the word from the user

           String sortedNewWord = s.sortWords(newWord); // sorting the inputted word

           // to end the program
           if (newWord.equals("exit")){
               break;
           }

           // checking to see the inputted word is in the key of the HashMap
           if(map.containsKey(sortedNewWord)){
               System.out.println(map.get(sortedNewWord)); // printing out the values in the map
           }else {
               System.out.println("The word is not found");
           }



       }
    }
}
