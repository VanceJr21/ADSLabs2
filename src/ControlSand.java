import javax.swing.*;
import java.awt.*;

public class ControlSand {

    public static void main(String[] args) {

        //FallingSand game = new FallingSand();
        FallingSandDoubledBuffering game = new FallingSandDoubledBuffering();

        JFrame frame = new JFrame();



        frame.add(game);
        frame.add(game.button);


        frame.pack();
        frame.setSize(450,450);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game.run();
    }
}
