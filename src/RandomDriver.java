import java.util.Random;

public class RandomDriver {
    public static void main(String[] args) {

        // LoadedDice object
        LoadedDice myDice = new LoadedDice();
        //Random randGenerator = new Random();
        printDiceRolls(myDice);

    }

    public static void printDiceRolls(Random randGenerator){
        for(int i = 0; i < 100; i++){
            System.out.println(randGenerator.nextInt(6) + 1);
        }
    }

}
