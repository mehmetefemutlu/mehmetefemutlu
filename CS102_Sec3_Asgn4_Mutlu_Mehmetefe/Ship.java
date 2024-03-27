import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Ship extends JComponent{

    private static final int SHIP_WIDTH = 40;
    private static final int SHIP_HEIGHT = 20;

    private int health;
    private int score;
    private GameFrame frame;

    private Rectangle rec;

    public Ship(GameFrame frame){
        this.frame = frame;
        rec = new Rectangle(0, 0, SHIP_WIDTH, SHIP_HEIGHT);
        setHealth(6);
        setScore(0);
    }

    public void setX(int dx){
        rec.x = dx;
    }

    public void setY(int dy){
        rec.y = dy;
    }

    public int getHealth(){
        return health;
    }

    public int getScore(){
        return score;
    }

    public Rectangle getRect(){
        return rec;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fill3DRect(rec.x, rec.y, SHIP_WIDTH, SHIP_HEIGHT, false);
        g.setColor(Color.BLACK);
        g.drawString(frame.getName(), rec.x+10, rec.y+14);
    }

}
