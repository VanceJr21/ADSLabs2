import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Random;

import java.util.LinkedList;

/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/26/2024
Description: I did the Necessary Modifications:

• Move the pellet to a random location each time the snake eats it.

• Modify the paint method to draw the snake’s head in a different color.

• Add another check to end the game if the snake goes offscreen.

• Add obstacles to Snake. The game ends if the snake’s head collides with any obstacle. Tip: use an ArrayList<Rectangle> to represent the obstacles. You can start by putting a few blocks in fixed locations, then experiment with randomizing

their positions.

• Add a second type of pellet that makes the snake shrink. Give it a different color.

• Add a score counter that increases as the player eats pellets. You can add it to the

screen using the drawString method of Graphics.

*/

enum Direction{
    RIGHT, LEFT, UP, DOWN
}

public class Snake extends Canvas implements KeyListener, Runnable {

    private LinkedList<Rectangle> snake;

    private Rectangle pellet;

    private Rectangle shrinkPellet;

    private Direction direction;

    private ArrayList<Rectangle> obstacle;

    private int counter;

    //constants
    private final int WIDTH = 400, HEIGHT = 400, SIZE =10;

    public Snake(){
        this.setSize(WIDTH, HEIGHT);
        this.addKeyListener(this);

        this.setFocusable(true);
        this.requestFocus();

        this.snake = new LinkedList<>();

        // adding rectangles to the snake
        this.snake.add(new Rectangle(90,90,SIZE,SIZE));
        this.snake.add(new Rectangle(90 - SIZE,90,SIZE,SIZE));


        // create pellet
        this.pellet = new Rectangle(300,240, SIZE,SIZE);

        // initial direction
        this.direction = Direction.RIGHT;

        // creating obstacle
        this.obstacle = new ArrayList<>();
        // adding rectangles to the obstacles
        this.obstacle.add(new Rectangle(200, 38, SIZE,SIZE));
        this.obstacle.add(new Rectangle(78, 300, SIZE,SIZE));
        this.obstacle.add(new Rectangle(300, 123, SIZE,SIZE));

        // creating the shrinking pellet
        this.shrinkPellet = new Rectangle(100, 100, SIZE,SIZE);

        //initializing the score
        this.counter = 0;

    }

    // listen for key presses
    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_RIGHT){
            this.direction = Direction.RIGHT;
        }
        else if(code == KeyEvent.VK_LEFT){
            this.direction = Direction.LEFT;
        }
        // if the up arrow is pressed
        else if (code == KeyEvent.VK_UP){
            this.direction = Direction.UP;
        }
        else if (code == KeyEvent.VK_DOWN){
            this.direction = Direction.DOWN;
        }
    }


    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){}

    // main paint method
    public void paint(Graphics g){

        //clear the screen
        g.setColor(Color.WHITE);
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        // drawing the snake
        // changing the head of the snake
       for(int i =0; i < this.snake.size(); i++){
           if(i == 0){
               g.setColor(Color.MAGENTA);
           }
           else {
               g.setColor(Color.PINK);
           }

           g.fillRect(snake.get(i).x, snake.get(i).y, SIZE,SIZE);

       }

      // drawing pellet
       g.setColor(Color.RED);
       g.fillRect(pellet.x, pellet.y, SIZE,SIZE);

       // drawing obstacle
       g.setColor(Color.GREEN);
       for( Rectangle rect : obstacle){
            g.fillRect(rect.x, rect.y, SIZE,SIZE);
        }

       // drawing shrinking pellet
       g.setColor(Color.BLACK);
       g.fillRect(shrinkPellet.x, shrinkPellet.y, SIZE,SIZE);

       // drawing the Score
        // adding a font to it.
        String score = "Score: " + counter;
        Font f = new Font("Poppins", Font.BOLD, 18);
        g.setFont(f);
       g.drawString(score, 145,20 );

    }



    public void run(){
        boolean running = true;
        while (running){
            try {
                Thread.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }

            //get the current head
            Rectangle head = this.snake.getFirst();
            int newX = head.x;
            int newY = head.y;

            //move head in the right direction
            if(this.direction == Direction.RIGHT){
                newX += SIZE;
            }


            if(this.direction == Direction.LEFT){
                newX -= SIZE;
            }

            if(this.direction == Direction.DOWN){
                newY += SIZE;
            }

            if(this.direction == Direction.UP){
                newY -= SIZE;
            }

            // add the new head at the front of the list
            Rectangle newHead = new Rectangle(newX, newY, SIZE,SIZE);
            this.snake.addFirst(newHead);

            if(!head.intersects(pellet)){
                this.snake.removeLast();


            }
            // Shrinks the snake every time it eats this pellet
            if (head.intersects(shrinkPellet)){
                this.snake.removeLast();
            }

            // Random pellet
            if (head.intersects(pellet)){
                counter++; // keeping track of the score when the snake eats the pellet
                Random rand = new Random();
                pellet.x = rand.nextInt(WIDTH);
                pellet.y = rand.nextInt(HEIGHT);

            }

            // making obstacles which the game will end
            // if the snake runs into the obstacle
            for (Rectangle rect : this.obstacle){
                if(head.intersects(rect)){
                    running = false;
                }

            }

            // Checking the bound
            if(head.x == 0 || head.y == 0){
                running = false;
            }
            else if(head.x == WIDTH || head.y == HEIGHT){
                running = false;
            }

            for (Rectangle rect : this.snake){
                if(rect != head && head.intersects(rect)){
                    running = false;
                }
            }

            repaint();
        }
        System.out.println("Snake is dead ):");

    }
}
