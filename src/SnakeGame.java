import javax.swing.JFrame;

public class SnakeGame {

    public static void main(String[] args) {
        Snake game = new Snake();

        //create a new frame
        JFrame frame = new JFrame();
        frame.add(game);

        frame.pack();
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game.run();
    }
}
