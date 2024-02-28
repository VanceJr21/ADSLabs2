import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;

/*
Name: Vance McGahee Jr
Course: COSC 2454
Professor: Dr. Zaki
Date : 01/19/2024
Description: I add a button that clears the sand.
             I tired to fix the size of the button but nothing was happening.
 */


public class FallingSandDoubledBuffering extends JPanel implements MouseListener, MouseMotionListener, Runnable,
ActionListener{
    private final int WIDTH = 640;

    private final int HEIGHT = 240;

    private final int size = 2;

    private final boolean[][] sand = new boolean[HEIGHT][WIDTH];

    private boolean active = false;

    private int x;

    private int y;

    public Image offscreen;

    public Graphics og;
    public JButton button;

    public FallingSandDoubledBuffering() {
        this.setSize(new Dimension(WIDTH, HEIGHT));


        this.addMouseListener(this);

        this.addMouseMotionListener(this);
        // adding the button
        button = new JButton("Clear");

        button.addActionListener(this);
        //button.setSize(new Dimension (WIDTH,HEIGHT));




    }

    public void mousePressed(MouseEvent e) {
        this.x = e.getX();

        this.y = e.getY();

        this.active = true;
    }

    public void mouseDragged(MouseEvent e) {
        this.x = e.getX();

        this.y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        this.active = false;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        clear();
    }

    // clearing the sand
    public void clear(){
        for (int r = 0; r < this.HEIGHT; r++) {
            for (int c = 0; c < this.WIDTH; c++) {
                this.sand[r][c] =false;
            }
        }

    }

    public void paint(Graphics g) {
        g.drawImage(offscreen, 0,0, this);

    }


    public void draw(){
        offscreen = createImage(this.WIDTH, this.HEIGHT);

        og = offscreen.getGraphics();

        og.setColor(Color.WHITE);

        og.fillRect(0,0, this.WIDTH, this.HEIGHT);

        for (int r = 0; r < this.HEIGHT; r++) {
            for (int c = 0; c < this.WIDTH; c++) {
                if (this.sand[r][c]) {
                    float red = c/ (float)this.WIDTH;

                    float green = r / (float)this.HEIGHT;

                    float blue = 0.5f;

                    og.setColor(new Color(red, green, blue));
                    og.fillRect(c,r,this.size, this.size);



                }


            }
        }


    }

    public void run() {
        boolean running = true;

        while (running) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (this.active) {
                this.sand[this.y][this.x] = true;
            }

            for (int r = this.HEIGHT - 2; r >= 0; r--) {
                for (int c = 1; c < this.WIDTH - 1; c++) {

                    if (!this.sand[r][c]) {
                        continue;
                    }

                     if (!this.sand[r + 1][c]) {
                        this.sand[r][c] = false;
                        this.sand[r + 1][c] = true;
                    }

                     else if (!this.sand[r + 1][c - 1]) {
                         this.sand[r][c] = false;
                         this.sand[r + 1][c - 1] = true;
                     }

                    else if (!this.sand[r + 1][c + 1]) {
                        this.sand[r][c] = false;
                        this.sand[r + 1][c + 1] = true;
                    }


                }
            }
            draw();
            repaint();
        }

    }
}