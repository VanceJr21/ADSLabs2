import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class FallingSand extends Canvas implements MouseListener,
        MouseMotionListener{

    private final int WIDTH = 640;

    private final  int HEIGHT = 240;

    private final int size = 2;

    private  final boolean [][] sand = new boolean[HEIGHT][WIDTH];

    private boolean active  = false;

    private  int x;

    private int y;

    public FallingSand(){
        this.setSize(WIDTH, HEIGHT);

        this.addMouseListener(this);

        this.addMouseMotionListener(this);
    }

    public void mousePressed(MouseEvent e){
        this.x = e.getX();

        this.y = e.getY();

        this.active = true;
    }

    public void mouseDragged(MouseEvent e){
        this.x = e.getX();

        this.y = e.getY();
    }

    public void mouseReleased(MouseEvent e){
        this.active = false;
    }

    public void mouseClicked(MouseEvent e){}

    public void mouseExited(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseMoved(MouseEvent e){}

    public void paint(Graphics g){
        g.setColor(Color.WHITE);

        g.fillRect(0,0, this.WIDTH, this.HEIGHT);

        g.setColor(Color.RED);

        for(int r = 0; r < this.HEIGHT; r++){
            for(int c = 0; c < this.WIDTH; c++){
                if(this.sand[r][c]){
                    g.fillRect(c,r, this.size, this.size);
                }
            }
        }
    }

    public void run(){
        boolean running = true;

        while (running){
            try{
                Thread.sleep(1);
            } catch (Exception e){
                e.printStackTrace();
            }

            if(this.active){
                this.sand[this.y][this.x] = true;
            }

            for(int r = this.HEIGHT - 2; r >= 0; r--){
                for (int c =1; c< this.WIDTH -1; c++){

                    if(!this.sand[r][c]){
                        continue;
                    }

                    if (!this.sand[r+1][c]){
                        this.sand[r][c] = false;
                        this.sand[r+1][c] = true;
                    }

 //                  else if (!this.sand[r+1][c+1]){
 //                       this.sand[r][c] = false;
//                        this.sand[r+1][c+1]= true;
//                    }

                    else if (!this.sand[r+1][c+1]){
                        this.sand[r][c] = false;
                        this.sand[r+1][c+1]= true;
                    }
                }
            }

            repaint();
        }

    }


}
