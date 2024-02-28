import java.util.Arrays;

public class Sort{

    // default constructor
    public Sort(){}

    // Sorting function of each word that is inputted.
    public String sortWords(String word){
        char[] tempChar = word.toCharArray();
        Arrays.sort(tempChar);
        return new String(tempChar);
    }
}
