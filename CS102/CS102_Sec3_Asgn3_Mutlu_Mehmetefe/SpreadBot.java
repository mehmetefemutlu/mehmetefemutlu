import java.util.ArrayList;

public class SpreadBot extends Robot {

    public SpreadBot(){
        super();

        health = Math.random()+2;
        attack = (Math.random()/2)+0.5;
        speed = Math.random()+0.5;
        
        name = "K" + productionNumber;
    }
    public void attack(Simulation s){
        ArrayList<Robot> rs = s.getLowestSpeed3(!isRedTeam);
        ArrayList<Robot> discarded = rs;
        System.out.println(this.name +  " attacks following targets: ");
        for(Robot r: rs){
            System.out.print(r.name + " ");
        }
        System.out.println();
        for(int i=0; i<discarded.size(); i++){
            System.out.println(displayAttack(rs.get(i)));
            if(rs.get(i).getHitAndDestroyed(attack)){
                s.removeRobot(rs.get(i));
            }
        }
    }    
}
