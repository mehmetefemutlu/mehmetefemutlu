import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GamePanel
 */
public class GamePanel extends JPanel implements ActionListener{

    private Ship s;
    private ArrayList<InterectableDrawing> elements;
    private GameFrame frame;
    private Timer t;

    public GamePanel(GameFrame frame){
        this.frame = frame;
        elements = new ArrayList<>();
        setBackground(Color.BLUE);
        createShip();
        setTitle();

        t = new Timer(frame.getSpeed(), this);
        t.start();
    }  

    public void createShip(){
        s = new Ship(frame);
        s.setPreferredSize(new Dimension(600, 400));
        add(s);
        MouseMotionAdapter listener = new MouseMovedListener();
        addMouseMotionListener(listener);
    }

    public void createElements(){
        elements.add(new Bomb((int)(Math.random()*400)));
        elements.add(new Apple((int)(Math.random()*400)));
    }

    public void controlMovements(){
        ArrayList<InterectableDrawing> temp = elements;
        for(int i=0; i<temp.size(); i++){
            if(elements.get(i).moveLeft(frame.getSpeed())){
                elements.remove(elements.get(i));
            }
        } 
    }

    public void controlIntersections(){

        for(int i=elements.size() -1; i>=0; i--){
            if(elements.get(i).intersects(s)){
                elements.get(i).interact(s);       
                elements.remove(i);
            }
        }
        checkEnding();
    }

    public void actionPerformed(ActionEvent event){
        int pos = (int)(Math.random()*100);
        if(pos<frame.getSpeed()){
            createElements();
        }
        controlMovements();
        controlIntersections();
        repaint();
    }

    public void setTitle(){
        frame.setTitle("Life: " + s.getHealth() + " Score: " + s.getScore());
    }

    public void checkEnding(){
        if(s.getScore()==30){
            t.stop();
            int opt = JOptionPane.showConfirmDialog(frame, "Score: " + s.getScore() + " Do you want to continue?");
            if(opt==JOptionPane.YES_OPTION){
                s.setHealth(3);
                s.setScore(0);
                t.start();
            }
            else{
                System.exit(0);
            }
        }
        else if(s.getHealth()==0){
            t.stop();
            int opt = JOptionPane.showConfirmDialog(frame, "Life: " + s.getHealth() + " Do you want to continue?");
            if(opt==JOptionPane.YES_OPTION){
                s.setHealth(3);
                s.setScore(0);
                t.start();
            }
            else{
                System.exit(0);
            }
            
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        s.draw(g);
        for(InterectableDrawing i: elements){
            i.draw(g);
        }
        setTitle();
    }

    class MouseMovedListener extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent event){
            s.setX(event.getX());
            s.setY(event.getY());
            repaint();
        }
    }
}