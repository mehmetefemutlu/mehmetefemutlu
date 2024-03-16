import java.util.Arrays;

public class Simulation {

    protected Robot [] red;
    protected Robot [] blue;

    private static int TYPE_NUMBER = 6;

    public Simulation(){
        initialize(5);
    }

    private void initialize(int teamSize){
        red = new Robot[teamSize];
        blue = new Robot[teamSize];

        for(int i=0; i<2*teamSize; i++){
            int typeDecider = (int)(Math.random()*TYPE_NUMBER);
            Robot r;
            switch(typeDecider){
                case 0: r = new SimpleBot();
                    break;
                case 1: r = new PredatorBot();
                    break;
                case 2: r = new DefenceBot();
                    break;
                case 3: r = new SpeedBot();
                    break;
                case 4: r = new SpreadBot();
                    break;
                case 5: r = new OneBot();
                    break;
                default: r = null;
            }

            if(i<teamSize){
                red[i] = r;
                r.isRedTeam = true;
            }
            else{
                blue[i-teamSize] = r;
            }

        }
        Arrays.sort(red);
        Arrays.sort(blue);
    }

    private double speedSum(Robot [] robots){
        double sum = 0;
        for(int i=0; i<robots.length; i++){
            sum += robots[i].speed;
        }
        return sum;
    }
  
    public void simulate(){}

    public void display(){
        System.out.println("TeamSize: " + red.length + "\n");
        System.out.println("Red team:");
        for(Robot r1 :red){
            System.out.println(r1);
        }
        System.out.println();
        System.out.println("Blue team:");
        for(Robot r2 :blue){
            System.out.println(r2);
        }
        System.out.println("\nSpeed sum of the red: " + String.format("%.3f", speedSum(red)));
        System.out.println("Speed sum of the blue: " + String.format("%.3f", speedSum(blue)) +"\n");
        if(speedSum(blue)>speedSum(red)){
            System.out.println("Blue starts first \n");
        }
        else{
            System.out.println("Red starts first \n");
        }
    }
    
}
