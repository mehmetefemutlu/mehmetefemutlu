import javax.swing.JFrame;

/**
 * GameFrame
 */

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    private int speed;
    private String name;

    public GameFrame(){
        gamePanel = new GamePanel(this);
        add(gamePanel);
        setResizable(false);
    }
    public void setSpeed(int value){
        speed = value;
    }
    public void setName(String word){
        name = word;
    }
    public String getName(){
        return name;
    }
    public int getSpeed(){
        return speed;
    }

}

    
