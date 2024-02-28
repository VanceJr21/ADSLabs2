import java.util.Random;

public class LoadedDice extends Random {

    public LoadedDice(){
        super();
    }

    @Override
    public int nextInt(int num) {

        Random rand = new Random();
         int randNum = rand.nextInt(0,2);

        if (randNum == 0) {
            return num - 1;
        }

        return super.nextInt(num);
    }
}
