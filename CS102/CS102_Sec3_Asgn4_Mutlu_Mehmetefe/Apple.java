import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Apple extends JComponent implements InterectableDrawing{

    private int x;
    private int y;
    private static final int APPLE_WIDTH = 10;
    private static final int APPLE_HEIGHT = 10;

    private Rectangle rec;

    public Apple(int y){
        setX(600);
        this.y = y;
        rec = new Rectangle(x, y, APPLE_WIDTH, APPLE_HEIGHT);
        setPreferredSize(new Dimension(600, 400));
    }

    public void setX(int dx){
        x = dx;
    }

    public void setY(int dy){
        y = dy;
    }

    public boolean intersects(Ship s){ 
        return rec.intersects(s.getRect());
    }

    public void interact(Ship s){
        s.setScore(s.getScore() +1);
    }

    public boolean moveLeft(int speed){
        rec.setLocation(rec.x-speed, rec.y);
        return x+APPLE_WIDTH<=0;  
    }

    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(rec.x, rec.y, APPLE_WIDTH, APPLE_HEIGHT);
        g.setColor(Color.RED);
        g.fillOval(rec.x, rec.y, APPLE_WIDTH, APPLE_HEIGHT);
    }
}
