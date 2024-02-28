import java.awt.*;

public abstract class Shape {
    private Color color = Color.black;

    public Shape(){
        this(Color.BLACK);
    }

    public Shape(Color c){
        setColor(c);
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color aColor){
        if(null != aColor){
            this.color = aColor;
        }
    }

    public void setColor(int r, int g, int b){
        setColor(new Color(r,g,b));
    }
}
