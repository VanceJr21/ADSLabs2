import java.util.Random;

public class LoadedDice extends Random {

    public LoadedDice(){
        // invoking the Random object constructor
        super();
    }

    @Override
    public int nextInt(int num) {

        Random rand = new Random();
         int randNum = rand.nextInt(0,2); // setting up the 50% chance of the
                                                       // Random nextInt() and LoadedDice nextInt()

        if (randNum == 0) {
            return num - 1; // returning the largest number
        }

        return super.nextInt(num); // returning the Random method
    }
}
