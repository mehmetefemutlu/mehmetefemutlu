import javax.swing.JFrame;
import java.awt.Dimension;

public class Menu {

    private static final int WIDTH1 = 400;
    private static final int HEIGHT1 = 200;

    private static final int WIDTH2 = 600;
    private static final int HEIGHT2 = 400;

    public static void main(String[] args) {     
        MenuFrame frame = new MenuFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Ship Game");
        frame.setSize(new Dimension(WIDTH1, HEIGHT1));
        
        GameFrame frame2 = new GameFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(new Dimension(WIDTH2, HEIGHT2));
        while(frame.isVisible()){
            frame2.setVisible(false);
        }
        frame2.setVisible(true);
        frame2.setName(frame.getName());
        frame2.setSpeed(frame.getSpeed());

        

    }
}
