import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Bomb extends JComponent implements InterectableDrawing{
    
    private int x;
    private int y;
    private static final int BOMB_WIDTH = 10;
    private static final int BOMB_HEIGHT = 10;

    private Rectangle rec;

    public Bomb(int y) {
        setX(600);
        this.y = y;
        rec = new Rectangle(x, y, BOMB_WIDTH, BOMB_HEIGHT);
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
        s.setHealth(s.getHealth()-1);
    }

    public boolean moveLeft(int speed){
        rec.setLocation(rec.x-speed, rec.y);
        return x+BOMB_WIDTH<=0;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(rec.x, rec.y, BOMB_WIDTH, BOMB_HEIGHT);
        g.setColor(Color.BLACK);
        g.fillOval(rec.x, rec.y, BOMB_WIDTH, BOMB_HEIGHT);
    }
    
}
