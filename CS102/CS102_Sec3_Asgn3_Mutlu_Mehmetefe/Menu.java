import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Decide the the teamsize: ");
        int choice = in.nextInt();
        System.out.println("TeamSize: " + choice + "\n");

        Simulation sim = new Simulation(choice);
        sim.display();
        sim.simulate();

        in.close();
    }
    
}
