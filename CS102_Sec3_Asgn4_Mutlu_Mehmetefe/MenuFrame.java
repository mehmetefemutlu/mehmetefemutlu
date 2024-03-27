import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MenuFrame
 */
public class MenuFrame extends JFrame {
    
    private JTextField speedField;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel speedLabel;
    private JButton startButton;
    private String name;
    private int speed;

    public MenuFrame(){
        startButton = new JButton("START");

        ActionListener listener = new ClickListener();
        startButton.addActionListener(listener);

        setLayout(new GridLayout(3,1));
        createPanels();
        add(startButton);
        setVisible(true);
    }

    public void createPanels(){
        nameLabel = new JLabel("Name:", SwingUtilities.CENTER);
        speedLabel = new JLabel("Speed:", SwingUtilities.CENTER);
        nameField = new JTextField();
        speedField = new JTextField();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.add(nameLabel);
        panel1.add(nameField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.add(speedLabel);
        panel2.add(speedField);

        add(panel1);
        add(panel2);
    }

    class ClickListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(nameField.getText().length()==0){
                JOptionPane.showMessageDialog(nameField, "Name cannot be empty");
            }
            else if(speedField.getText().length()==0){
                JOptionPane.showMessageDialog(speedField, "Speed cannot be empty");
            }
            else if(!isDigit(speedField)){
                JOptionPane.showMessageDialog(speedField, "Speed should be only numbers");
            }
            else{
                name = nameField.getText();
                speed = Integer.parseInt(speedField.getText());
                setVisible(false);
            }
        }
    }

    private boolean isDigit(JTextField field){
        for(int i=0; i<field.getText().length(); i++){
            if(!Character.isDigit(field.getText().charAt(i)))
            return false;
        }
        return true;
    }

    public String getName(){
        return name;
    }
    public int getSpeed(){
        return speed;
    } 
}