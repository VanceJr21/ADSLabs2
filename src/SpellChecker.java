/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 02/16/2024
Description: The program will read two files one with all correct words and
             one with incorrect/correct. Then compare those files to print out
             the incorrect words.
 */


import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {

    String filePath;
    // creating a HashSet
    HashSet<String> dict = new HashSet<>();

    public SpellChecker(String filePath){
        this.filePath = filePath;
    }

    public void readDictionary(){

        try{
            // reading the file
            FileReader fileReader = new FileReader("dictionary.txt");
            Scanner obj = new Scanner(fileReader);

            while (obj.hasNextLine()){
                String correctWord = obj.nextLine();
                dict.add(correctWord); // adding the words from the file into the HashSet
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // checking the another file to see if the words are correct or not
    public void checkWord(){
        try {
            // reading the file
            FileReader newFile = new FileReader(this.filePath);
            Scanner obj2 = new Scanner(newFile);

            while(obj2.hasNextLine()){
                String word = obj2.nextLine();

                // if the set does not have words in the new file
                // it will be incorrect
                if(!dict.contains(word)){
                    System.out.println("Incorrect word -> "+ word);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
