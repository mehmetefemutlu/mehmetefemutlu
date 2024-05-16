import java.util.ArrayList;
import java.util.Collections;

public class Simulation {

    private ArrayList<Robot> red;
    private ArrayList<Robot> blue;

    private static int TYPE_NUMBER = 6;

    public Simulation(int size){
        initialize(size);
    }

    private void initialize(int teamSize){
        red = new ArrayList<>(teamSize);
        blue = new ArrayList<>(teamSize);

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
                red.add(r);
                r.isRedTeam = true;
            }
            else{
                blue.add(r);
            }

        }
        Collections.sort(red);
        Collections.sort(blue);
    }


    public void simulate(){
        ArrayList<Robot> team1;
        ArrayList<Robot> team2;
        if(speedSum(blue)>speedSum(red)){
            team1 = blue;
            team2 = red;
            System.out.println("Blue starts first\n");
        }
        else{
            team1 = red;
            team2 = blue;
            System.out.println("Red starts first\n");
        }
        int p = Math.min(team1.size(), team2.size());
        while(team1.size()!=0 && team2.size()!=0){
            for(int i=0; i<p; i++){
                team1.get(i).attack(this);
                if(team2.size()!=0){
                    if(team2.size()-1<i){
                        team2.get(i-1).attack(this);
                    }
                    else{
                        team2.get(i).attack(this);
                    }
                }
                p = Math.min(team1.size(), team2.size());
            }
        }    
        if(team1.size()!=0){
            if(team1==red){
                System.out.println("Red team wins");
            }
            else{
                System.out.println("Blue team wins");
            }
            displayWinning(team1);;
        }
        else{
            if(team2==red){
                System.out.println("Red team wins");
            }
            else{
                System.out.println("Blue team wins");
            }
            displayWinning(team2);;
        }
        
    }

    public void display(){
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
        System.out.println("Speed sum of the blue: " + String.format("%.3f", speedSum(blue)) + "\n");
    }

    public Robot getRandomTarget(boolean isRedTeam){
        if(isRedTeam){
            return red.get((int)(Math.random()*red.size()));
        }
        return blue.get((int)(Math.random()*blue.size()));
    }

    public Robot getHighestHealth(boolean isRedTeam){
        ArrayList<Robot> tempRobots = teamFinder(isRedTeam);

        Robot r = tempRobots.get(0);
        for(int i=0; i<tempRobots.size(); i++){
            if(r.health<tempRobots.get(i).health){
                r = tempRobots.get(i);
            }
        }
        return r;
    }

    public Robot getLowestHealth(boolean isRedTeam){
        ArrayList<Robot> tempRobots = teamFinder(isRedTeam);

        Robot r = tempRobots.get(0);
        for(int i=0; i<tempRobots.size(); i++){
            if(r.health>tempRobots.get(i).health){
                r = tempRobots.get(i);
            }
        }
        return r;
    }

    public Robot getLowestSpeed(boolean isRedTeam){
        ArrayList<Robot> tempRobots = teamFinder(isRedTeam);
        return tempRobots.get(tempRobots.size()-1);
    }

    public Robot getLowestAttack(boolean isRedTeam){
        ArrayList<Robot> tempRobots = teamFinder(isRedTeam);

        Robot r = tempRobots.get(0);
        for(int i=0; i<tempRobots.size(); i++){
            if(r.attack>tempRobots.get(i).attack){
                r = tempRobots.get(i);
            }
        }
        return r;
    }

    public ArrayList<Robot> getLowestSpeed3(boolean isRedTeam){
        ArrayList<Robot> tempRobots = teamFinder(isRedTeam);

        ArrayList<Robot> attacked = new ArrayList<>();
        if(tempRobots.size()>3){
            for(int i=tempRobots.size()-3; i<tempRobots.size(); i++){
                attacked.add(tempRobots.get(i));
            }
        }
        else{
            attacked = tempRobots;
        }
        return attacked;
    }

    public void removeRobot(Robot r){
        if(r.isRedTeam){
            red.remove(r);   
        }
        else{
            blue.remove(r); 
        }
        System.out.println(r.name + " destroyed ");
    }  

    private ArrayList<Robot> teamFinder(boolean isRedTeam){
        if(isRedTeam){
            return red;
        }
        return blue;
    }
    private void displayWinning(ArrayList<Robot> rob){
        for(Robot r: rob){
            System.out.println(r);
        }
    }

    private double speedSum(ArrayList<Robot> r){
        double sum = 0;
        for(int i=0; i<r.size(); i++){
            sum += r.get(i).speed;
        }
        return sum;
    }
}
